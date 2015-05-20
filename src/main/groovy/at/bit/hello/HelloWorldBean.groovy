package at.bit.hello

import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

/**
 * Created by pbayer.*/

@ApplicationScoped
class HelloWorldBean {

    @Inject
    MessageProvider messageProvider

    String sayHelloWorld() {
        if (!messageProvider.getMessage()) {
            throw new NullPointerException('No message is provided')
        }
        "Hello World $messageProvider.message".toString()
    }

}
