package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Created by zl on 2015/8/27.
 */
@Configuration
@EnableSwagger
@EnableAutoConfiguration
public class SwaggerConfig {

	private SpringSwaggerConfig springSwaggerConfig;

	@Autowired
	public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
		this.springSwaggerConfig = springSwaggerConfig;
	}

	public SwaggerSpringMvcPlugin customImplementation() {
		return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
				.apiInfo(new ApiInfo("api", "desc", null, null, null, null)).useDefaultResponseMessages(false)
				.includePatterns("/users.*");
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select() // 选择那些路径和api会生成document
				.apis(RequestHandlerSelectors.any()) // 对所有api进行监控
				.paths(PathSelectors.any()) // 对所有路径进行监控
				.build();
	}

}