package com.mobiliya.expensemanager.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Class Swagger2Config.
 *
 * @author Nitin
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
	 
 	/** The logger. */
 	Logger logger = LoggerFactory.getLogger(Swagger2Config.class);
	
	/**
	 * Api.
	 *
	 * @return the docket
	 */
	@Bean
	public Docket api() {
		logger.info("Returning the Docket Object");
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.mobiliya.expensemanager.controller"))
				 .paths(PathSelectors.regex("/expensemanager/.*"))
		            .build().apiInfo(apiEndPointsInfo());
	}
	
	/**
	 * Api end points info.
	 *
	 * @return the api info
	 */
	private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Spring Boot REST API")
            .description("Expense Manager REST API")
            .contact(new Contact("Nitin Nawale", "www.mobiliya.com", "nitin.nawale@mobiliya.com"))
            .license("Apache 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
            .version("1.0.0")
            .build();
    }
}
