package Projects.Marselle;

import Projects.Marselle.models.furniture.standartPositions.materials.Chipboard;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MarselleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarselleApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public Chipboard chipboard() {
		return new Chipboard();
	}

//	@Bean
//	public WorkParser workParser() {
//		return new WorkParser();
//	}

}
