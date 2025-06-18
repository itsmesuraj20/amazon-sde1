# AWS Learning Guide for Java Backend Developers

## Essential Level (Must Know)

### 1. AWS Fundamentals
- **Cloud Computing Basics**
  - IaaS, PaaS, SaaS models
  - AWS global infrastructure (Regions, AZs, Edge Locations)
  - AWS shared responsibility model
  - Billing and cost management basics
- **AWS Account Management**
  - Root account vs IAM users
  - AWS CLI and SDK setup
  - AWS Management Console navigation
  - Service limits and quotas

### 2. Identity and Access Management (IAM)
- **Core Concepts**
  - Users, groups, roles, and policies
  - Principle of least privilege
  - IAM policy structure (JSON)
  - Resource-based vs identity-based policies
- **Java Application Integration**
  - AWS SDK for Java setup
  - Credential providers and chains
  - Assuming roles programmatically
  - Service-to-service authentication
- **Security Best Practices**
  - MFA enforcement
  - Access key rotation
  - Cross-account access patterns
  - IAM policy testing and validation

### 3. Amazon EC2 (Elastic Compute Cloud)
- **Instance Management**
  - Instance types and sizing
  - AMI selection and customization
  - Security groups and NACLs
  - Key pairs and SSH access
- **Java Application Deployment**
  - Installing Java runtime
  - Application server setup (Tomcat, Jetty)
  - Environment configuration
  - Log management and monitoring
- **Scaling and Load Balancing**
  - Auto Scaling Groups (ASG)
  - Application Load Balancer (ALB)
  - Health checks and target groups
  - Blue-green deployment patterns

### 4. Amazon S3 (Simple Storage Service)
- **Core Operations**
  - Buckets and objects
  - Upload/download patterns
  - Versioning and lifecycle policies
  - Access control (bucket policies, ACLs)
- **Java SDK Integration**
  - AmazonS3 client configuration
  - Multipart uploads for large files
  - Pre-signed URLs for secure access
  - S3 Transfer Manager
- **Advanced Features**
  - Static website hosting
  - Cross-region replication
  - Event notifications
  - Storage classes optimization

### 5. Amazon RDS (Relational Database Service)
- **Database Management**
  - Engine selection (MySQL, PostgreSQL, Oracle)
  - Instance sizing and storage
  - Multi-AZ and read replicas
  - Backup and restoration
- **Java Application Integration**
  - JDBC connection configuration
  - Connection pooling with HikariCP
  - Database migration strategies
  - Performance monitoring
- **Security and Compliance**
  - Encryption at rest and in transit
  - Database parameter groups
  - VPC security groups
  - Database activity monitoring

## Intermediate Level (Should Know)

### 6. AWS Lambda (Serverless Computing)
- **Function Development**
  - Java runtime environments
  - Handler function patterns
  - Context and logging
  - Environment variables and configuration
- **Event-Driven Architecture**
  - Event sources (API Gateway, S3, DynamoDB)
  - Asynchronous invocation patterns
  - Error handling and retries
  - Dead letter queues
- **Performance Optimization**
  - Cold start mitigation
  - Memory and timeout configuration
  - Provisioned concurrency
  - Connection reuse patterns

### 7. Amazon API Gateway
- **REST API Development**
  - Resource and method configuration
  - Integration with Lambda functions
  - Request/response transformations
  - CORS configuration
- **Security and Authorization**
  - API keys and usage plans
  - Cognito integration for authentication
  - Custom authorizers (Lambda)
  - WAF integration for protection
- **Monitoring and Throttling**
  - CloudWatch metrics and logs
  - Request throttling and quotas
  - Caching strategies
  - Stage management and deployment

### 8. Amazon DynamoDB
- **NoSQL Database Concepts**
  - Partition keys and sort keys
  - Global Secondary Indexes (GSI)
  - Read/write capacity planning
  - Consistency models
- **Java SDK Integration**
  - DynamoDB Mapper annotations
  - Query and scan operations
  - Batch operations and transactions
  - Pagination and filtering
- **Advanced Features**
  - DynamoDB Streams
  - Global tables for multi-region
  - Auto scaling and on-demand billing
  - Backup and point-in-time recovery

### 9. Amazon SQS/SNS (Messaging Services)
- **Queue-Based Messaging (SQS)**
  - Standard vs FIFO queues
  - Message attributes and metadata
  - Visibility timeout and message retention
  - Dead letter queue configuration
- **Topic-Based Messaging (SNS)**
  - Publishers and subscribers
  - Message filtering and routing
  - SMS, email, and HTTP endpoints
  - Fan-out messaging patterns
- **Java Integration**
  - AWS SDK message producers/consumers
  - Spring Cloud AWS integration
  - Error handling and retry logic
  - Message serialization patterns

### 10. Amazon ElastiCache
- **Caching Strategies**
  - Redis vs Memcached selection
  - Cache-aside and write-through patterns
  - Cluster mode and replication
  - Failover and high availability
- **Java Integration**
  - Jedis and Lettuce client libraries
  - Spring Cache abstraction
  - Session caching patterns
  - Application-level cache management
- **Performance Optimization**
  - Memory sizing and optimization
  - Connection pooling
  - Monitoring and alerting
  - Cost optimization strategies

### 11. AWS CloudFormation
- **Infrastructure as Code**
  - Template structure and syntax
  - Resources, parameters, and outputs
  - Stack management lifecycle
  - Change sets and drift detection
- **Java Application Templates**
  - EC2 instance configurations
  - RDS database setup
  - Load balancer configurations
  - Auto scaling group templates
- **Advanced Features**
  - Nested stacks and cross-stack references
  - Custom resources with Lambda
  - Stack policies and IAM integration
  - Template validation and testing

### 12. Amazon CloudWatch
- **Monitoring and Observability**
  - Metrics, logs, and alarms
  - Custom metrics from Java applications
  - Log aggregation and analysis
  - Dashboard creation and sharing
- **Application Performance Monitoring**
  - CloudWatch Agent configuration
  - Application Insights
  - X-Ray for distributed tracing
  - Performance counter collection
- **