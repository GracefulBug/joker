package com.life.joker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zhengdeqi
 * @description RabbitMQ 配置
 * @date 2021/7/1
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // http://localhost:8080/joker/doc.html

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                // 设置全局参数
//                .globalRequestParameters(parameters)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.life.joker.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("joker服务接口文档")
                        .description("joker服务0.0.1版本接口文档")
                        .version("0.0.1")
                        .contact(new Contact("zhengdeqi", "", "1587388110@qq.com"))
                        .license("The Apache License")
                        .build());
    }


}