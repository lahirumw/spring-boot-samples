# Spring boot JUnit Testing

Within this module, you'll find a comprehensive overview of Spring Boot JUnit and how it work.

@SpringBootTest - used to load the application context and configure the environment.

### Controller layer Unit Test
@ExtendWith(SpringExtension.class) - @ExtendWith annotation is used to register extensions for JUnit5 test, SpringExtension.class allows the test to load the Spring context and inject dependencies into the test class.

@WebMvcTest - used for testing the web layer of a Spring MVC application. This annotation is used to test the web layer in isolation, without loading the entire application context. This annotaion required when you test the controller class. Further, The MockMvc instance is injected using @Autowired, which is used to perform HTTP requests and assertions.

When you have a dependency in controller @MockBean will help you to create and inject service dependancy in to the controller test class. 

### Service layer unit test
@ExtendWith(MockitoExtension.class) is required when run unit test for service class. It tells JUnit 5 to load the Mockito framework and enable mocking of dependencies in the test. You can include SpringExtension.class insead of MockitoExtension.class. But since this is service layer, you don't need to load spring context and it will add a extra delay as it loading the context.
If there are any dependencies in service layer, @Mock annotation is used to create a mock object of the dependency.

### Repository layer unit test
When a test class is annotated with @DataJpaTest, it configures an in-memory H2 database and loads only the necessary Spring beans required for testing the persistence layer. These beans include the EntityManager, DataSource, EntityManagerFactory, and JpaRepository beans.
Also need to add @ExtendWith(SpringExtension.class) to load the spring context.
@AutoConfigureTestDatabase annotation is used to configure the test database used by the test class. The Replace.NONE option is used to specify that the default test database should not be replaced.
The TestEntityManager is injected using @Autowired, which is used to interact with the in-memory database. 
