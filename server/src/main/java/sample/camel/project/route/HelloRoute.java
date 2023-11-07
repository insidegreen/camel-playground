package sample.camel.project.route;

import org.apache.camel.ExchangePattern;
import org.apache.camel.Expression;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.camel.project.processors.HelloProcessor;

@Component
public class HelloRoute extends RouteBuilder {

    @Autowired
    private HelloProcessor hello;
    @Override
    public void configure() throws Exception {

        from( "jms:queue:hello?exchangePattern=InOut&concurrentConsumers=20" ).
                bean( hello, "sayHello").
                log( LoggingLevel.DEBUG, "message: ${body}" ).end();


    }

}
