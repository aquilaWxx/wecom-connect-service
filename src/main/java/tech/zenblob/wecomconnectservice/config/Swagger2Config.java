package tech.zenblob.wecomconnectservice.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 插件集成配置
 *
 * @author jishenghua
 * @version 1.0
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
public class Swagger2Config implements WebMvcConfigurer {

    @Bean(value = "defaultApi")
    public Docket docketDefault() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("企业微信交互组件")
                .version("V3.0")
                .contact(new Contact("Aquila", null, null))
                .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("通用/公用")
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("tech.zenblob.wecomconnectservice.controller"))
                .paths(PathSelectors.any())
                .build();
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 注册 Swagger 页面资源路径
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}

