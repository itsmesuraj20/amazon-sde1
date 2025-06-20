# Advanced DSA Patterns (Competitive Programming)

> **Note:** These are advanced patterns mainly for competitive programming and system design. Learn basic patterns first!

## String Processing (Advanced)

### Aho-Corasick Algorithm
**Intent:** Find multiple patterns in text simultaneously
- **When to use:** Multiple pattern matching, dictionary search
- **Examples:** Find all words from dictionary in text, DNA sequence matching
- **Time:** O(n + m + z) where z is number of matches

### Suffix Automaton
**Intent:** All substrings recognition in linear time
- **When to use:** Substring queries, longest common substring
- **Examples:** Count distinct substrings, Longest common substring
- **Time:** O(n), **Space:** O(n)

### Palindromic Tree (Eertree)
**Intent:** All palindromic substrings structure
- **When to use:** Palindrome counting, palindrome queries
- **Examples:** Count palindromic substrings, Odd/even length palindromes
- **Time:** O(n), **Space:** O(n)

## Tree Algorithms (Advanced)

### Heavy-Light Decomposition
**Intent:** Path queries on trees in log time
- **When to use:** Tree path updates/queries, LCA with weights
- **Examples:** Path sum queries, Path maximum queries
- **Time:** O(log² n) per query, **Space:** O(n)

### Centroid Decomposition
**Intent:** Divide tree into balanced parts
- **When to use:** Path counting, distance queries on trees
- **Examples:** Count paths with sum k, K-th ancestor queries
- **Time:** O(n log n), **Space:** O(n log n)

### Link-Cut Trees
**Intent:** Dynamic tree connectivity and path queries
- **When to use:** Dynamic forests, online tree problems
- **Examples:** Dynamic connectivity, Dynamic MST
- **Time:** O(log n) per operation

### Euler Tour + Segment Tree
**Intent:** Convert tree problems to array problems
- **When to use:** Subtree queries, tree range updates
- **Examples:** Subtree sum, Node to root path queries
- **Time:** O(log n), **Space:** O(n)

## Graph Algorithms (Expert Level)

### 2-SAT (Boolean Satisfiability)
**Intent:** Solve boolean satisfiability with 2 variables per clause
- **When to use:** Constraint satisfaction, boolean logic problems
- **Examples:** Graph coloring variants, Assignment problems
- **Time:** O(n + m), **Space:** O(n)

### Maximum Bipartite Matching (Advanced)
**Intent:** Maximum matching in bipartite graphs
- **When to use:** Assignment problems, Hall's theorem applications
- **Examples:** Hungarian algorithm, Job assignment
- **Time:** O(V²√E), **Space:** O(V²)

### Chinese Postman Problem
**Intent:** Shortest closed walk visiting all edges
- **When to use:** Route optimization, network traversal
- **Examples:** Mail delivery, Street cleaning
- **Time:** O(V³), **Space:** O(V²)

### Gomory-Hu Tree
**Intent:** All-pairs maximum flow in single tree
- **When to use:** Network reliability, connectivity queries
- **Examples:** Min-cut between any two nodes
- **Time:** O(V) max-flow computations

## Number Theory (Advanced)

### Extended Euclidean Algorithm
**Intent:** Find coefficients for Bézout's identity
- **When to use:** Modular inverse, Diophantine equations
- **Examples:** Modular inverse, Linear congruences
- **Time:** O(log(min(a,b))), **Space:** O(1)

### Chinese Remainder Theorem
**Intent:** Solve system of modular congruences
- **When to use:** Multiple modular constraints
- **Examples:** Calendar problems, Cycle finding
- **Time:** O(n log n), **Space:** O(1)

### Miller-Rabin Primality Test
**Intent:** Probabilistic primality testing
- **When to use:** Large number primality, cryptography
- **Examples:** RSA key generation, Prime checking
- **Time:** O(k log³ n), **Space:** O(1)

### Pollard's Rho Algorithm
**Intent:** Integer factorization
- **When to use:** Factor large numbers, cryptography
- **Examples:** RSA breaking, Number factorization
- **Time:** O(n^(1/4)), **Space:** O(1)

## Computational Geometry (Advanced)

### Voronoi Diagram
**Intent:** Partition plane based on distance to points
- **When to use:** Nearest neighbor, facility location
- **Examples:** Store location, Weather prediction
- **Time:** O(n log n), **Space:** O(n)

