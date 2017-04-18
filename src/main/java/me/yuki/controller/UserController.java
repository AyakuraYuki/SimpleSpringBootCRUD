package me.yuki.controller;

import me.yuki.po.User;
import me.yuki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Ayakura Yuki on 2017/4/10.
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/auth/login/{username}/{password}")
	public String login(@PathVariable String username, @PathVariable String password, Model model) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		User confirm = userService.loginAuthorization(user);
		if (confirm != null) {
			model.addAttribute("user", confirm);
			return "success";
		}
		else {
			model.addAttribute("username", username);
			return "error";
		}
	}

	@RequestMapping("/auth/loginByJson/{username}/{password}")
	@ResponseBody
	public User loginByJson(@PathVariable String username, @PathVariable String password, Model model) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		User confirm = userService.loginAuthorization(user);
		if (confirm != null) {
			return confirm;
		}
		else {
			return null;
		}
	}

}
