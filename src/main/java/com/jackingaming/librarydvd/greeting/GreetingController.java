package com.jackingaming.librarydvd.greeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    public GreetingController() {
    }

    /**
     * Below are excerpts from: https://spring.io/guides/gs/rest-service/
     *
     * ***** Create a Resource Controller *****
     * The @GetMapping annotation ensures that HTTP GET requests to /greeting are mapped to
     * the greeting() method.
     *
     * The @RequestParam annotation binds the value of the query string parameter name into
     * the name parameter of the greeting() method. If the name parameter is absent in the
     * request, the defaultValue of World is used.
     *
     * The implementation of the method body creates and returns a new Greeting object with
     * id and content attributes based on the next value from the counter and formats the
     * given name by using the greeting template.
     *
     * A key difference between a traditional MVC controller and the RESTful web service controller
     * shown earlier is the way that the HTTP response body is created. Rather than relying on
     * a view technology to perform server-side rendering of the greeting data to HTML, this
     * RESTful web service controller populates and returns a Greeting object. The object data will
     * be written directly to the HTTP response as JSON.
     *
     * This code uses Spring @RestController annotation, which marks the class as a controller
     * where every method returns a domain object instead of a view. It is shorthand for including
     * both @Controller and @ResponseBody.
     *
     * The Greeting object must be converted to JSON. Thanks to Spring’s HTTP message converter
     * support, you need not do this conversion manually. Because Jackson 2 is on the classpath,
     * Spring’s MappingJackson2HttpMessageConverter is automatically chosen to convert the
     * Greeting instance to JSON.
     *
     * ***** Test the Service *****
     * Now that the service is up, visit http://localhost:8080/greeting, where you should see:
     * {"id":1,"content":"Hello, World!"}
     *
     * Provide a name query string parameter by visiting http://localhost:8080/greeting?name=User.
     * Notice how the value of the content attribute changes from Hello, World! to Hello, User!
     * {"id":2,"content":"Hello, User!"}
     *
     * This change demonstrates that the @RequestParam arrangement in GreetingController is
     * working as expected. The name parameter has been given a default value of World but
     * can be explicitly overridden through the query string.
     *
     * Notice also how the id attribute has changed from 1 to 2. This proves that you are
     * working against the same GreetingController instance across multiple requests and that
     * its counter field is being incremented on each call as expected.
     */
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}