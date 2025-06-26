# DSA Pattern Recognition Cheat Sheet

## Array Patterns

### Two Pointers
**Intent:** Process array from both ends or find pairs/triplets
- **When to use:** Target sum problems, palindrome checking, removing duplicates
- **Examples:** Two Sum (sorted array), 3Sum, Remove duplicates, Valid palindrome
- **Time:** O(n), **Space:** O(1)

### Sliding Window
**Intent:** Find optimal subarray/substring with specific conditions
- **When to use:** Subarray sum, longest/shortest substring problems
- **Examples:** Maximum sum subarray of size k, Longest substring without repeating characters
- **Time:** O(n), **Space:** O(1) or O(k)

### Fast & Slow Pointers (Floyd's Algorithm)
**Intent:** Detect cycles or find middle element
- **When to use:** Cycle detection, finding middle of linked list
- **Examples:** Linked list cycle, Find middle node, Happy number
- **Time:** O(n), **Space:** O(1)

### Prefix Sum
**Intent:** Quick range sum queries
- **When to use:** Multiple subarray sum queries, 2D matrix sum queries
- **Examples:** Range sum query, Subarray sum equals k
- **Time:** O(1) query after O(n) preprocessing

## String Patterns

### KMP (Knuth-Morris-Pratt)
**Intent:** Efficient pattern matching in strings
- **When to use:** Find substring occurrences, repeated pattern detection
- **Examples:** Implement strStr(), Repeated substring pattern
- **Time:** O(n + m), **Space:** O(m)

### Rolling Hash (Rabin-Karp)
**Intent:** Fast string matching using hash comparison
- **When to use:** Multiple pattern search, plagiarism detection
- **Examples:** Find all anagrams, Longest duplicate substring
- **Time:** O(n) average, **Space:** O(1)

## Tree Patterns

### DFS (Depth-First Search)
**Intent:** Explore tree depth-wise for path-related problems
- **When to use:** Path sum, tree diameter, validate BST
- **Examples:** Maximum depth, Path sum, Invert binary tree
- **Time:** O(n), **Space:** O(h) where h is height

### BFS (Breadth-First Search)
**Intent:** Level-by-level traversal
- **When to use:** Level order traversal, minimum depth, serialize tree
- **Examples:** Level order traversal, Minimum depth, Right side view
- **Time:** O(n), **Space:** O(w) where w is maximum width

### Divide & Conquer
**Intent:** Break problem into smaller subproblems
- **When to use:** Construct tree from arrays, merge operations
- **Examples:** Build tree from preorder/inorder, Merge k sorted lists
- **Time:** O(n log n), **Space:** O(log n)

## Graph Patterns

### Union-Find (Disjoint Set)
**Intent:** Track connected components and detect cycles
- **When to use:** Dynamic connectivity, cycle detection in undirected graphs
- **Examples:** Number of islands, Redundant connection, Friend circles
- **Time:** O(α(n)) with path compression, **Space:** O(n)

### Topological Sort
**Intent:** Linear ordering of vertices in DAG
- **When to use:** Dependency resolution, course scheduling
- **Examples:** Course schedule, Alien dictionary, Task scheduling
- **Time:** O(V + E), **Space:** O(V)

### Dijkstra's Algorithm
**Intent:** Shortest path in weighted graph
- **When to use:** Single-source shortest path with non-negative weights
- **Examples:** Network delay time, Cheapest flights
- **Time:** O((V + E) log V), **Space:** O(V)

## Dynamic Programming Patterns

### 1D DP
**Intent:** Optimal substructure with overlapping subproblems
- **When to use:** Fibonacci-like problems, decision at each step
- **Examples:** Climbing stairs, House robber, Decode ways
- **Time:** O(n), **Space:** O(n) or O(1) with optimization

### 2D DP
**Intent:** Two-dimensional state space
- **When to use:** Grid problems, two sequences comparison
- **Examples:** Unique paths, Edit distance, Longest common subsequence
- **Time:** O(m×n), **Space:** O(m×n) or O(min(m,n)) with optimization

