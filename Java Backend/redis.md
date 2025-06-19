# Redis Learning Guide for Java Backend Developers

## Essential Level (Must Know)

### 1. Redis Fundamentals
- **What is Redis**
  - In-memory data structure store
  - Key-value database, cache, and message broker
  - Single-threaded execution model
  - Persistence options (RDB, AOF)
- **Common Use Cases**
  - Application caching
  - Session storage
  - Real-time analytics
  - Rate limiting and throttling
  - Distributed locking


### 2. Core Data Types
- **Strings**
  - Basic SET, GET, INCR, DECR operations
  - Expiration with TTL
  - Atomic operations and counters
- **Lists**
  - LPUSH, RPUSH, LPOP, RPOP
  - Queue and stack implementations
  - Blocking operations (BLPOP, BRPOP)
- **Sets**
  - SADD, SREM, SMEMBERS
  - Set operations (UNION, INTERSECTION, DIFFERENCE)
  - Unique value storage
- **Hashes**
  - HSET, HGET, HMGET, HGETALL
  - Object storage patterns
  - Field-level operations
- **Sorted Sets**
  - ZADD, ZRANGE, ZRANK
  - Leaderboards and ranking systems
  - Range queries and scoring

### 3. Java Integration with Jedis
- **Jedis Setup**
  - Connection configuration
  - Connection pooling with JedisPool
  - Basic CRUD operations
- **Error Handling**
  - Connection timeouts and retries
  - Redis server exceptions
  - Pool exhaustion handling
- **Serialization**
  - String-based operations
  - JSON serialization patterns
  - Binary data handling

### 4. Spring Data Redis
- **Configuration**
  - RedisTemplate setup
  - Connection factory configuration
  - Serialization configuration
- **Repository Pattern**
  - @RedisHash annotations
  - CrudRepository implementation
  - Custom repository methods
- **RedisTemplate Operations**
  - ValueOperations, ListOperations
  - HashOperations, SetOperations
  - ZSetOperations for sorted sets

### 5. Caching Patterns
- **Cache-Aside Pattern**
  - Manual cache management
  - Read-through and write-through
  - Cache invalidation strategies
- **Spring Cache Abstraction**
  - @Cacheable, @CachePut, @CacheEvict
  - Cache configuration and customization
  - Multiple cache managers
- **TTL and Expiration**
  - Time-based expiration
  - Idle time expiration
  - Cache warming strategies

## Intermediate Level (Should Know)

### 6. Advanced Data Structures
- **HyperLogLog**
  - Cardinality estimation
  - Unique visitor counting
  - Memory-efficient approximate counting
- **Bitmaps**
  - Bit-level operations
  - User activity tracking
  - Feature flags implementation
- **Streams**
  - Message streaming
  - Consumer groups
  - Event sourcing patterns
- **Geospatial**
  - Location-based services
  - Radius queries
  - Distance calculations

### 7. Pub/Sub Messaging
- **Basic Pub/Sub**
  - Publishers and subscribers
  - Channel-based messaging
  - Pattern-based subscriptions
- **Java Implementation**
  - JedisPubSub implementation
  - Message handling patterns
  - Connection management
- **Spring Integration**
  - @EventListener for Redis events
  - MessageListenerContainer
  - Channel topic configuration

### 8. Distributed Patterns
- **Distributed Locking**
  - SET with NX and EX options
  - RedLock algorithm implementation
  - Lock timeout and renewal
- **Rate Limiting**
  - Sliding window algorithms
  - Token bucket implementation
  - Distributed rate limiting
- **Distributed Counters**
  - Atomic increment operations
  - Sharded counters
  - Approximate counting

### 9. Performance Optimization
- **Pipelining**
  - Batch operations
  - Reducing network round trips
  - Pipeline with Jedis
- **Connection Pooling**
  - Pool configuration tuning
  - Connection lifecycle management
  - Monitoring pool metrics
- **Memory Optimization**
  - Key naming strategies
  - Data structure selection
  - Memory usage monitoring

