package br.com.tgf.orcamento.orcamentoapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class OrcamentoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrcamentoApiApplication.class, args);
	}

	@RestController(value = "/")
	class Root {

		@Value("${application.version}")
		String versao;

		@Value("${spring.application.name}")
		String nomeDaAplicacao;

		@GetMapping
		public String versao() {
			return nomeDaAplicacao + " " + versao;
		}
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

}
