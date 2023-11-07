package sample.camel.project;

import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CamelServerApplication {

	@Autowired
    private CamelContext context;


    @PostConstruct
    public void init() throws Exception {
       // context.addComponent("jms", jmsComp);
    }

	public static void main(String[] args) {
		SpringApplication.run(CamelServerApplication.class, args);
	}


}