### 10. Monitoring and Debugging
- **Redis Metrics**
  - INFO command analysis
  - Memory usage tracking
  - Command statistics
- **Application Monitoring**
  - Connection pool metrics
  - Cache hit/miss ratios
  - Response time monitoring
- **Debugging Tools**
  - Redis CLI for debugging
  - MONITOR command
  - Slow log analysis

## Advanced Level (Nice to Have)

### 11. Redis Clustering
- **Cluster Architecture**
  - Hash slot distribution
  - Master-slave replication
  - Automatic failover
- **Java Client Configuration**
  - JedisCluster setup
  - Connection routing
  - Retry and failover handling
- **Data Distribution**
  - Hash tag usage
  - Cross-slot operations
  - Resharding strategies

### 12. High Availability
- **Redis Sentinel**
  - Master-slave monitoring
  - Automatic failover
  - Service discovery
- **Replication**
  - Master-slave setup
  - Read scaling patterns
  - Consistency considerations
- **Backup and Recovery**
  - RDB snapshots
  - AOF log replay
  - Point-in-time recovery

### 13. Security
- **Authentication**
  - AUTH command
  - ACL (Access Control Lists)
  - User management
- **Network Security**
  - Bind configuration
  - Firewall rules
  - SSL/TLS encryption
- **Command Security**
  - Dangerous command restriction
  - Command renaming
  - Sandboxing

### 14. Advanced Caching Strategies
- **Cache Invalidation**
  - Tag-based invalidation
  - Event-driven invalidation
  - Batch invalidation patterns
- **Multi-Level Caching**
  - L1 (local) and L2 (Redis) cache
  - Cache coherence strategies
  - Fallback mechanisms
- **Cache Warming**
  - Proactive cache loading
  - Background refresh patterns
  - Cold start mitigation

### 15. Redis Modules
- **Popular Modules**
  - RedisJSON for JSON documents
  - RedisSearch for full-text search
  - RedisTimeSeries for time-series data
- **Custom Modules**
  - Module development concepts
  - Integration patterns
  - Performance considerations

## Java-Specific Implementation Patterns

### 1. Spring Boot Integration
- **Auto-Configuration**
  - Redis starter dependencies
  - Property-based configuration
  - Multiple Redis instances
- **Cache Configuration**
  - RedisCacheManager setup
  - Custom cache configurations
  - Cache serialization options
- **Session Management**
  - Spring Session Redis
  - Clustered session storage
  - Session serialization

### 2. Reactive Programming
- **Spring WebFlux Integration**
  - ReactiveRedisTemplate
  - Non-blocking operations
  - Backpressure handling
- **Reactive Streams**
  - Mono and Flux operations
  - Async cache operations
  - Error handling patterns

### 3. Microservices Patterns
- **Service Discovery**
  - Redis as service registry
  - Health check patterns
  - Load balancing information
- **Configuration Management**
  - Distributed configuration
  - Dynamic configuration updates
  - Environment-specific configs
- **Inter-Service Communication**
  - Redis Pub/Sub for events
  - Request-response patterns
  - Async messaging

## Essential Java Code Patterns

### Basic Jedis Usage
```java
// Connection setup
JedisPool pool = new JedisPool("localhost", 6379);

// Basic operations
try (Jedis jedis = pool.getResource()) {
    jedis.set("key", "value");
    String value = jedis.get("key");
    jedis.expire("key", 3600); // TTL in seconds
}
```

### Spring Data Redis
```java
@Configuration
public class RedisConfig {
    
    @Bean
    public RedisTemplate<String, Object> redisTemplate(
            RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }
}

@Service
public class CacheService {
    
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    
    public void set(String key, Object value, Duration ttl) {
        redisTemplate.opsForValue().set(key, value, ttl);
    }
    
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
```

### Spring Cache Annotations
```java
@Service
public class UserService {
    
    @Cacheable(value = "users", key = "#id")
    public User findById(Long id) {
        return userRepository.findById(id);
    }
    
    @CachePut(value = "users", key = "#user.id")
    public User save(User user) {
        return userRepository.save(user);
    }
    
    @CacheEvict(value = "users", key = "#id")
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
```

