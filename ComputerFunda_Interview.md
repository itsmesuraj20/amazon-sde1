# Interview Questions with Intent

## Operating System (OS)

| Question | Intent Behind Question | Expected Answer Depth |
|----------|------------------------|------------------------|
| **What is the difference between process and thread?** | Tests basic OS concepts understanding. Wants to see if candidate knows memory management and concurrency basics. | Should cover: separate memory space, context switching overhead, communication methods, use cases |
| **Explain deadlock and how to prevent it** | Checks understanding of synchronization problems and system design thinking | Must mention: 4 necessary conditions, prevention vs avoidance vs detection, real-world examples |
| **What happens when you type a URL in browser?** | Tests overall system knowledge - OS, networking, web technologies integration | Should cover: DNS resolution, TCP connection, HTTP request, rendering process |
| **Difference between preemptive and non-preemptive scheduling** | Evaluates CPU scheduling understanding and real-time systems knowledge | Explain: interruption capability, response time, starvation possibilities, examples |
| **What is virtual memory and why do we need it?** | Tests memory management concepts and system optimization understanding | Cover: address translation, paging, benefits, MMU role, page faults |
| **Explain thrashing in OS** | Checks advanced memory management knowledge and performance analysis | Define: page fault frequency, working set, solutions, performance impact |
| **What is a semaphore? Types of semaphores?** | Tests synchronization mechanisms and concurrent programming knowledge | Binary vs counting semaphores, operations, use cases, advantages over mutex |
| **Difference between logical and physical address** | Evaluates memory management fundamentals | Address translation, MMU, virtual memory mapping, protection |
| **What is context switching? Why is it expensive?** | Tests process management and performance optimization understanding | CPU state saving, memory switching, cache invalidation, TLB flushing |
| **Explain different types of system calls** | Checks OS interface knowledge and system programming understanding | Process control, file management, device management, communication |

## Database Management System (DBMS)

| Question | Intent Behind Question | Expected Answer Depth |
|----------|------------------------|------------------------|
| **Explain ACID properties with examples** | Tests fundamental database transaction understanding and data integrity knowledge | Real examples for each property, failure scenarios, importance in banking/e-commerce |
| **What is normalization? Explain with example** | Evaluates database design skills and data redundancy understanding | 1NF to BCNF with table examples, advantages/disadvantages, when to denormalize |
| **Difference between clustered and non-clustered index** | Tests database performance optimization and storage understanding | Physical vs logical ordering, one clustered per table, performance implications |
| **Explain different types of JOINs** | Checks SQL proficiency and data retrieval understanding | Inner, outer, self joins with examples, performance considerations, use cases |
| **What is a transaction? Explain isolation levels** | Tests concurrent database access understanding and consistency knowledge | Read uncommitted to serializable, problems each level solves, performance trade-offs |
| **How does database indexing work?** | Evaluates query optimization and performance tuning knowledge | B+ tree structure, index selection, covering indexes, maintenance overhead |
| **Explain database locking mechanisms** | Tests concurrency control understanding and deadlock prevention | Shared/exclusive locks, granularity, two-phase locking, deadlock detection |
| **What is denormalization and when to use it?** | Checks practical database design and performance optimization skills | Read performance vs update complexity, data warehousing, reporting scenarios |
| **Explain CAP theorem** | Tests distributed systems knowledge and consistency models | Consistency, Availability, Partition tolerance trade-offs, real-world examples |
| **What is a stored procedure? Advantages?** | Evaluates database programming knowledge and security understanding | Precompiled code, security, performance, maintainability, network traffic |

## Computer Networks (CN)

| Question | Intent Behind Question | Expected Answer Depth |
|----------|------------------------|------------------------|
| **Explain OSI model layers with examples** | Tests networking fundamentals and protocol stack understanding | Each layer function, protocols, real-world examples, data encapsulation |
| **Difference between TCP and UDP** | Evaluates transport layer understanding and protocol selection skills | Connection-oriented vs connectionless, reliability, use cases, header comparison |
| **How does DNS work?** | Tests internet infrastructure knowledge and distributed systems understanding | Hierarchy, caching, record types, resolution process, root servers |
| **What is HTTP? Difference between HTTP and HTTPS** | Checks web protocol knowledge and security understanding | Request/response cycle, status codes, SSL/TLS, certificate validation |
| **Explain routing algorithms** | Tests network path optimization and graph algorithms knowledge | Distance vector vs link state, convergence, routing tables, real protocols |
| **What is a subnet and why do we need it?** | Evaluates IP addressing and network design understanding | CIDR notation, broadcast domain, security, performance benefits |
| **Explain NAT and its types** | Tests network address translation and IPv4 limitation solutions | Static, dynamic, PAT, private vs public IP, port mapping |
| **What is a firewall? Types of firewalls** | Checks network security knowledge and threat protection understanding | Packet filtering, stateful inspection, application layer, DMZ concept |
| **Difference between hub, switch, and router** | Tests network device understanding and OSI layer knowledge | Layer 1 vs 2 vs 3 devices, collision domain, broadcast domain, functions |
| **Explain congestion control in TCP** | Evaluates advanced networking knowledge and performance optimization | Slow start, congestion avoidance, fast retransmit, sliding window |

