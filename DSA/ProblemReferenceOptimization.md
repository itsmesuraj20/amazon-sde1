# Problem Optimization Levels - Reference Table

## Problems with Brute → Better → Optimal Progression

| Problem Type | Example Problem | Brute Force | Better Solution | Optimal Solution | Key Indicator |
|--------------|-----------------|-------------|----------------|------------------|---------------|
| **Two Sum Problems** | Two Sum | O(n²) nested loops | O(n log n) sort + two pointers | O(n) hash map | Can we avoid checking all pairs? |
| **Sliding Window** | Max subarray of size k | O(n×k) recalculate each window | O(n) maintain window sum | O(n) deque for min/max | Overlapping computations |
| **Substring Problems** | Longest substring without repeats | O(n³) check all substrings | O(n²) expand around center | O(n) sliding window + set | Can we reuse previous work? |
| **Tree Diameter** | Binary tree diameter | O(n²) check from each node | O(n) with memoization | O(n) single DFS pass | Redundant subtree calculations |
| **Range Queries** | Sum of range [L,R] | O(n) per query | O(n) prefix sums | O(log n) segment tree | Multiple queries on same data |
| **LCS/Edit Distance** | Longest common subsequence | O(3ⁿ) recursive | O(n×m) memoization | O(min(n,m)) space optimized DP | Overlapping subproblems |
| **Pathfinding** | Shortest path in grid | O(4ⁿ) DFS all paths | O(n×m) BFS | O(n×m) A* with heuristic | Can we avoid exploring all paths? |
| **Stock Problems** | Best time to buy/sell | O(n²) try all pairs | O(n) track min so far | O(1) space multiple passes | Can we make decisions greedily? |

## Problems with Direct Brute → Optimal Jump

| Problem Type | Example Problem | Brute Force | Optimal Solution | Why No Middle Ground | Key Indicator |
|--------------|-----------------|-------------|------------------|---------------------|---------------|
| **Mathematical Formula** | Sum 1 to n | O(n) loop | O(1) formula n×(n+1)/2 | Direct mathematical property | Simple arithmetic progression |
| **Bit Manipulation** | Count set bits | O(log n) check each bit | O(1) Brian Kernighan's | Specific bit trick | Powers of 2 or XOR operations |
| **GCD/LCM** | Find GCD of two numbers | O(min(a,b)) trial division | O(log min(a,b)) Euclidean | Mathematical algorithm | Number theory problem |
| **Prime Checking** | Check if number is prime | O(n) check all divisors | O(√n) check up to sqrt | Mathematical optimization | Divisibility properties |
| **Modular Arithmetic** | Power(a,b) mod m | O(b) multiply b times | O(log b) fast exponentiation | Mathematical property | Large exponents |
| **Graph Algorithms** | Strongly connected components | O(V³) check all pairs | O(V+E) Tarjan's/Kosaraju's | Specialized algorithm | Classical graph problem |
| **Sorting Specific** | Find kth smallest | O(n log n) full sort | O(n) quickselect | Specialized selection | Only need partial order |
| **Cycle Detection** | Detect cycle in linked list | O(n) space with set | O(1) Floyd's algorithm | Specialized technique | Pointer manipulation |

## Decision Framework

| Question to Ask | If Yes → Look for Better | If No → Likely Direct Jump |
|-----------------|-------------------------|---------------------------|
| Can I sort the data to help? | Hash map, two pointers, binary search | Mathematical or specialized algorithm |
| Am I computing the same thing repeatedly? | Memoization, DP | Direct formula or bit trick |
| Can I maintain some state as I iterate? | Sliding window, prefix sums | Classical algorithm needed |
| Are there overlapping subproblems? | Dynamic programming | Independent computations |
| Can I eliminate candidates early? | Pruning, early termination | Must check mathematical property |
| Do I need auxiliary data structure? | Hash map, heap, stack | Pure algorithmic technique |

## Pattern Recognition Tips

### Look for "Better" Solution When:
- **Constraints**: Large n (10⁵ to 10⁶) suggests O(n log n) or O(n)
- **Keywords**: "efficiently", "optimize", "improve"
- **Data**: Arrays, strings, trees with overlapping computations
- **Operations**: Search, sum, count with repeated queries

### Expect Direct Jump When:
- **Math Keywords**: Sum, product, GCD, prime, modular
- **Bit Operations**: XOR, AND, OR, bit counting
- **Classical Problems**: Shortest path, MST, topological sort
- **Constraints**: Very large n (>10⁶) or very specific requirements
- **Pattern**: The brute force and optimal use completely different approaches

## Common Time Complexity Progressions

| Brute Force | Better | Optimal | Problem Domain |
|-------------|--------|---------|----------------|
| O(n³) | O(n²) | O(n log n) | Triple nested loops → DP → Sorting |
| O(n²) | O(n log n) | O(n) | Nested loops → Sorting → Hash/Two pointers |
| O(2ⁿ) | O(n²) | O(n) | Recursion → Memoization → Bottom-up DP |
| O(n×m×k) | O(n×m) | O(n+m) | 3D iteration → 2D DP → Linear scan |