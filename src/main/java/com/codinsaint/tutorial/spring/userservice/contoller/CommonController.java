package com.codinsaint.tutorial.spring.userservice.contoller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codinsaint.tutorial.spring.userservice.config.AppDetails;

@RestController
@RequestMapping("v1")
public class CommonController {
	@Value("${spring.application.name}")
	private String applicationName;

	@Autowired
	private Environment env;

	@Autowired
	private AppDetails appDetails;

	@RequestMapping("random-values")
	public Map<String, String> appRandom() {
		Map<String, String> appRandom = new LinkedHashMap<>();
		appRandom.put("random", env.getProperty("app.random"));
		appRandom.put("randomInteger", env.getProperty("app.random.integer"));
		appRandom.put("randomLong", env.getProperty("app.random.long"));
		appRandom.put("randomUUID", env.getProperty("app.random.uuid"));
		appRandom.put("randomLessThanHundred", env.getProperty("app.random.less.than.hundred"));
		appRandom.put("randomWithinRange", env.getProperty("app.random.within.range"));
		return appRandom;
	}

	@RequestMapping("app-info")
	public Map<String, String> appInfo() {
		Map<String, String> appInfo = new LinkedHashMap<>();
		appInfo.put("name", env.getProperty("app.name"));
		appInfo.put("version", env.getProperty("app.version"));
		appInfo.put("description", env.getProperty("app.description"));
		return appInfo;
	}

	@RequestMapping("app-name")
	public String appName() {
		// return applicationName;4
		return env.getProperty("spring.application.name");

	}

	@RequestMapping("app-details")
	public AppDetails appDetails() {
		return appDetails;
	}
}
