package sample.camel.client;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CamelClientApplication {

	@Autowired
    private CamelContext context;

    @PostConstruct
    public void init() throws Exception {



        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);
        executor.setMaxPoolSize(20);
        executor.initialize();

        for (int i = 0; i < 20; i++) {
            String message = "Message " + i;
            executor.execute( () -> {
                if(  !context.isStarted() ){
                    try {
                        Thread.sleep( 1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                ProducerTemplate template = context.createProducerTemplate();
                String result = template.requestBody("direct:hello", message , String.class);

                System.out.println("Request: " + message + "  got result: " + result);
                System.out.flush();
            });
        }

    }

	public static void main(String[] args) {
		SpringApplication.run(CamelClientApplication.class, args);
	}

}
