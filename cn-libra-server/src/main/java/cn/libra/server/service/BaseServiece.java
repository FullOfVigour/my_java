package cn.libra.server.service;

import cn.libra.server.bean.User;
import cn.libra.server.bean.UserExample;
import cn.libra.server.dao.UserMapper;
import cn.libra.utils.util.exception.ControllerException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component @Transactional(readOnly = true) public class BaseServiece {

	@Autowired UserMapper userMapper;

	/**
	 * API: server_base_login / 中文名
	 *
	 * @program:params
	 * @author: sx
	 **/
	public String login(JSONObject params) {
		String acc = params.getString("acc");
		String pass = params.getString("pass");

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

		User user = userMapper.findByAcc(acc);
		if (user == null) {
			throw new ControllerException("账号不存在");
		}
		if (!user.getPass().equals(pass)) {
			throw new ControllerException("密码错误");
		}

		return "SUCCESS";
	}

}
