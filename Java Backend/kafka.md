# Apache Kafka Learning Guide for Java Backend Developers

## Essential Level (Must Know)

### 1. Kafka Fundamentals
- **What is Apache Kafka**
  - Event streaming platform concepts
  - Pub/Sub messaging vs traditional message queues
  - Use cases: event sourcing, real-time analytics, microservices communication
- **Core Concepts**
  - Topics, partitions, and offsets
  - Producers, consumers, and brokers
  - Messages (records) and serialization
  - Replication and fault tolerance

### 2. Kafka Architecture
- **Cluster Components**
  - Brokers and broker leadership
  - ZooKeeper coordination (traditional) vs KRaft mode
  - Topic partitioning and distribution
- **Data Flow**
  - Producer to broker communication
  - Consumer group coordination
  - Offset management and tracking

### 3. Java Producer API
- **Basic Producer Implementation**
  - KafkaProducer configuration
  - Sending messages synchronously vs asynchronously
  - Message keys, values, and headers
- **Producer Configuration**
  - Bootstrap servers, serializers
  - Acks, retries, and idempotence
  - Batch size and linger time optimization
- **Error Handling**
  - Retry mechanisms and dead letter topics
  - Producer exceptions and handling
  - Callback and future-based error handling

### 4. Java Consumer API
- **Basic Consumer Implementation**
  - KafkaConsumer configuration
  - Subscribing to topics and polling
  - Manual vs automatic offset commits
- **Consumer Groups**
  - Partition assignment and rebalancing
  - Consumer group coordination
  - Scaling consumers horizontally
- **Offset Management**
  - Commit strategies (auto vs manual)
  - Seeking to specific offsets
  - Handling duplicate processing

### 5. Serialization and Deserialization
- **Built-in Serializers**
  - String, Integer, Long, ByteArray serializers
  - JSON serialization with ObjectMapper
- **Avro Integration**
  - Schema Registry concepts
  - Avro serialization and evolution
  - Backward/forward compatibility
- **Custom Serializers**
  - Implementing custom serialization logic
  - Protocol Buffers integration

## Intermediate Level (Should Know)

### 6. Advanced Producer Patterns
- **Transactional Producers**
  - Exactly-once semantics (EOS)
  - Transaction boundaries and commits
  - Idempotent producers
- **Partitioning Strategies**
  - Custom partitioners
  - Key-based partitioning
  - Round-robin and sticky partitioning
- **Performance Optimization**
  - Batching and compression
  - Memory management and buffer pools
  - Throughput vs latency trade-offs

### 7. Advanced Consumer Patterns
- **Consumer Threading Models**
  - Single-threaded vs multi-threaded consumers
  - Worker thread pools
  - Async processing patterns
- **Rebalancing Strategies**
  - Partition assignment strategies
  - Cooperative rebalancing
  - Handling rebalance events
- **Error Handling Patterns**
  - Retry topics and exponential backoff
  - Dead letter queues
  - Circuit breaker patterns

### 8. Spring Kafka Integration
- **Spring Boot Kafka Starter**
  - Auto-configuration and properties
  - KafkaTemplate for producers
  - @KafkaListener for consumers
- **Configuration Management**
  - Consumer and producer factory beans
  - Custom serializers and deserializers
  - Error handling configuration
- **Testing**
  - EmbeddedKafka for integration tests
  - TestContainers with Kafka
  - Mocking producers and consumers

### 9. Kafka Streams (Basics)
- **Stream Processing Concepts**
  - Stateless vs stateful operations
  - Stream-table duality
  - Windowing and aggregations
- **Kafka Streams API**
  - StreamsBuilder and topology
  - KStream and KTable operations
  - Processor API basics
- **Java Integration**
  - Spring Cloud Stream with Kafka
  - Kafka Streams with Spring Boot

### 10. Monitoring and Metrics
- **JMX Metrics**
  - Producer and consumer metrics
  - Broker and topic metrics
  - Lag monitoring and alerting
- **Application Monitoring**
  - Micrometer integration
  - Custom metrics and gauges
  - Health checks and probes
- **Logging and Tracing**
  - Structured logging patterns
  - Distributed tracing integration
  - Correlation IDs across services

## Advanced Level (Nice to Have)

### 11. Schema Management
- **Confluent Schema Registry**
  - Schema evolution strategies
  - Compatibility modes
  - Subject naming strategies
- **Schema Evolution**
  - Backward/forward compatibility
  - Schema versioning patterns
  - Migration strategies

### 12. Security Implementation
- **Authentication and Authorization**
  - SASL/PLAIN, SASL/SCRAM
  - OAuth and OIDC integration
  - ACLs and role-based access
- **Encryption**
  - SSL/TLS configuration
  - Client certificate authentication
  - Data encryption at rest

### 13. Performance Tuning
- **Producer Optimization**
  - Batch size and linger time tuning
  - Compression algorithms
  - Memory and network optimization
- **Consumer Optimization**
  - Fetch size and session timeout tuning
  - Parallel processing strategies
  - Memory management

### 14. Kafka Connect
- **Connect Framework**
  - Source and sink connectors
  - Connector configuration
  - Distributed vs standalone mode
- **Custom Connectors**
  - Building source connectors
  - Building sink connectors
  - Connector lifecycle management

