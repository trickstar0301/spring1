package com.example.spring.config;

import com.example.spring.controller.CustomerRestController;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAsync
@EnableAutoConfiguration
@Configuration
@EnableWebMvc
@EnableSwagger2 // swagger(v2)を有効にする
@ComponentScan(basePackages = "spring")
@ComponentScan(basePackageClasses = {
        CustomerRestController.class
})
public class AppConfig extends WebMvcConfigurerAdapter {
    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
//                .paths(paths())
                .paths(PathSelectors.any())
                .build();
    }

//    private Predicate<String> paths() {
//
//        // 仕様書生成対象のURLパスを指定する
//        return Predicates.and(
//                Predicates.not(Predicates.containsPattern("/hogehoge-view")),
//                Predicates.or(
//                        Predicates.containsPattern("/customers")));
//    }
//
//    private ApiInfo apiInfo() {
//        ApiInfo apiInfo = new ApiInfo(
//                "HogeHoge System Web API",              // title
//                "HogeHoge System の Web API 仕様書",    // description
//                "0.0.1",                                // version
//                "",                                     // terms of service url
//                "HogeHoge",                             // created by
//                "HogeHoge Co. Ltd",                     // license
//                "");                                    // license url
//        return apiInfo;
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}