### ✅ Project-Based Interview Sections & Sample Questions

#### 1. General Project Understanding
| Question | Intent |
|---------|--------|
| What problem does your project solve? | Checks clarity of goal |
| How many users does it scale to? | Understands your load thinking |
| Why did you choose this tech stack? | Justification of design choices |
| What architecture did you follow? | Layered/Microservice explanation |
| Can you walk me through the flow of a checkout request? | End-to-end flow understanding |

#### 2. API Design
| Question | Intent |
|---------|--------|
| How did you design your REST APIs? | RESTful principles |
| What status codes do you use and why? | HTTP fundamentals |
| How do you handle invalid inputs? | Validation strategy |
| What tools did you use to document your APIs? | Swagger/Postman awareness |
| How do you version your APIs? | Forward compatibility |

#### 3. Database & JPA
| Question | Intent |
|---------|--------|
| How did you design the database schema? | DB design skills |
| Can you explain your entity relationships? | ER modeling |
| How do you manage transactions? | ACID principles, @Transactional |
| How do you prevent N+1 queries? | Hibernate optimization |
| Did you write native queries? Why? | Complex querying awareness |

#### 4. Spring Boot Internals
| Question | Intent |
|---------|--------|
| How does dependency injection work in Spring? | IOC/DI understanding |
| What are common annotations used in your project? | Annotation familiarity |
| How do you handle exceptions? | @ControllerAdvice handling |
| What is the lifecycle of a Spring Bean? | Core concept |
| Difference between @Component, @Service, @Repository? | Layer responsibilities |

#### 5. Redis (Caching)
| Question | Intent |
|---------|--------|
| Why did you use Redis? | Performance justification |
| What did you cache and why? | Selective caching |
| How do you invalidate cache entries? | TTL, eviction |
| Did you use Redis for pub/sub? | Advanced usage |
| Is Redis persistent? | Storage mode awareness |

#### 6. Kafka (Event Processing)
| Question | Intent |
|---------|--------|
| Why Kafka and not RabbitMQ? | Design decision clarity |
| How do you publish an event? | Producer-side logic |
| How do you consume events? | Consumer implementation |
| What happens if Kafka goes down? | Fault tolerance |
| What is an offset? | Kafka internals |

#### 7. Security (JWT)
| Question | Intent |
|---------|--------|
| How did you implement authentication? | Spring Security basics |
| How does JWT work? | Token-based auth flow |
| How do you refresh expired tokens? | JWT lifecycle |
| How do you protect admin routes? | RBAC (roles) |
| How is password stored securely? | BCrypt hashing |

#### 8. Docker & Deployment
| Question | Intent |
|---------|--------|
| Why did you containerize your app? | Portability, infra as code |
| What does your Dockerfile look like? | Docker understanding |
| What is Docker Compose? | Multi-container deployment |
| How do you handle secrets in containers? | Env config strategy |
| Docker vs VM? | Infra fundamentals |

#### 9. AWS EC2 + S3
| Question | Intent |
|---------|--------|
| How did you deploy to EC2? | Practical AWS experience |
| What do you store in S3? | Static/file asset handling |
| How do you secure EC2? | SSH/IAM best practices |
| How do you connect Spring Boot to S3? | AWS SDK usage |
| Do you use IAM roles? | Security & access control |

#### 10. System Design
| Question | Intent |
|---------|--------|
| How would you scale your system to 1M users? | Scalability |
| What’s your DB scaling strategy? | Partitioning, replication |
| What if Kafka fails? | Fault-tolerant patterns |
| How do you avoid SPOF? | HA design |
| How does service discovery work? | Eureka/Consul concept |