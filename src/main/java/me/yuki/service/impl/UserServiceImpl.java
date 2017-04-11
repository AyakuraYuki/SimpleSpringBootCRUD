package me.yuki.service.impl;

import me.yuki.dao.UserDao;
import me.yuki.po.User;
import me.yuki.service.UserService;
import me.yuki.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ayakura Yuki on 2017/4/10.
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
	private UserDao dao;

	@Override
	public User get(String id) {
		return dao.get(id);
	}

	@Override
	public List<User> findList(User user) {
		return dao.findList(user);
	}

	@Override
	public List<User> findAll() {
		return dao.findAll();
	}

	@Override
	public int insert(User user) {
		return dao.insert(user);
	}

	@Override
	public int update(User user) {
		return dao.update(user);
	}

	@Override
	public int delete(User user) {
		return dao.delete(user);
	}

	@Override
	public User findUserByName(String username) {
		return dao.findUserByName(username);
	}

	@Override
	public int changePassword(User user) {
		user.setPassword(PasswordUtils.Encrypt(user.getPassword(), PasswordUtils.SHA256));
		return dao.changePassword(user);
	}

	@Override
	public User loginAuthorization(User user) {
		return dao.loginAuthorization(user);
	}

}
