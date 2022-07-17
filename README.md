# Pokemon-API
I created this API as a way to put all the things I've been learning into action. You're able to: 
* Get a list of all the trainers in the database
* Add trainers 
* Delete trainers 
* Get Pokemon by trainer 
* Add Pokemon to a trainer 
* Delete Pokemon from a trainer 
* Trade Pokemon between two trainers
* Add moves to a Pokemon
* Delete moves from a Pokemon

The first thing I did was create models for Trainer, Pokemon, Move, and Trade. During this, I learned about Lombok and implemented some of its annotations on my models
to reduce boilerplate code. The annotations I learned about were:
* @Getter/@Setter: Lombok creates Getters and Setters for you behind the scenes so you don't have to clutter your code with them
* @Data: Lombok creates Getters, Setters, RequiredArgsConstructor (generates a constructor with required arguments - uninitialized final fields), 
overrides toString and equals and hashcode methods. 
* @AllArgsConstructor: Lombok creates an all-args conctructor, which requires one argument for every field in the class.
* @NoArgsConstructor: Lombok creates a constructor with no parameters.
* @Builder: Lombok allows you to implement the builder pattern without all the boilerplate code. 

Some of the Spring annotations used in the models were: 
* @Document: Marks a particular class as a domain object that we want to persist in MongoDB.
* @Id: Specifies the primary key of an entity.

Next, I created a Controller class for Trainer. The job of a controller is to handle requests from the client and pass them on to the service.
The annotations used on the controller were:
* @RestController: Spring will manage the class as a controller. Also includes @ResponseBody, which tells a controller that the object returned is automatically
 serialized into JSON and passed back into the HttpResponse object.
* @AllArgsConstructor: Lombok creates an all-args conctructor, which requires one argument for every field in the class.
* @GetMapping: Handles the HTTP GET requests matched with a given URI (Uniform Resource Identifier) expression.
* @PostMapping: Handles the HTTP POST requests matched with a given URI (Uniform Resource Identifier) expression.
* @DeleteMapping: Handles the HTTP DELETE requests matched with a given URI (Uniform Resource Identifier) expression.
* @PutMapping: Handles the HTTP PUT requests matched with a given URI (Uniform Resource Identifier) expression.
* @PathVariable: Used to handle template variables in the request URI mapping and set them as method parameters.
* @RequestBody: Maps the HttpRequest body to a transfer or domain object, enabling automatic deserialization of the inbound HttpRequest body into a Java object.

Next, a Service class was created for Trainer. Classes marked with the @Service annotation indicate that they're holding business logic.  
The service will send requests to the repository.

A repository was created, which extends the Mongo Repository. The repository submits queries to the database to perform an operation. The database will return 
the result of that operation to the repository. I used Docker to run a MongoDB container for this API. I used Postman to create a collection to organize and document
requests that the API serves.

Tests were created for the Controller and Service using JUnit, AssertJ, and Mockito. 
The annotations used were:
* @ExtendWith(MockitoExtension.class): Attaches the Mockito extension to the class. @WebMvcTest wasn't used because that spins up the entire Spring context, 
which wasn't needed and slows things down considerably. 
* @Mock: Field will automatically be initialized with a mock instance of its type.
* @InjectMocks: Creates actual objects and injects mocked dependencies into it.
* @BeforeEach: Used to signal that the annotated method should be executed before each @Test method in the current test class.
* @Test: Tells JUnit that the method to which it is attached can be run as a test case.

MockMvc and ObjectMapper were used in testing the controller. MockMvc is a Spring test tool class that lets you test controllers without needing to start an HTTP server.
In these tests, the application context is loaded and you can test the web layer as if it's receiving the requests from the HTTP server without actually 
starting it. ObjectMapper is used to turn objects into JSON or JSON into objects. 

Testing follows a Given-When-Then format. Given is the section that lays out the pre-conditions for the test (whatever state you're assuming before you start). 
When performs the action being tested. Then checks that the post condition holds. This is usually in the form of asserting values or checking interaction with mocks.

Testing wasn't needed on the Repository because it extends MongoRepository and no new functionality was added.
