package com.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@SpringBootApplication
@RestController
@EnableRedisHttpSession
public class DemoSessionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSessionApplication.class, args);
	}


	@Value("${server.port}")
	private int port;

	@RequestMapping("/set")
	public String set(String userName, HttpSession session){
		session.setAttribute("userName",userName);
		return "success";
	}

	@RequestMapping("/get")
	public String get(HttpSession session){
		return session.getAttribute("userName")+":"+port;
	}

}
