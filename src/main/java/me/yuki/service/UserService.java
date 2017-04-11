package me.yuki.service;

import me.yuki.po.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ayakura Yuki on 2017/4/10.
 */
@Service
public interface UserService {

	User get(String id);

	List<User> findList(User entity);

	List<User> findAll();

	int insert(User entity);

	int update(User entity);

	int delete(User entity);

	User findUserByName(String username);

	int changePassword(User user);

	User loginAuthorization(User user);

}