### Knapsack Pattern
**Intent:** Selection problems with constraints
- **When to use:** Subset sum, partition problems, resource allocation
- **Examples:** 0/1 Knapsack, Partition equal subset sum, Target sum
- **Time:** O(n×target), **Space:** O(target)

## Backtracking Patterns

### Generate All Combinations/Permutations
**Intent:** Explore all possible solutions
- **When to use:** Generate all subsets, permutations, combinations
- **Examples:** Subsets, Permutations, Combination sum, N-Queens
- **Time:** O(2^n) for subsets, O(n!) for permutations

### Constraint Satisfaction
**Intent:** Find solutions satisfying constraints
- **When to use:** Sudoku solver, word search, palindrome partitioning
- **Examples:** Word search, Sudoku solver, Generate parentheses
- **Time:** Exponential, depends on constraints

## Heap Patterns

### Top K Elements
**Intent:** Find k largest/smallest elements efficiently
- **When to use:** K closest points, top k frequent elements
- **Examples:** Kth largest element, K closest points, Top k frequent words
- **Time:** O(n log k), **Space:** O(k)

### Merge K Sorted
**Intent:** Merge multiple sorted sequences
- **When to use:** Merge k sorted arrays/lists
- **Examples:** Merge k sorted lists, Smallest range covering elements
- **Time:** O(n log k), **Space:** O(k)

## Binary Search Patterns

### Classic Binary Search
**Intent:** Find element in sorted array
- **When to use:** Search in sorted array, find insertion position
- **Examples:** Binary search, Search insert position, First bad version
- **Time:** O(log n), **Space:** O(1)

### Search in Rotated Array
**Intent:** Search in modified sorted array
- **When to use:** Rotated sorted array problems
- **Examples:** Search in rotated sorted array, Find minimum in rotated array
- **Time:** O(log n), **Space:** O(1)

### Binary Search on Answer
**Intent:** Find optimal value by binary searching on possible answers
- **When to use:** Minimize/maximize some value with monotonic property
- **Examples:** Koko eating bananas, Split array largest sum, Capacity to ship packages
- **Time:** O(n log(max-min)), **Space:** O(1)

## Bit Manipulation Patterns

### XOR Properties
**Intent:** Use XOR properties for unique element problems
- **When to use:** Find unique elements, detect differences
- **Examples:** Single number, Find the difference, Missing number
- **Time:** O(n), **Space:** O(1)

### Bit Masking
**Intent:** Use bits to represent state/subsets
- **When to use:** State compression, subset enumeration
- **Examples:** Subsets using bit manipulation, Travelling salesman (small n)
- **Time:** O(2^n), **Space:** O(1) additional

## Greedy Patterns

### Interval Problems
**Intent:** Optimal selection/merging of intervals
- **When to use:** Meeting rooms, interval merging, activity selection
- **Examples:** Merge intervals, Non-overlapping intervals, Meeting rooms
- **Time:** O(n log n), **Space:** O(1)

### Activity Selection
**Intent:** Choose maximum number of non-conflicting activities
- **When to use:** Scheduling problems with start/end times
- **Examples:** Activity selection, Minimum number of platforms
- **Time:** O(n log n), **Space:** O(1)

## Trie Patterns

### Prefix Matching
**Intent:** Efficient prefix search and autocomplete
- **When to use:** Word search, autocomplete, prefix matching
- **Examples:** Implement Trie, Word search II, Autocomplete
- **Time:** O(m) for search where m is word length, **Space:** O(total characters)

## Mathematical Patterns

### GCD/LCM Problems
**Intent:** Find greatest common divisor or least common multiple
- **When to use:** Fraction operations, array reduction, step problems
- **Examples:** GCD of array, Stepping stones, Water jug problem
- **Time:** O(log(min(a,b))), **Space:** O(1)

### Prime Number Patterns
**Intent:** Work with prime numbers efficiently
- **When to use:** Prime factorization, counting primes
- **Examples:** Sieve of Eratosthenes, Count primes, Happy number
- **Time:** O(n log log n) for sieve, **Space:** O(n)

