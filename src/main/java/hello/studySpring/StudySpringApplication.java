package hello.studySpring;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class StudySpringApplication {

	

	public static void main(String[] args) {
			Logger logger = LoggerFactory.getLogger(StudySpringApplication.class.getName());

			SpringApplication.run(StudySpringApplication.class, args);
			logger.info("hi");
	}

}
