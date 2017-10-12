package camus.lacan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket aliteracaoApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("aliteracao-api").select()
				.apis(RequestHandlerSelectors.basePackage("camus.lacan.controllers")).paths(regex("/aliteracao.*"))
				.build().apiInfo(metaData());
	}

	// After the Docket bean is defined, its select() method returns an instance of
	// ApiSelectorBuilder, which provides a way to control the endpoints exposed by
	// Swagger.
	@Bean
	public Docket escansaoApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("escansao-api").select()
				.apis(RequestHandlerSelectors.basePackage("camus.lacan.controllers")).paths(regex("/escansao.*"))
				.build().apiInfo(metaData());
	}

	@Bean
	public Docket separacaoApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("separacao-api").select()
				.apis(RequestHandlerSelectors.basePackage("camus.lacan.controllers")).paths(regex("/separacao.*"))
				.build().apiInfo(metaData());
	}

	@Bean
	public Docket tonicidadeApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("tonicidade-api").select()
				.apis(RequestHandlerSelectors.basePackage("camus.lacan.controllers")).paths(regex("/tonicidade.*"))
				.build().apiInfo(metaData());
	}

	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo("{camus - cã.mí}", "REST API para algoritmos que sirvam à lingua portuguesa",
				"3.0", "", new Contact("jpontesmartins", "https://github.com/jpontesmartins/", ""), "", "");
		return apiInfo;
	}
}
