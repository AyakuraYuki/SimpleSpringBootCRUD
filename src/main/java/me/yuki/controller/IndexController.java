package me.yuki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ayakura Yuki on 2017/4/10.
 */
@Controller
public class IndexController {

	@RequestMapping("/")
	String index(Model model) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		model.addAttribute("welcome", "Now " + sdf.format(new Date()));
		return "index";
	}

}