### Modular Arithmetic
**Intent:** Handle large number operations with modulo
- **When to use:** Large number calculations, combinatorics
- **Examples:** Power function, Factorial with mod, Fibonacci with mod
- **Time:** O(log n) for power, **Space:** O(1)

## Advanced Graph Patterns

### Strongly Connected Components (SCC)
**Intent:** Find strongly connected components in directed graph
- **When to use:** Graph condensation, dependency cycles
- **Examples:** Kosaraju's algorithm, Tarjan's algorithm
- **Time:** O(V + E), **Space:** O(V)

### Minimum Spanning Tree (MST)
**Intent:** Connect all vertices with minimum cost
- **When to use:** Network design, clustering
- **Examples:** Kruskal's algorithm, Prim's algorithm
- **Time:** O(E log E), **Space:** O(V)

### Articulation Points & Bridges
**Intent:** Find critical vertices/edges whose removal increases components
- **When to use:** Network vulnerability, critical path analysis
- **Examples:** Tarjan's algorithm for bridges/articulation points
- **Time:** O(V + E), **Space:** O(V)

### Maximum Flow
**Intent:** Find maximum flow in flow network
- **When to use:** Bipartite matching, capacity problems
- **Examples:** Ford-Fulkerson, Edmonds-Karp, Maximum bipartite matching
- **Time:** O(VE²) for Ford-Fulkerson, **Space:** O(V²)

## Segment Tree Patterns

### Range Query & Update
**Intent:** Efficient range operations on arrays
- **When to use:** Range sum/min/max queries with updates
- **Examples:** Range sum query, Range minimum query with updates
- **Time:** O(log n) query/update, **Space:** O(n)

### Lazy Propagation
**Intent:** Batch updates on ranges efficiently
- **When to use:** Range updates, bulk operations
- **Examples:** Range increment, Range set queries
- **Time:** O(log n), **Space:** O(n)

## Advanced String Patterns

### Manacher's Algorithm
**Intent:** Find all palindromic substrings efficiently
- **When to use:** Palindrome problems, longest palindromic substring
- **Examples:** Longest palindromic substring, Count palindromic substrings
- **Time:** O(n), **Space:** O(n)

### Z-Algorithm
**Intent:** Find all occurrences of pattern in string
- **When to use:** String matching, pattern repetition
- **Examples:** Pattern matching, Shortest palindrome
- **Time:** O(n + m), **Space:** O(n + m)

### Suffix Array/Tree
**Intent:** All suffixes of string for complex string operations
- **When to use:** Longest common substring, string comparisons
- **Examples:** Longest repeated substring, Suffix array construction
- **Time:** O(n log n) or O(n), **Space:** O(n)

## Matrix Patterns

### Matrix Exponentiation
**Intent:** Fast computation of matrix powers
- **When to use:** Linear recurrence relations, Fibonacci-like sequences
- **Examples:** Nth Fibonacci, Linear recurrences
- **Time:** O(k³ log n) where k is matrix size, **Space:** O(k²)

### Spiral Matrix Traversal
**Intent:** Traverse matrix in spiral pattern
- **When to use:** Matrix traversal problems, boundary processing
- **Examples:** Spiral matrix, Rotate matrix
- **Time:** O(m×n), **Space:** O(1)

## Game Theory Patterns

### Minimax Algorithm
**Intent:** Optimal play in two-player zero-sum games
- **When to use:** Game tree evaluation, AI opponents
- **Examples:** Tic-tac-toe, Chess evaluation
- **Time:** O(b^d) where b is branching factor, d is depth

### Nim Game & Grundy Numbers
**Intent:** Analyze combinatorial games
- **When to use:** Nim-like games, game state analysis
- **Examples:** Nim game, Stone game variations
- **Time:** Depends on game complexity

## Geometric Patterns

### Convex Hull
**Intent:** Find smallest convex polygon containing all points
- **When to use:** Computational geometry, optimization
- **Examples:** Graham scan, Jarvis march
- **Time:** O(n log n), **Space:** O(n)

