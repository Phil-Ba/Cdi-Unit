package at.bit.hello

import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

/**
 * Created by pbayer.*/

@ApplicationScoped
class HelloWorldBean {

    @Inject
    private MessageProvider messageProvider

    String sayHelloWorld() {
        if (!messageProvider.getMessage()) {
            throw new NullPointerException('Message is not set')
        }
        "Hello World $messageProvider.message".toString()
    }

}
