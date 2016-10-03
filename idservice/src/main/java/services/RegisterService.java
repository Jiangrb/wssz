package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.User;
import mapper.UserMapper;

@Service("registerService")
public class RegisterService {

	@Autowired
	UserMapper userMapper;

	public boolean addNewUser(User user) {
		String uuid = "1dfdsklfjdslfkjd";
		user.setId(uuid);
		return userMapper.insert(user) > 0;
	}

}
