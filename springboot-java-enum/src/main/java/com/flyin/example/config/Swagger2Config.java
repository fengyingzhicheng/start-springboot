package com.flyin.example.config;

/**
 * @author 王军
 * @description
 * @date 2022/1/9 19:47
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author qiyu
 */
@EnableSwagger2
@Configuration
public class Swagger2Config {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)        // 文档类型，不用理会，就是用SWAGGER_2
                .apiInfo(apiInfo()).select()                  // 接口文档信息设置，抽取到apiInfo()进行设置
                .apis(RequestHandlerSelectors.any()).build(); // Controller的扫描规则：对所有Controller生成接口文档
    }

    /**
     * 接口文档信息设置
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("一拳有限公司私密文档")
                .contact(new Contact("bravo1988", null, null))
                .description("测试swagger2文档")
                .version("1.0")
                .build();
    }
}