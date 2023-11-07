package sample.camel.project.processors;

import org.springframework.stereotype.Component;

@Component
public class HelloProcessor {


    public String sayHello( String input ){

        if( input.contains("Message 2")) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return "Hi! " + input;
    }

}
