# CS Interview Preparation Notes

## Table of Contents
1. [Operating System (OS)](#operating-system-os)
2. [Database Management System (DBMS)](#database-management-system-dbms)
3. [Computer Networks (CN)](#computer-networks-cn)
4. [Object-Oriented Programming (OOPS)](#object-oriented-programming-oops)

---

# Operating System (OS)

## Process Management

### Process vs Thread
- **Process**: Independent execution unit with separate memory space
- **Thread**: Lightweight process sharing memory space
- **Key Differences**:
  - Processes have separate address space; threads share address space
  - Context switching between threads is faster
  - Threads can communicate through shared memory; processes need IPC

### Process States
1. **New**: Process being created
2. **Ready**: Process waiting for CPU
3. **Running**: Process executing on CPU
4. **Waiting/Blocked**: Process waiting for I/O or event
5. **Terminated**: Process finished execution

### CPU Scheduling Algorithms
- **FCFS (First Come First Serve)**: Simple but causes convoy effect
- **SJF (Shortest Job First)**: Optimal but requires prediction
- **Round Robin**: Fair but overhead of context switching
- **Priority Scheduling**: Can cause starvation
- **Multilevel Queue**: Different queues for different process types

## Memory Management

### Virtual Memory
- **Purpose**: Allows execution of processes larger than physical memory
- **Benefits**: Memory protection, sharing, efficient use
- **Implementation**: Paging, segmentation, or both

### Paging
- **Page**: Fixed-size memory block
- **Frame**: Physical memory slot for pages
- **Page Table**: Maps virtual pages to physical frames
- **TLB (Translation Lookaside Buffer)**: Cache for page table entries

### Page Replacement Algorithms
- **FIFO**: Replace oldest page (Belady's anomaly possible)
- **LRU (Least Recently Used)**: Replace least recently used page
- **Optimal**: Replace page that won't be used for longest time
- **Clock Algorithm**: Approximation of LRU using reference bit

## Synchronization

### Critical Section Problem
- **Critical Section**: Code segment accessing shared resources
- **Requirements**: Mutual exclusion, progress, bounded waiting

### Synchronization Mechanisms
- **Mutex**: Binary semaphore for mutual exclusion
- **Semaphore**: Integer variable for resource counting
- **Monitor**: High-level synchronization construct
- **Condition Variables**: Used with monitors for thread coordination

### Deadlock
- **Necessary Conditions**: Mutual exclusion, hold and wait, no preemption, circular wait
- **Prevention**: Eliminate one of the four conditions
- **Avoidance**: Banker's algorithm
- **Detection**: Resource allocation graph, wait-for graph

## File Systems

### File System Structure
- **Boot Block**: Contains boot loader
- **Super Block**: File system metadata
- **Inode Table**: File metadata storage
- **Data Blocks**: Actual file content

### File Allocation Methods
- **Contiguous**: Files stored in consecutive blocks
- **Linked**: Files stored as linked list of blocks
- **Indexed**: Index block contains pointers to data blocks

---

# Database Management System (DBMS)

## ACID Properties
- **Atomicity**: All or nothing transaction execution
- **Consistency**: Database remains in valid state
- **Isolation**: Concurrent transactions don't interfere
- **Durability**: Committed changes are permanent

## Normalization

### Normal Forms
- **1NF**: Atomic values, no repeating groups
- **2NF**: 1NF + no partial dependency on primary key
- **3NF**: 2NF + no transitive dependency
- **BCNF**: 3NF + every determinant is candidate key

### Denormalization
- **Purpose**: Improve query performance
- **Trade-off**: Storage space and update complexity for read performance

## Indexing

### Types of Indexes
- **Primary Index**: On primary key (clustered)
- **Secondary Index**: On non-primary key (non-clustered)
- **Composite Index**: On multiple columns
- **Unique Index**: Ensures uniqueness

### B+ Tree
- **Structure**: Balanced tree with data only in leaf nodes
- **Advantages**: Logarithmic search, range queries, sequential access
- **Use**: Primary structure for database indexes

## Transactions

### Concurrency Control
- **Lock-based**: Shared and exclusive locks
- **Timestamp-based**: Transaction ordering by timestamps
- **Optimistic**: Assume no conflicts, validate at commit

### Isolation Levels
1. **Read Uncommitted**: Dirty reads possible
2. **Read Committed**: No dirty reads
3. **Repeatable Read**: No phantom reads
4. **Serializable**: Complete isolation

### Deadlock in DBMS
- **Detection**: Wait-for graph
- **Prevention**: Timeout, wait-die, wound-wait schemes
- **Resolution**: Rollback one transaction

## Query Optimization

### Steps
1. **Parsing**: Syntax and semantic analysis
2. **Optimization**: Generate execution plans
3. **Execution**: Execute optimal plan

### Cost-based Optimization
- **Statistics**: Table cardinality, column selectivity
- **Cost Estimation**: I/O, CPU, memory costs
- **Plan Selection**: Choose minimum cost plan

## Database Architecture

### Three-Schema Architecture
- **External Schema**: User views
- **Conceptual Schema**: Logical structure
- **Internal Schema**: Physical storage

### Distributed Databases
- **Advantages**: Reliability, performance, scalability
- **Challenges**: Consistency, network partitions, complexity

---

# Computer Networks (CN)

## OSI Model

### 7 Layers
1. **Physical**: Bit transmission, cables, hubs
2. **Data Link**: Frame transmission, error detection, MAC addresses
3. **Network**: Routing, IP addresses, packet forwarding
4. **Transport**: End-to-end communication, TCP/UDP
5. **Session**: Session management, checkpoints
6. **Presentation**: Encryption, compression, data formatting
7. **Application**: User interface, HTTP, FTP, SMTP

## TCP/IP Model

### 4 Layers
1. **Network Access**: Physical + Data Link
2. **Internet**: Network layer, IP protocol
3. **Transport**: TCP, UDP protocols
4. **Application**: Application layer protocols

## Protocols

### TCP vs UDP
- **TCP**: Connection-oriented, reliable, ordered delivery, flow control
- **UDP**: Connectionless, unreliable, fast, no flow control
- **Use Cases**: TCP for web, email; UDP for gaming, streaming

### HTTP vs HTTPS
- **HTTP**: Port 80, plaintext, stateless
- **HTTPS**: Port 443, encrypted with SSL/TLS, secure

### DNS (Domain Name System)
- **Purpose**: Translate domain names to IP addresses
- **Hierarchy**: Root → TLD → Authoritative servers
- **Record Types**: A, AAAA, CNAME, MX, NS

## Routing

### Routing Algorithms
- **Distance Vector**: Bellman-Ford, RIP
- **Link State**: Dijkstra's algorithm, OSPF
- **Path Vector**: BGP for inter-domain routing

### IP Addressing
- **IPv4**: 32-bit, dotted decimal notation
- **IPv6**: 128-bit, hexadecimal notation
- **CIDR**: Classless Inter-Domain Routing
- **NAT**: Network Address Translation

## Network Security

### Threats
- **Eavesdropping**: Passive listening
- **Spoofing**: Impersonation attacks
- **DDoS**: Denial of Service attacks
- **Man-in-the-Middle**: Intercepting communication

### Security Measures
- **Firewalls**: Packet filtering, stateful inspection
- **VPN**: Virtual Private Networks
- **Encryption**: Symmetric and asymmetric cryptography
- **Digital Signatures**: Authentication and non-repudiation

## Performance Metrics

### Key Metrics
- **Bandwidth**: Maximum data transfer rate
- **Latency**: Time for data to travel from source to destination
- **Throughput**: Actual data transfer rate
- **Jitter**: Variation in latency

---

# Object-Oriented Programming (OOPS)

## Four Pillars of OOPS

### 1. Encapsulation
- **Definition**: Bundling data and methods that operate on data
- **Benefits**: Data hiding, modularity, maintainability
- **Implementation**: Private variables, public methods (getters/setters)

### 2. Inheritance
- **Definition**: Creating new classes based on existing classes
- **Types**: Single, multiple, multilevel, hierarchical, hybrid
- **Benefits**: Code reusability, method overriding, polymorphism

### 3. Polymorphism
- **Compile-time**: Method overloading, operator overloading
- **Runtime**: Method overriding, virtual functions
- **Benefits**: Code flexibility, maintainability

### 4. Abstraction
- **Definition**: Hiding complex implementation details
- **Implementation**: Abstract classes, interfaces
- **Benefits**: Simplicity, modularity, flexibility

## Advanced Concepts

### Abstract Class vs Interface
- **Abstract Class**: Can have implementation, constructor, instance variables
- **Interface**: Only method signatures (Java 8+ allows default methods)
- **Use**: Abstract class for "is-a" relationship, interface for "can-do" relationship

### Method Overloading vs Overriding
- **Overloading**: Same method name, different parameters (compile-time)
- **Overriding**: Redefining parent class method in child class (runtime)

### Static vs Dynamic Binding
- **Static**: Method call resolved at compile time (overloading)
- **Dynamic**: Method call resolved at runtime (overriding)

## Design Patterns

### Creational Patterns
- **Singleton**: Single instance of class
- **Factory**: Create objects without specifying exact class
- **Builder**: Construct complex objects step by step

### Structural Patterns
- **Adapter**: Make incompatible interfaces work together
- **Decorator**: Add new functionality to objects dynamically
- **Facade**: Provide simplified interface to complex subsystem

### Behavioral Patterns
- **Observer**: Notify multiple objects about state changes
- **Strategy**: Select algorithm at runtime
- **Command**: Encapsulate requests as objects

## SOLID Principles

### S - Single Responsibility Principle
- **Definition**: Class should have only one reason to change
- **Benefit**: Better maintainability and testability

### O - Open/Closed Principle
- **Definition**: Open for extension, closed for modification
- **Implementation**: Use inheritance and polymorphism

### L - Liskov Substitution Principle
- **Definition**: Subtypes must be substitutable for base types
- **Implication**: Derived classes must honor base class contracts

### I - Interface Segregation Principle
- **Definition**: Clients shouldn't depend on interfaces they don't use
- **Solution**: Create specific interfaces instead of fat interfaces

### D - Dependency Inversion Principle
- **Definition**: Depend on abstractions, not concretions
- **Implementation**: Use interfaces and dependency injection

## Memory Management

### Stack vs Heap
- **Stack**: Local variables, method calls, automatic cleanup
- **Heap**: Dynamic allocation, objects, manual cleanup (or GC)

### Garbage Collection
- **Purpose**: Automatic memory management
- **Algorithms**: Mark and sweep, generational, concurrent
- **Benefits**: Prevents memory leaks, reduces programmer burden

---

# Common Interview Questions

## OS Questions
1. **What is the difference between process and thread?**
2. **Explain deadlock and its prevention techniques.**
3. **What is virtual memory and why is it important?**
4. **Compare different CPU scheduling algorithms.**
5. **Explain the concept of critical section.**

## DBMS Questions
1. **What are ACID properties and why are they important?**
2. **Explain different types of joins with examples.**
3. **What is normalization and why do we need it?**
4. **Difference between clustered and non-clustered indexes.**
5. **Explain transaction isolation levels.**

## CN Questions
1. **Explain the OSI model and its layers.**
2. **What is the difference between TCP and UDP?**
3. **How does DNS work?**
4. **Explain the concept of routing.**
5. **What is the difference between HTTP and HTTPS?**

## OOPS Questions
1. **Explain the four pillars of OOPS.**
2. **What is the difference between abstract class and interface?**
3. **Explain method overloading and overriding.**
4. **What are SOLID principles?**
5. **Explain different types of inheritance.**

---

# Quick Revision Tips

## Before Interview
- Review fundamentals of each subject
- Practice coding examples related to OOPS
- Understand real-world applications
- Be ready with examples and scenarios

## During Interview
- Think out loud while solving problems
- Ask clarifying questions
- Relate concepts to practical scenarios
- Be honest about what you don't know

## Key Points to Remember
- **OS**: Focus on process management, memory management, synchronization
- **DBMS**: ACID properties, normalization, indexing, transactions
- **CN**: OSI model, TCP/IP, routing, security
- **OOPS**: Four pillars, design patterns, SOLID principles

Good luck with your interviews! 🚀