### Distributed Lock Implementation
```java
@Component
public class DistributedLock {
    
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    
    public boolean acquireLock(String key, String value, Duration expiry) {
        Boolean result = redisTemplate.opsForValue()
            .setIfAbsent(key, value, expiry);
        return Boolean.TRUE.equals(result);
    }
    
    public void releaseLock(String key, String value) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then " +
                       "return redis.call('del', KEYS[1]) else return 0 end";
        redisTemplate.execute(RedisScript.of(script, Long.class), 
                            Collections.singletonList(key), value);
    }
}
```

## Configuration Examples

### application.yml (Spring Boot)
```yaml
spring:
  redis:
    host: localhost
    port: 6379
    password: your-password
    timeout: 2000ms
    lettuce:
      pool:
        max-active: 8
        max-idle: 8
        min-idle: 0
        max-wait: 2000ms
  cache:
    type: redis
    redis:
      time-to-live: 3600000
      cache-null-values: false
```

### Jedis Pool Configuration
```java
JedisPoolConfig poolConfig = new JedisPoolConfig();
poolConfig.setMaxTotal(20);
poolConfig.setMaxIdle(10);
poolConfig.setMinIdle(5);
poolConfig.setTestOnBorrow(true);
poolConfig.setTestOnReturn(true);
poolConfig.setTestWhileIdle(true);

JedisPool pool = new JedisPool(poolConfig, "localhost", 6379, 2000);
```

## Recommended Learning Path

1. **Week 1-2**: Redis fundamentals and basic data types
2. **Week 3-4**: Java integration with Jedis and Spring Data Redis
3. **Week 5-6**: Caching patterns and Spring Cache abstraction
4. **Week 7-8**: Advanced data structures and Pub/Sub
5. **Week 9-10**: Distributed patterns and performance optimization
6. **Week 11-12**: Clustering, high availability, and security
7. **Week 13-14**: Advanced patterns and production considerations

## Hands-On Projects

### Beginner Projects
1. Simple caching layer for REST API
2. Session storage for web application
3. Rate limiting middleware
4. Real-time chat application with Pub/Sub

### Intermediate Projects
1. Distributed locking system
2. Leaderboard with sorted sets
3. Shopping cart with Redis Hashes
4. Event-driven architecture with Redis Streams

### Advanced Projects
1. Multi-level caching system
2. Redis Cluster setup and management
3. Custom cache invalidation framework
4. Microservices with Redis coordination

## Common Use Cases and Patterns

### 1. Web Application Caching
- Page fragment caching
- Database query result caching
- API response caching
- Static content caching

### 2. Session Management
- User session storage
- Shopping cart persistence
- Multi-device session sync
- Session-based authentication

### 3. Real-time Features
- Live notifications
- Real-time analytics
- Activity feeds
- Live chat systems

### 4. Background Processing
- Task queues with Redis Lists
- Job scheduling and processing
- Delayed job execution
- Worker coordination

## Performance Best Practices

### 1. Key Design
- Use consistent naming conventions
- Avoid long key names
- Use appropriate data structures
- Implement key expiration

### 2. Memory Management
- Monitor memory usage
- Use appropriate data types
- Implement memory policies
- Regular cleanup procedures

### 3. Network Optimization
- Use connection pooling
- Implement pipelining for bulk operations
- Minimize network round trips
- Use local caching when appropriate

### 4. Monitoring and Alerting
- Track cache hit rates
- Monitor connection pool metrics
- Set up memory usage alerts
- Monitor slow queries

## Production Considerations

### 1. Deployment Patterns
- Master-slave replication
- Redis Sentinel for HA
- Redis Cluster for scaling
- Backup and disaster recovery

### 2. Security Measures
- Network isolation
- Authentication and authorization
- Command restrictions
- Audit logging

### 3. Monitoring and Operations
- Comprehensive metrics collection
- Automated failover procedures
- Capacity planning
- Performance tuning

### 4. Troubleshooting
- Common error patterns
- Performance bottleneck identification
- Memory leak detection
- Connection management issues