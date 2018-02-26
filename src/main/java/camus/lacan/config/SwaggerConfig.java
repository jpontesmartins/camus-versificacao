package camus.lacan.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String SEPARACAO = "/separacao.*";
	private static final String TONICIDADE = "/tonicidade.*";
	private static final String ESCANSAO = "/escansao.*";
	private static final String ALITERACAO = "/aliteracao.*";
	private static final String ANAFORA = "/anafora.*";
	
	private static final String PACKAGE = "camus.lacan.domain";

	@Bean
	public Docket anaforaApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("anafora-api").select()
				.apis(RequestHandlerSelectors.basePackage(PACKAGE)).paths(regex(ANAFORA)).build()
				.apiInfo(metaData());
	}

	@Bean
	public Docket aliteracaoApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("aliteracao-api").select()
				.apis(RequestHandlerSelectors.basePackage(PACKAGE)).paths(regex(ALITERACAO)).build()
				.apiInfo(metaData());
	}

	@Bean
	public Docket escansaoApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("escansao-api").select()
				.apis(RequestHandlerSelectors.basePackage(PACKAGE)).paths(regex(ESCANSAO)).build()
				.apiInfo(metaData());
	}

	@Bean
	public Docket separacaoApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("separacao-api").select()
				.apis(RequestHandlerSelectors.basePackage(PACKAGE)).paths(regex(SEPARACAO)).build()
				.apiInfo(metaData());
	}

	@Bean
	public Docket tonicidadeApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("tonicidade-api").select()
				.apis(RequestHandlerSelectors.basePackage(PACKAGE)).paths(regex(TONICIDADE)).build()
				.apiInfo(metaData());
	}

	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo("{camus - cã.mí}", "REST API para algoritmos que sirvam à lingua portuguesa",
				"3.0", "", new Contact("jpontesmartins", "https://github.com/jpontesmartins/", ""), "", "");
		return apiInfo;
	}
}
