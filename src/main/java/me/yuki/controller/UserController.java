package me.yuki.controller;

import me.yuki.po.User;
import me.yuki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by Ayakura Yuki on 2017/4/10.
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/auth/login")
	public String login(String username, String password, Model model, HttpSession session) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		User confirm = userService.loginAuthorization(user);
		if (confirm != null) {
			model.addAttribute("user", confirm);
			session.setAttribute("user", confirm);
			return "success";
		}
		else {
			model.addAttribute("username", username);
			return "error";
		}
	}

	@GetMapping("/auth/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "login";
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
