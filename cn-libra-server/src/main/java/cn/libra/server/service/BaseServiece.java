package cn.libra.server.service;

import cn.libra.server.bean.User;
import cn.libra.server.dao.UserMapper;
import cn.libra.utils.util.Base64Util;
import cn.libra.utils.util.StringUtil;
import cn.libra.utils.util.exception.ControllerException;
import cn.libra.utils.util.redis.RedisUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;

import java.util.Date;


@Component @Transactional(readOnly = true) public class BaseServiece {

	@Autowired UserMapper userMapper;


	@Autowired RedisUtil redisUtil;


	/**
	 * API: server_base_login / 中文名
	 *
	 * @program:params
	 * @author: sx
	 **/
	public JSONObject login(JSONObject params)  {
		String loginName = params.getString("loginName");
		String password = params.getString("password");

		redisUtil.set(loginName,password);
		redisUtil.set(loginName,"5555555555");
		Object obj = redisUtil.get(loginName);
		System.out.println(StringUtil.getNullStr(obj));

//		UserExample userExample = new UserExample();
//		userExample.createCriteria().andAccEqualTo(acc);
		//		List<User> userList = userMapper.selectByExample(userExample);
		//		if (userList.isEmpty()){
		//			throw  new ControllerException("账号不存在");
		//		}
		//		User user = userList.get(0);
		//
		//		if (!user.getPass().equals(pass)){
		//			throw  new ControllerException("密码错误");
		//		}

		User user = userMapper.findByAcc(loginName);
		if (user == null) {
			throw new ControllerException("账号不存在");
		}
		if (!user.getPass().equals(password)) {
			throw new ControllerException("密码错误");
		}

		JSONObject jsonObject = new JSONObject();
		Date date = new Date();

		String token = Base64Util.encode("loginName:"+loginName+";"+"loginTime:"+StringUtil.getNullStr(date)+";"+"xuhan;");


		redisUtil.set("token",token,(long)1);

		jsonObject.put("token",token);


		return jsonObject;
	}




}
