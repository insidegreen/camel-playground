package sample.camel.client.route;

import org.apache.camel.ExchangePattern;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class HelloRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:hello").
                setExchangePattern(ExchangePattern.InOut).
                log( LoggingLevel.DEBUG, "Pattern: ${in.body}").
                to( "jms:queue:hello").end();

    }

}
