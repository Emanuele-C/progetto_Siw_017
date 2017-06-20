package progetto_siw_EC.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@ComponentScan({"progetto_siw_EC.run.security", "progetto_siw_EC.run"})
@EnableJpaRepositories("progetto_siw_EC.run.repository")
@EntityScan("progetto_siw_EC.run.model")
public class RunApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(RunApplication.class);
		
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RunApplication.class, args);
	}
}
