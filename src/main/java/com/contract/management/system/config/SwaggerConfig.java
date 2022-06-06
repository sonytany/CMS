package com.contract.management.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
public class SwaggerConfig
{
    @Bean
    public Docket api()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.contract.management.system"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo()
    {
        return new ApiInfoBuilder()
                .title("Contruct Management System API with Swagger")
                .description("" +
                        "보험 상품 가입 : 등록되어 있는 상품 및 담보를 기준으로 계약을 신청, 조회, 수정, 예상 총 보험료 계산을 진행합니다.\n" +
                        "Contract = 계약\n" +
                        "Product = 상품\n" +
                        "Collateral = 담보"
                )
                .version("1.0.0")
                .build();
    }
}
