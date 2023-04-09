# Spring WebFlux REST API

Create a new Spring Boot project with the "Reactive Web" dependency using the Spring Initializr.

    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-webflux</artifactId>
    </dependency>

@EnableWebFlux is a Spring annotation that enables the WebFlux framework in a Spring Boot application.
This annotation is usually added to the main application class to enable the use of reactive programming 
in the application.

@WebFluxTest is a Spring Boot test annotation used to test WebFlux controllers in a Spring Boot application.
This annotation enables the auto-configuration of the WebFlux infrastructure and sets up the necessary 
components for testing WebFlux controllers.
When @WebFluxTest is used, it creates a test context with a minimal configuration and starts an 
embedded server that listens on a random port for HTTP requests.

WebTestClient is a class provided by Spring Framework's spring-webflux module that allows you to test 
and interact with reactive web endpoints in a Spring Boot application.