### 15. Advanced Stream Processing
- **Complex Event Processing**
  - Windowing strategies
  - Join operations
  - State stores and queries
- **Exactly-Once Processing**
  - Transactional stream processing
  - State management and recovery
  - Failure handling patterns

## Common Java Integration Patterns

### 1. Microservices Communication
- **Event-Driven Architecture**
  - Domain events and event sourcing
  - Saga pattern implementation
  - Event choreography vs orchestration
- **Request-Reply Patterns**
  - Synchronous communication over Kafka
  - Correlation ID patterns
  - Timeout and retry handling

### 2. CQRS Implementation
- **Command Query Separation**
  - Event sourcing with Kafka
  - Read model projections
  - Event store patterns
- **State Management**
  - Snapshotting strategies
  - Event replay and recovery
  - Consistency patterns

### 3. Real-time Analytics
- **Stream Aggregations**
  - Windowed aggregations
  - Real-time dashboards
  - Anomaly detection patterns
- **Data Pipeline Integration**
  - ETL with Kafka Connect
  - Stream processing with Kafka Streams
  - Integration with analytical stores

## Essential Configuration Properties

### Producer Configuration
```properties
# Connection
bootstrap.servers=localhost:9092
key.serializer=org.apache.kafka.common.serialization.StringSerializer
value.serializer=org.apache.kafka.common.serialization.StringSerializer

# Reliability
acks=all
retries=Integer.MAX_VALUE
enable.idempotence=true

# Performance
batch.size=16384
linger.ms=5
compression.type=snappy
```

### Consumer Configuration
```properties
# Connection
bootstrap.servers=localhost:9092
group.id=my-consumer-group
key.deserializer=org.apache.kafka.common.serialization.StringDeserializer
value.deserializer=org.apache.kafka.common.serialization.StringDeserializer

# Reliability
enable.auto.commit=false
auto.offset.reset=earliest
isolation.level=read_committed

# Performance
fetch.min.bytes=1
max.poll.records=500
session.timeout.ms=30000
```

## Spring Boot Integration Examples

### Basic Producer
```java
@Service
public class EventPublisher {
    
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    
    public void publishEvent(String topic, String key, Object event) {
        kafkaTemplate.send(topic, key, event)
            .addCallback(
                result -> log.info("Event published successfully"),
                failure -> log.error("Failed to publish event", failure)
            );
    }
}
```

### Basic Consumer
```java
@Component
public class EventConsumer {
    
    @KafkaListener(topics = "user-events", groupId = "user-service")
    public void handleUserEvent(
        @Payload UserEvent event,
        @Header KafkaHeaders headers,
        Acknowledgment ack
    ) {
        try {
            processEvent(event);
            ack.acknowledge();
        } catch (Exception e) {
            log.error("Failed to process event", e);
            // Handle error (retry, DLQ, etc.)
        }
    }
}
```

## Recommended Learning Path

1. **Week 1-2**: Kafka fundamentals and architecture
2. **Week 3-4**: Java Producer and Consumer APIs
3. **Week 5-6**: Spring Kafka integration and patterns
4. **Week 7-8**: Serialization, schema management
5. **Week 9-10**: Advanced patterns and error handling
6. **Week 11-12**: Monitoring, performance tuning
7. **Week 13-14**: Kafka Streams and advanced topics

## Hands-On Projects

### Beginner Projects
1. Simple producer-consumer application
2. Event-driven microservices communication
3. Order processing with Kafka
4. Real-time notification system

### Intermediate Projects
1. Event sourcing with Spring Boot
2. CQRS implementation
3. Kafka Connect with databases
4. Real-time analytics dashboard

### Advanced Projects
1. Distributed saga implementation
2. Custom Kafka Connect connector
3. Kafka Streams processing pipeline
4. Multi-region Kafka deployment

## Common Pitfalls and Solutions

### 1. Consumer Lag Issues
- Monitor consumer lag metrics
- Optimize consumer processing logic
- Scale consumer instances appropriately
- Use parallel processing patterns

### 2. Message Ordering
- Understand partition-level ordering
- Use message keys for related events
- Implement custom partitioners when needed
- Consider single-partition topics for global ordering

### 3. Duplicate Processing
- Implement idempotent consumers
- Use exactly-once semantics when needed
- Track processed message IDs
- Design for at-least-once processing

### 4. Schema Evolution
- Plan for backward compatibility
- Use schema registry for governance
- Test schema changes thoroughly
- Implement graceful degradation

## Tools and Ecosystem

### Development Tools
- **Kafka CLI Tools**: kafka-console-producer, kafka-console-consumer
- **Kafka Manager/UI**: AKHQ, Kafka UI, Conduktor
- **Schema Registry**: Confluent Schema Registry
- **Testing**: TestContainers, EmbeddedKafka

### Monitoring and Operations
- **Kafka Manager**: Cluster management and monitoring
- **Prometheus/Grafana**: Metrics and visualization
- **Kafka Exporter**: Prometheus metrics exporter
- **Cruise Control**: Automated cluster management

### Cloud Services
- **Confluent Cloud**: Managed Kafka service
- **Amazon MSK**: AWS managed Kafka
- **Azure Event Hubs**: Kafka-compatible service
- **Google Cloud Pub/Sub**: Alternative messaging service