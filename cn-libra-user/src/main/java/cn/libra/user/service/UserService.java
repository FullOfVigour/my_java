package cn.libra.user.service;


import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("user_userService")
@Transactional(readOnly = true)
public class UserService {



    public JSONObject hello(JSONObject params){
        JSONObject json = new JSONObject();
        json.put("hello","hello");
        return json;

    }
}
