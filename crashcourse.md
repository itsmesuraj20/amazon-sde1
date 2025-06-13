# Amazon SDE-1 Technology Crash Course

## Table of Contents
1. [Spring Boot](#spring-boot)
2. [Spring MVC](#spring-mvc)
3. [JPA & Hibernate](#jpa--hibernate)
4. [REST APIs](#rest-apis)
5. [Spring Security](#spring-security)
6. [PostgreSQL](#postgresql)
7. [Redis](#redis)
8. [Docker](#docker)
9. [Kubernetes](#kubernetes)
10. [AWS Services](#aws-services)
11. [Apache Kafka](#apache-kafka)
12. [Interview Tips](#interview-tips)

---

## Spring Boot

### What is Spring Boot?
Spring Boot is an opinionated framework that simplifies Spring application development by providing auto-configuration, embedded servers, and production-ready features.

### Key Concepts
- **Auto-Configuration**: Automatically configures beans based on classpath dependencies
- **Starter Dependencies**: Pre-configured dependency bundles
- **Embedded Servers**: Tomcat, Jetty, or Undertow included
- **Actuator**: Production monitoring and management

### Essential Annotations
```java
@SpringBootApplication  // Combines @Configuration, @EnableAutoConfiguration, @ComponentScan
@RestController        // REST endpoint controller
@Service              // Business logic layer
@Repository          // Data access layer
@Component          // Generic Spring component
@Configuration      // Configuration class
@Bean              // Bean definition method
```

### Application Properties
```properties
# application.properties
server.port=8080
spring.datasource.url=jdbc:postgresql://localhost:5432/mydb
spring.jpa.hibernate.ddl-auto=update
spring.redis.host=localhost
spring.redis.port=6379
```

### Main Application Class
```java
@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
```

### Interview Questions
- How does Spring Boot auto-configuration work?
- Difference between @Component, @Service, @Repository?
- How to externalize configuration in Spring Boot?

---

## Spring MVC

### Architecture
- **Model**: Data and business logic
- **View**: Presentation layer
- **Controller**: Handles requests and coordinates between Model and View

### Key Components
- **DispatcherServlet**: Front controller that handles all requests
- **HandlerMapping**: Maps requests to handlers
- **ViewResolver**: Resolves view names to actual views

### Controller Example
```java
@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }
    
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
        User savedUser = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
}
```

### Request Processing Flow
1. Client sends request to DispatcherServlet
2. DispatcherServlet consults HandlerMapping
3. Controller processes request
4. Returns ModelAndView or ResponseEntity
5. ViewResolver resolves view (if needed)
6. Response sent back to client

---

## JPA & Hibernate

### Java Persistence API (JPA)
JPA is a specification for object-relational mapping in Java. Hibernate is the most popular JPA implementation.

### Key Annotations
```java
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;
    
    // getters and setters
}
```

### Repository Pattern
```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmail(String email);
    
    @Query("SELECT u FROM User u WHERE u.age > :age")
    List<User> findUsersOlderThan(@Param("age") int age);
}
```

### Entity Relationships
- **@OneToOne**: One-to-one relationship
- **@OneToMany**: One-to-many relationship
- **@ManyToOne**: Many-to-one relationship
- **@ManyToMany**: Many-to-many relationship

### Hibernate Configuration
```properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

### Best Practices
- Use lazy loading for collections
- Implement proper cascade strategies
- Use @Transactional for service methods
- Optimize queries with projections

---

## REST APIs

### REST Principles
- **Stateless**: Each request contains all necessary information
- **Cacheable**: Responses should be cacheable when appropriate
- **Uniform Interface**: Consistent resource identification
- **Layered System**: Architecture can have multiple layers

### HTTP Methods
- **GET**: Retrieve resource(s)
- **POST**: Create new resource
- **PUT**: Update entire resource
- **PATCH**: Partial update
- **DELETE**: Remove resource

### Status Codes
- **200 OK**: Successful GET, PUT, PATCH
- **201 Created**: Successful POST
- **204 No Content**: Successful DELETE
- **400 Bad Request**: Invalid request
- **404 Not Found**: Resource not found
- **500 Internal Server Error**: Server error

### REST Controller Example
```java
@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {
    
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> products = productService.findAll(pageable);
        return ResponseEntity.ok(products.getContent());
    }
    
    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
        Product saved = productService.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
```

### Exception Handling
```java
@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
        ErrorResponse error = new ErrorResponse("RESOURCE_NOT_FOUND", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
```

---

## Spring Security

### Core Concepts
- **Authentication**: Verifying user identity
- **Authorization**: Checking user permissions
- **Principal**: Currently authenticated user
- **Authority/Role**: Permission granted to user

### Security Configuration
```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/public/**").permitAll()
                .requestMatchers("/api/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated())
            .oauth2ResourceServer(oauth2 -> oauth2
                .jwt(jwt -> jwt.jwtDecoder(jwtDecoder())));
        return http.build();
    }
}
```

### JWT Implementation
```java
@Service
public class JwtService {
    
    private final String SECRET_KEY = "your-secret-key";
    
    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
    
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }
}
```

### Method-Level Security
```java
@Service
public class UserService {
    
    @PreAuthorize("hasRole('ADMIN') or #userId == authentication.principal.id")
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }
}
```

---

## PostgreSQL

### Key Features
- ACID compliance
- Advanced data types (JSON, arrays, custom types)
- Full-text search
- Excellent performance with complex queries
- Strong consistency

### Connection Configuration
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/myapp
spring.datasource.username=postgres
spring.datasource.password=password
spring.datasource.driver-class-name=org.postgresql.Driver
```

### Advanced SQL Features
```sql
-- JSON queries
SELECT data->>'name' as name FROM users WHERE data ? 'email';

-- Window functions
SELECT name, salary, 
       RANK() OVER (PARTITION BY department ORDER BY salary DESC) as rank
FROM employees;

-- Common Table Expressions
WITH RECURSIVE category_tree AS (
    SELECT id, name, parent_id, 0 as level
    FROM categories WHERE parent_id IS NULL
    UNION ALL
    SELECT c.id, c.name, c.parent_id, ct.level + 1
    FROM categories c
    JOIN category_tree ct ON c.parent_id = ct.id
)
SELECT * FROM category_tree;
```

### Performance Optimization
- Use indexes strategically
- Analyze query execution plans with EXPLAIN
- Use connection pooling
- Optimize join operations
- Consider partitioning for large tables

### JPA with PostgreSQL
```java
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> metadata;
}
```

---

## Redis

### What is Redis?
Redis is an in-memory data structure store used as database, cache, and message broker.

### Data Types
- **String**: Simple key-value pairs
- **Hash**: Maps of string fields and values
- **List**: Ordered collections of strings
- **Set**: Unordered collections of unique strings
- **Sorted Set**: Sets ordered by score
- **Stream**: Log-like data structure

### Spring Boot Redis Configuration
```properties
spring.redis.host=localhost
spring.redis.port=6379
spring.redis.password=
spring.redis.timeout=2000ms
spring.redis.lettuce.pool.max-active=8
```

### Redis Template Usage
```java
@Service
public class CacheService {
    
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    
    public void setValue(String key, Object value, Duration timeout) {
        redisTemplate.opsForValue().set(key, value, timeout);
    }
    
    public Object getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
```

### Caching with Annotations
```java
@Service
public class UserService {
    
    @Cacheable(value = "users", key = "#id")
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    
    @CacheEvict(value = "users", key = "#user.id")
    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
```

### Redis for Session Management
```java
@Configuration
@EnableRedisHttpSession
public class SessionConfig {
    // Redis will automatically handle session storage
}
```

### Use Cases
- Session storage
- Application caching
- Real-time analytics
- Message queuing
- Rate limiting

---

## Docker

### What is Docker?
Docker is a containerization platform that packages applications and dependencies into portable containers.

### Key Concepts
- **Image**: Read-only template for creating containers
- **Container**: Running instance of an image
- **Dockerfile**: Instructions for building images
- **Registry**: Storage for Docker images

### Dockerfile for Spring Boot
```dockerfile
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/myapp-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
```

### Multi-stage Build
```dockerfile
# Build stage
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Runtime stage
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/myapp-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

### Docker Compose
```yaml
version: '3.8'
services:
  app:
    build: .
    ports:
      - "8080:8080"
    environment:
      - SPRING_PROFILES_ACTIVE=docker
    depends_on:
      - postgres
      - redis
  
  postgres:
    image: postgres:13
    environment:
      POSTGRES_DB: myapp
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: password
    ports:
      - "5432:5432"
  
  redis:
    image: redis:6-alpine
    ports:
      - "6379:6379"
```

### Common Commands
```bash
# Build image
docker build -t myapp .

# Run container
docker run -p 8080:8080 myapp

# List containers
docker ps

# View logs
docker logs container-id

# Execute commands in container
docker exec -it container-id /bin/bash
```

---

## Kubernetes

### What is Kubernetes?
Kubernetes is a container orchestration platform that automates deployment, scaling, and management of containerized applications.

### Key Components
- **Pod**: Smallest deployable unit
- **Service**: Network endpoint for pods
- **Deployment**: Manages pod replicas
- **ConfigMap**: Configuration data
- **Secret**: Sensitive data
- **Ingress**: HTTP/HTTPS routing

### Deployment YAML
```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: myapp-deployment
spec:
  replicas: 3
  selector:
    matchLabels:
      app: myapp
  template:
    metadata:
      labels:
        app: myapp
    spec:
      containers:
      - name: myapp
        image: myapp:latest
        ports:
        - containerPort: 8080
        env:
        - name: SPRING_PROFILES_ACTIVE
          value: "kubernetes"
---
apiVersion: v1
kind: Service
metadata:
  name: myapp-service
spec:
  selector:
    app: myapp
  ports:
  - protocol: TCP
    port: 80
    targetPort: 8080
  type: LoadBalancer
```

### ConfigMap Example
```yaml
apiVersion: v1
kind: ConfigMap
metadata:
  name: myapp-config
data:
  database.url: "jdbc:postgresql://postgres:5432/myapp"
  redis.host: "redis"
  log.level: "INFO"
```

### Health Checks
```yaml
spec:
  containers:
  - name: myapp
    image: myapp:latest
    livenessProbe:
      httpGet:
        path: /actuator/health
        port: 8080
      initialDelaySeconds: 30
      periodSeconds: 10
    readinessProbe:
      httpGet:
        path: /actuator/health/readiness
        port: 8080
      initialDelaySeconds: 5
      periodSeconds: 5
```

### Common Commands
```bash
# Apply configuration
kubectl apply -f deployment.yaml

# Get pods
kubectl get pods

# View logs
kubectl logs pod-name

# Scale deployment
kubectl scale deployment myapp-deployment --replicas=5

# Port forward
kubectl port-forward service/myapp-service 8080:80
```

---

## AWS Services

### AWS EC2 (Elastic Compute Cloud)

#### What is EC2?
Virtual servers in the cloud that provide scalable computing capacity.

#### Key Concepts
- **Instance Types**: Different CPU, memory, storage combinations
- **AMI**: Amazon Machine Images (templates)
- **Security Groups**: Virtual firewalls
- **Key Pairs**: SSH access credentials

#### Spring Boot on EC2
```bash
# Install Java
sudo yum update -y
sudo yum install java-17-amazon-corretto -y

# Transfer and run your JAR
scp -i your-key.pem myapp.jar ec2-user@your-instance:/home/ec2-user/
ssh -i your-key.pem ec2-user@your-instance
java -jar myapp.jar
```

#### Auto Scaling Group
```json
{
  "AutoScalingGroupName": "myapp-asg",
  "MinSize": 2,
  "MaxSize": 10,
  "DesiredCapacity": 3,
  "LaunchTemplate": {
    "LaunchTemplateName": "myapp-template",
    "Version": "$Latest"
  },
  "TargetGroupARNs": ["arn:aws:elasticloadbalancing:..."]
}
```

### AWS S3 (Simple Storage Service)

#### What is S3?
Object storage service that offers scalability, data availability, security, and performance.

#### Key Concepts
- **Buckets**: Containers for objects
- **Objects**: Files stored in buckets
- **Keys**: Unique object identifiers
- **Storage Classes**: Different cost/performance tiers

#### Spring Boot S3 Integration
```xml
<dependency>
    <groupId>com.amazonaws</groupId>
    <artifactId>aws-java-sdk-s3</artifactId>
    <version>1.12.261</version>
</dependency>
```

```java
@Service
public class S3Service {
    
    private final AmazonS3 s3Client;
    
    public S3Service() {
        this.s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.US_EAST_1)
                .build();
    }
    
    public String uploadFile(String bucketName, String key, File file) {
        s3Client.putObject(bucketName, key, file);
        return s3Client.getUrl(bucketName, key).toString();
    }
    
    public S3Object downloadFile(String bucketName, String key) {
        return s3Client.getObject(bucketName, key);
    }
}
```

#### File Upload Controller
```java
@RestController
@RequestMapping("/api/files")
public class FileController {
    
    @Autowired
    private S3Service s3Service;
    
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            File convertedFile = convertMultiPartToFile(file);
            String fileName = generateFileName(file);
            String fileUrl = s3Service.uploadFile("my-bucket", fileName, convertedFile);
            convertedFile.delete();
            return ResponseEntity.ok(fileUrl);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Upload failed: " + e.getMessage());
        }
    }
}
```

### AWS Lambda

#### What is Lambda?
Serverless compute service that runs code in response to events without managing servers.

#### Key Concepts
- **Function**: Unit of code execution
- **Event**: Trigger that invokes function
- **Runtime**: Execution environment
- **Handler**: Entry point method

#### Java Lambda Function
```java
public class LambdaHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    
    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent request, Context context) {
        String body = request.getBody();
        
        // Process the request
        String response = processRequest(body);
        
        return new APIGatewayProxyResponseEvent()
                .withStatusCode(200)
                .withHeaders(Map.of("Content-Type", "application/json"))
                .withBody(response);
    }
    
    private String processRequest(String input) {
        // Your business logic here
        return "{\"message\": \"Processed successfully\"}";
    }
}
```

#### Lambda with Spring Boot
```java
@Component
public class SpringLambdaHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    
    @Autowired
    private UserService userService;
    
    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent request, Context context) {
        SpringApplication.run(Application.class);
        
        // Use Spring services
        List<User> users = userService.getAllUsers();
        
        return new APIGatewayProxyResponseEvent()
                .withStatusCode(200)
                .withBody(objectMapper.writeValueAsString(users));
    }
}
```

---

## Apache Kafka

### What is Kafka?  
Distributed streaming platform for building real-time data pipelines and streaming applications.

### Key Concepts
- **Topic**: Category of messages
- **Partition**: Ordered sequence of messages
- **Producer**: Publishes messages to topics
- **Consumer**: Subscribes to topics and processes messages
- **Broker**: Kafka server
- **Consumer Group**: Group of consumers working together

### Spring Boot Kafka Configuration
```properties
spring.kafka.bootstrap-servers=localhost:9092
spring.kafka.consumer.group-id=myapp-group
spring.kafka.consumer.auto-offset-reset=earliest
spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer=org.apache.kafka.common.serialization.StringSerializer
```

### Producer Example
```java
@Service
public class KafkaProducerService {
    
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message)
                .addCallback(
                    result -> System.out.println("Message sent: " + message),
                    failure -> System.err.println("Message failed: " + failure.getMessage())
                );
    }
    
    public void sendUserEvent(User user) {
        UserEvent event = new UserEvent(user.getId(), "USER_CREATED", user);
        kafkaTemplate.send("user-events", objectMapper.writeValueAsString(event));
    }
}
```

### Consumer Example
```java
@Component
public class KafkaConsumerService {
    
    @KafkaListener(topics = "user-events", groupId = "user-service-group")
    public void handleUserEvent(String message) {
        try {
            UserEvent event = objectMapper.readValue(message, UserEvent.class);
            processUserEvent(event);
        } catch (Exception e) {
            System.err.println("Error processing message: " + e.getMessage());
        }
    }
    
    @KafkaListener(topics = "order-events", groupId = "order-service-group")
    public void handleOrderEvent(
            @Payload String message,
            @Header Map<String, Object> headers,
            Acknowledgment acknowledgment) {
        
        try {
            // Process order event
            processOrderEvent(message);
            acknowledgment.acknowledge(); // Manual acknowledgment
        } catch (Exception e) {
            // Handle error - maybe send to DLQ
            System.err.println("Failed to process order: " + e.getMessage());
        }
    }
}
```

### Configuration Class
```java
@Configuration
@EnableKafka
public class KafkaConfig {
    
    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.ACKS_CONFIG, "all"); // Wait for all replicas
        props.put(ProducerConfig.RETRIES_CONFIG, 3);
        return new DefaultKafkaProducerFactory<>(props);
    }
    
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
```

### Error Handling
```java
@Component
public class KafkaErrorHandler {
    
    @KafkaListener(topics = "user-events")
    public void handleUserEvent(String message) {
        try {
            processMessage(message);
        } catch (Exception e) {
            // Send to dead letter topic
            kafkaTemplate.send("user-events-dlt", message);
        }
    }
    
    @RetryableTopic(
        attempts = "3",
        backoff = @Backoff(delay = 1000, multiplier = 2.0),
        dltStrategy = DltStrategy.FAIL_ON_ERROR
    )
    @KafkaListener(topics = "retry-topic")
    public void handleWithRetry(String message) {
        // This will retry 3 times with exponential backoff
        processMessage(message);
    }
}
```

---

## Interview Tips

### Technical Questions You Should Be Ready For

**Spring Boot:**
- Explain the difference between @Component, @Service, @Repository
- How does Spring Boot auto-configuration work?
- What are Spring Boot Actuators and how do you use them?
- How do you handle configuration in different environments?

**Database & JPA:**
- Explain the N+1 query problem and how to solve it
- What's the difference between EAGER and LAZY loading?
- How do you optimize database queries in Spring applications?
- Explain transaction management in Spring

**System Design:**
- How would you design a scalable microservices architecture?
- How do you handle service-to-service communication?
- Explain caching strategies you would implement
- How do you ensure data consistency across microservices?

**AWS & DevOps:**
- How do you deploy Spring Boot applications to AWS?
- Explain the difference between EC2 and Lambda
- When would you use S3 vs RDS vs DynamoDB?
- How do you implement CI/CD for Spring Boot applications?

**Performance & Scalability:**
- How do you handle high traffic in Spring Boot applications?
- Explain connection pooling and its importance
- How do you implement caching in your applications?
- What metrics do you monitor in production applications?

### Coding Best Practices

**Clean Code:**
- Use meaningful variable and method names
- Keep methods small and focused
- Implement proper error handling
- Write comprehensive tests

**Spring Boot Specific:**
- Use appropriate annotations (@Service, @Repository, etc.)
- Implement proper exception handling with @ControllerAdvice
- Use validation annotations (@Valid, @NotNull, etc.)
- Follow REST API conventions

**Security:**
- Never hardcode secrets or passwords
- Implement proper authentication and authorization
- Use HTTPS in production
- Validate all user inputs

### Sample System Design Question

**"Design a URL shortener service like bit.ly"**

**Requirements:**
- Shorten long URLs
- Redirect to original URL
- Handle 100M URLs per day
- Analytics on clicks

**High-Level Architecture:**
```
Load Balancer → API Gateway → Microservices
                              ↓
                    [URL Service] [Analytics Service]
                              ↓           ↓
                         PostgreSQL   Kafka → Analytics DB
                              ↓
                            Redis (Cache)
```

**Technologies Used:**
- Spring Boot for microservices
- PostgreSQL for URL storage
- Redis for caching popular URLs
- Kafka for real-time analytics
- Docker + Kubernetes for deployment
- AWS EC2/ECS for hosting

**Database Schema:**
```sql
CREATE TABLE urls (
    id BIGSERIAL PRIMARY KEY,
    short_code VARCHAR(10) UNIQUE NOT NULL,
    original_url TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    expires_at TIMESTAMP,
    user_id BIGINT,
    click_count INTEGER DEFAULT 0
);

CREATE INDEX idx_short_code ON urls(short_code);
CREATE INDEX idx_user_id ON urls(user_id);
```

### Final Preparation Checklist

- [ ] Build 2-3 complete projects showcasing these technologies
- [ ] Practice explaining your code and architectural decisions
- [ ] Understand trade-offs between different approaches
- [ ] Be ready to write code on whiteboard/shared screen
- [ ] Practice system design questions
- [ ] Understand Amazon's Leadership Principles
- [ ] Prepare questions about the role and team
- [ ] Review your resume and be ready to discuss any mentioned technology

### Resources for Continued Learning

- **Official Documentation**: Always refer to official docs for latest features
- **GitHub Projects**: Build and showcase your work
- **LeetCode**: Practice coding problems
- **System Design Interview books**: "Designing Data-Intensive Applications"
- **AWS Documentation**: Understand services you'll be using
- **Spring Boot Guides**: Official getting started guides

Remember: Amazon values candidates who can learn quickly, think systematically, and write clean, maintainable code. Focus on understanding the "why" behind each technology choice, not just the "how".