### Line Sweep Algorithm
**Intent:** Process geometric events in sorted order
- **When to use:** Interval problems, closest pair of points
- **Examples:** Rectangle overlap, Closest pair of points
- **Time:** O(n log n), **Space:** O(n)

## Probabilistic Patterns

### Reservoir Sampling
**Intent:** Random sampling from stream of unknown size
- **When to use:** Random selection from large datasets
- **Examples:** Random pick from stream, Shuffle array
- **Time:** O(n), **Space:** O(k) for k samples

### Bloom Filter
**Intent:** Probabilistic membership testing
- **When to use:** Large datasets, memory-efficient membership
- **Examples:** Web crawling, database applications
- **Time:** O(1), **Space:** O(m) for m bits

## Divide & Conquer Advanced

### Merge Sort Pattern
**Intent:** Divide array, solve recursively, merge results
- **When to use:** Counting inversions, external sorting
- **Examples:** Count inversions, Merge k sorted arrays
- **Time:** O(n log n), **Space:** O(n)

### Quick Select
**Intent:** Find kth element without full sorting
- **When to use:** Kth largest/smallest element
- **Examples:** Kth largest element, Median of medians
- **Time:** O(n) average, O(n²) worst, **Space:** O(1)

## Monotonic Stack/Queue

### Monotonic Stack
**Intent:** Maintain elements in monotonic order
- **When to use:** Next greater/smaller element problems
- **Examples:** Next greater element, Largest rectangle in histogram
- **Time:** O(n), **Space:** O(n)

### Monotonic Deque
**Intent:** Sliding window maximum/minimum
- **When to use:** Window-based extrema problems
- **Examples:** Sliding window maximum, Shortest subarray with sum ≥ k
- **Time:** O(n), **Space:** O(k)

## Advanced DP Patterns

### Digit DP
**Intent:** Count numbers with digit constraints
- **When to use:** Counting numbers with specific digit properties
- **Examples:** Numbers with repeated digits, Sum of digits
- **Time:** O(log n × states), **Space:** O(log n × states)

### Bitmask DP
**Intent:** DP with subset states represented as bitmasks
- **When to use:** Small set problems, state compression
- **Examples:** Travelling salesman, Assignment problem
- **Time:** O(2^n × n), **Space:** O(2^n)

### Tree DP
**Intent:** DP on tree structures
- **When to use:** Tree optimization problems
- **Examples:** Tree diameter, Maximum path sum, Tree rerooting
- **Time:** O(n), **Space:** O(n)

## Quick Recognition Guide

**See Array + Target Sum** → Two Pointers or HashMap  
**See Subarray/Substring + Condition** → Sliding Window  
**See Linked List + Middle/Cycle** → Fast & Slow Pointers  
**See Tree + Path** → DFS or Tree DP  
**See Tree + Level** → BFS  
**See Graph + Connected Components** → Union-Find or DFS  
**See Graph + Shortest Path** → Dijkstra/BFS/Floyd-Warshall  
**See "Minimum/Maximum" + Optimal Choice** → DP or Greedy  
**See "All Possible"** → Backtracking  
**See "Top K"** → Heap or Quick Select  
**See Sorted Array + Search** → Binary Search  
**See Intervals** → Sort + Greedy or Sweep Line  
**See Unique/Different Elements** → XOR or HashMap  
**See Range Queries** → Segment Tree or Prefix Sum  
**See Matrix + Path** → DP or DFS  
**See String + Pattern** → KMP/Z-algorithm/Rolling Hash  
**See Game/Optimal Strategy** → Minimax or Game Theory DP  
**See Geometric Points** → Convex Hull or Sweep Line  
**See Stream/Unknown Size** → Reservoir Sampling  
**See Next Greater/Smaller** → Monotonic Stack  
**See Sliding Window Max/Min** → Monotonic Deque  
**See Small Set (≤20 elements)** → Bitmask DP  
**See Large Numbers/Modulo** → Modular Arithmetic  
**See Palindromes** → Expand Around Center or Manacher's