### Delaunay Triangulation
**Intent:** Triangulation maximizing minimum angle
- **When to use:** Mesh generation, interpolation
- **Examples:** Terrain modeling, Graph drawing
- **Time:** O(n log n), **Space:** O(n)

### Rotating Calipers
**Intent:** Efficiently compute various geometric measures
- **When to use:** Diameter, width, closest pair on convex hull
- **Examples:** Farthest pair, Minimum width
- **Time:** O(n), **Space:** O(1)

## Advanced Data Structures

### Persistent Segment Tree
**Intent:** Keep all versions of segment tree
- **When to use:** Version control, historical queries
- **Examples:** Kth smallest in range, Point updates with history
- **Time:** O(log n), **Space:** O(n log n)

### Wavelet Tree
**Intent:** Succinct data structure for sequences
- **When to use:** Range quantile queries, 2D range queries
- **Examples:** Range median, 2D rectangle queries
- **Time:** O(log σ) where σ is alphabet size

### Van Emde Boas Tree
**Intent:** Operations on universe of integers
- **When to use:** Predecessor/successor in O(log log u) time
- **Examples:** Dynamic predecessor, Integer priority queue
- **Time:** O(log log u), **Space:** O(u)

### Splay Tree
**Intent:** Self-adjusting binary search tree
- **When to use:** Access locality, amortized analysis
- **Examples:** Cache implementation, Adaptive sorting
- **Time:** O(log n) amortized

## Randomized Algorithms

### Skip List
**Intent:** Probabilistic alternative to balanced trees
- **When to use:** Simple implementation of ordered dictionary
- **Examples:** Database indexing, Distributed systems
- **Time:** O(log n) expected, **Space:** O(n)

### Treap (Randomized BST)
**Intent:** BST with random priorities
- **When to use:** Simple balanced BST, split/merge operations
- **Examples:** Implicit key treap, Range queries
- **Time:** O(log n) expected

### Las Vegas vs Monte Carlo
**Intent:** Different types of randomized algorithms
- **Las Vegas:** Always correct, random runtime
- **Monte Carlo:** Random correctness, fixed runtime

## Approximation Algorithms

### Vertex Cover Approximation
**Intent:** 2-approximation for minimum vertex cover
- **When to use:** NP-hard problems, practical solutions
- **Examples:** Network monitoring, Resource allocation
- **Time:** O(E), **Approximation:** 2-factor

### TSP Approximation
**Intent:** Approximation algorithms for TSP
- **When to use:** Route optimization, circuit design
- **Examples:** Christofides algorithm (1.5-approximation)
- **Time:** O(n³), **Approximation:** 1.5-factor

## Parallel Algorithms

### Parallel Prefix Sum
**Intent:** Compute prefix sums in parallel
- **When to use:** GPU programming, parallel processing
- **Examples:** Scan operations, Parallel algorithms
- **Time:** O(log n) parallel time

### Work-Efficient Algorithms
**Intent:** Algorithms with optimal work complexity
- **When to use:** Multicore systems, distributed computing
- **Examples:** Parallel merge sort, Parallel graph algorithms

## Online Algorithms

### Competitive Analysis
**Intent:** Analyze algorithms that process input online
- **When to use:** Streaming data, real-time systems
- **Examples:** Online caching, Load balancing
- **Metric:** Competitive ratio

### Secretary Problem
**Intent:** Optimal stopping theory application
- **When to use:** Hiring, auction design
- **Examples:** Best candidate selection, Online auctions
- **Strategy:** Observe n/e candidates, then pick next best

## Quantum Algorithms (Theoretical)

### Grover's Algorithm
**Intent:** Quantum search in unsorted database
- **When to use:** Unstructured search problems
- **Time:** O(√n) quantum time

### Shor's Algorithm
**Intent:** Quantum integer factorization
- **When to use:** Breaking RSA encryption
- **Time:** O((log n)³) quantum time

---

## Recognition Guide for Advanced Patterns

**Multiple Pattern Search** → Aho-Corasick  
**All Palindromes** → Palindromic Tree  
**Tree Path Queries** → Heavy-Light Decomposition  
**Dynamic Tree** → Link-Cut Trees  
**Boolean Constraints** → 2-SAT  
**Large Prime Testing** → Miller-Rabin  
**Geometric Nearest Neighbor** → Voronoi Diagram  
**Historical Queries** → Persistent Data Structures  
**Access Locality** → Splay Tree  
**NP-Hard Problems** → Approximation Algorithms  
**Streaming Data** → Online Algorithms  
**Parallel Processing** → Work-Efficient Algorithms