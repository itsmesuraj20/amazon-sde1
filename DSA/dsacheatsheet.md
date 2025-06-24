# DSA Pattern Recognition Cheat Sheet
### Prepared by @itsmesuraj20


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

## Quick Recognition Guide

**See Array + Target Sum** → Two Pointers or HashMap  
**See Subarray/Substring + Condition** → Sliding Window  
**See Linked List + Middle/Cycle** → Fast & Slow Pointers  
**See Tree + Path** → DFS  
**See Tree + Level** → BFS  
**See Graph + Connected Components** → Union-Find  
**See "Minimum/Maximum" + Optimal Choice** → DP or Greedy  
**See "All Possible"** → Backtracking  
**See "Top K"** → Heap  
**See Sorted Array + Search** → Binary Search  
**See Intervals** → Sort + Greedy  
**See Unique/Different Elements** → XOR or HashMap