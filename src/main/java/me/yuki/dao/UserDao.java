package me.yuki.dao;

import me.yuki.po.User;
import org.springframework.stereotype.Component;

/**
 * Created by Ayakura Yuki on 2017/4/10.
 */
@Component
public interface UserDao extends BaseDao<User> {

	User findUserByName(String username);

	int changePassword(User user);

	User loginAuthorization(User user);
}