## Object-Oriented Programming (OOPS)

| Question | Intent Behind Question | Expected Answer Depth |
|----------|------------------------|------------------------|
| **Explain the four pillars of OOPS** | Tests fundamental OOP understanding and design principles knowledge | Encapsulation, inheritance, polymorphism, abstraction with code examples |
| **Difference between abstract class and interface** | Evaluates inheritance concepts and design pattern understanding | Multiple inheritance, implementation vs contract, when to use which |
| **What is method overloading vs overriding?** | Tests polymorphism understanding and compile-time vs runtime concepts | Static vs dynamic binding, signature rules, virtual functions |
| **Explain SOLID principles with examples** | Checks advanced OOP design knowledge and maintainable code practices | Each principle with code examples, violations, refactoring techniques |
| **What is polymorphism? Types of polymorphism** | Tests core OOP concept and flexibility in design understanding | Compile-time vs runtime, method overloading vs overriding, virtual functions |
| **Explain inheritance types with examples** | Evaluates class hierarchy design and code reusability knowledge | Single, multiple, multilevel, hierarchical, hybrid with real examples |
| **What is encapsulation? How to achieve it?** | Tests data hiding and security principles in OOP | Access modifiers, getters/setters, benefits, information hiding |
| **Difference between composition and inheritance** | Checks object relationship understanding and design flexibility | "Has-a" vs "Is-a", tight vs loose coupling, flexibility in design |
| **What is a constructor? Types of constructors** | Tests object initialization knowledge and memory management | Default, parameterized, copy constructors, constructor chaining |
| **Explain design patterns you know** | Evaluates advanced programming knowledge and problem-solving patterns | Singleton, Factory, Observer with use cases, implementation, pros/cons |

## Cross-Domain Questions (Tests Overall Understanding)

| Question | Intent Behind Question | Expected Answer Depth |
|----------|------------------------|------------------------|
| **How would you design a URL shortener like bit.ly?** | Tests system design, database design, networking, and scalability knowledge | Database schema, hashing algorithms, caching, load balancing, analytics |
| **Explain how garbage collection works** | Tests memory management across languages and performance optimization | Mark and sweep, generational GC, reference counting, performance impact |
| **What happens during a database transaction?** | Tests DBMS, OS (locks), and concurrent programming understanding | ACID properties, locking, logging, recovery, isolation levels |
| **How do you handle concurrent requests in a web application?** | Tests threading, networking, database connections, and system design | Thread pools, connection pooling, stateless design, caching strategies |
| **Explain caching mechanisms you know** | Tests performance optimization across multiple domains | OS page cache, database buffer pool, web browser cache, CDN, Redis |
| **How would you optimize a slow database query?** | Tests database indexing, query optimization, and performance analysis | Execution plan analysis, index selection, query rewriting, statistics |
| **What is the difference between authentication and authorization?** | Tests security concepts across web applications and systems | Identity verification vs permission checking, JWT, OAuth, session management |
| **Explain microservices architecture** | Tests distributed systems, networking, database design, and scalability | Service decomposition, communication patterns, data consistency, deployment |

## Question Categories by Difficulty Level

### **Beginner Level (0-2 years experience)**
- Basic definitions and differences
- Simple examples and use cases
- Fundamental concepts explanation

### **Intermediate Level (2-5 years experience)**
- Implementation details and trade-offs
- Performance considerations
- Real-world problem solving

### **Advanced Level (5+ years experience)**
- System design implications
- Optimization strategies
- Cross-domain integration

## Interview Tips by Intent

### **When they ask basic definitions:**
- **Intent:** Testing foundational knowledge
- **Response:** Clear definition + simple example + one practical use case

### **When they ask "difference between X and Y":**
- **Intent:** Testing comparative understanding
- **Response:** Tabular comparison + when to use which + pros/cons

### **When they ask "How does X work?":**
- **Intent:** Testing process understanding
- **Response:** Step-by-step explanation + diagram if possible + edge cases

### **When they ask "How would you optimize/design X?":**
- **Intent:** Testing problem-solving and system thinking
- **Response:** Current bottlenecks + multiple solutions + trade-offs + chosen solution with reasoning

### **When they ask scenario-based questions:**
- **Intent:** Testing practical application of concepts
- **Response:** Clarifying questions + approach + implementation + testing + monitoring

Remember: The intent is not just to test knowledge, but to see how you think, communicate, and apply concepts to solve real problems!