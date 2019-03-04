package cn.libra.inter.controller;

import cn.libra.inter.service.LibraService;
import cn.libra.utils.util.*;
import cn.libra.utils.util.exception.ControllerException;
import cn.libra.utils.util.redis.RedisUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;


@Component
@Path("pc")
public class LibraController implements DubboCotroller {
    @Autowired
    LibraService libraService;
    @Autowired
    RedisUtil redisUtil;

    private final static String TOURIST = "TOURIST";

    private final static List<String> ApisForLogin= Arrays.asList("server_base_login", "bar", "baz");



    @POST
    @Path("{childrenName}_{serviceName}_{methodName}")
    @ResponseBody
    @Produces({MediaType.APPLICATION_JSON + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8", MediaType.TEXT_XML + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8"})
    public JSONObject callController(String paramsStr, @Context HttpServletRequest httpServletRequest, @Context HttpServletResponse httpServletResponse, @PathParam("childrenName") String childrenName, @PathParam("serviceName") String serviceName, @PathParam("methodName") String methodName) throws Exception {

        System.out.println("\n\n\n刚进来的paramsStr：" + paramsStr+"\n\n\n");

        // 对前台数据根据进行转码,将其解析为 json 类型的 String
        paramsStr = URLDecoder.decode(paramsStr);


        System.out.println("\n\n\n转译之后的paramsStr：" + paramsStr+"\n\n\n");


        if (paramsStr.indexOf("apiparams=") > -1) {
            paramsStr = paramsStr.replaceFirst("apiparams=", "");
        }

        JSONObject params = JSONObject.parseObject(paramsStr);

        params = initParams(params);

        String token = params.getString("accessToken");


        String type = params.getString("userType");

        String controllerPath = childrenName + "_" + serviceName + "_" + methodName;

        // 当 accessToken 为空时,对不同接口进行不同处理
        if(StringUtil.isEmpty(token)){

            // 非登入接口
            if (!ApisForLogin.contains(controllerPath)){
                throw new ControllerException(505,"登入信息过期,请重新登入");
            }
            else {

            }
        }
        else if(StringUtil.isEmpty(StringUtil.getNullStr(redisUtil.get(token)))){
            throw new ControllerException(505,"登入信息过期,请重新登入");
        }



        JSONObject jsonObject = makeSuccessJson(params, childrenName, serviceName, methodName, controllerPath);



        String s = jsonObject.toString();

//        jsonObject.put("token",StringUtil.getNullStr(redisUtil.get(token)));

        return jsonObject;
    }

    private JSONObject makeSuccessJson(JSONObject paramsStr, String childrenName, String serviceName, String methodName, String controllerPath) throws Exception {
        JSONObject requestJson = libraService.callChildren(childrenName, serviceName, methodName, paramsStr);


        requestJson.put("controllerPath", controllerPath);
        return requestJson;
    }

    private JSONObject initParams(JSONObject paramsStr) {
        if (paramsStr == null) {
            paramsStr = new JSONObject();
        }
        paramsStr = paramsStr.getJSONObject("params");
        if (paramsStr == null) {
            paramsStr = new JSONObject();
        }
        return paramsStr;
    }

    @POST
    @Path("base_upload")
    @ResponseBody
    @Produces({MediaType.APPLICATION_JSON + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8", MediaType.TEXT_XML + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8"})
    public String upload(@Context HttpServletRequest httpServletRequest,@Context HttpServletResponse httpServletResponse) throws Exception {

        FileUploadUtil fileUploadUtil = new FileUploadUtil(httpServletRequest);
        String upload = fileUploadUtil.Upload();
        return upload;
    }





}




