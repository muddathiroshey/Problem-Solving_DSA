# Project Documentation
## Agorithm A (Non-Recursive)

### 1. Pseudocode 
```
FUNCTION maximumProduct(nums[0,1,2...n-1]):

  max1 := -∞, max2 := -∞, max3 := -∞
  min1 := -∞, min2 := -∞

  FOR EACH num IN nums:
    IF num >= max1:
        max3 := max2
        max2 := max1
        max1 := num
    ELSE IF num >= max2:
        max3 := max2
        max2 := num
    ELSE IF num >= max3:
        max3 := num

    IF num <= min1:
        min2 := min1
        min1 := num
    ELSE IF num <= min2:
        min2 := num
 
  product1 := max1 * max2 * max3
  product2 := min1 * min2 * max1 

  RETURN max(product1, product2)
```

### 2. Analysis & Complexity

1. Input size: ``` n ```.<br>
2. Basic operation: The comparison .eg ```num >=max1```.<br>
3. ```T(n) = \sum_{i=0}^{n-1} 1```<br>
4. ```T(n) = (n - 1) - 0 + 1```<br>
5. ```T(n) = n```<br>
6. **Result:** Time complexity of the algorithm is ```Θ(n)```.
 ---

## Algorithm B (Recursive)
### 1. pseudocode
```
FUNCTION maximumProduct(nums[0..n-1]):
    heapSort(nums)
    product1 := nums[n-1] * nums[n-2] * nums[n-3]
    product2 := nums[0]   * nums[1]   * nums[n-1]
    RETURN max(product1, product2)

FUNCTION heapSort(nums[0..n-1]):

    FOR i FROM floor(n/2) - 1 DOWNTO 0:
        heapify(nums, n, i)

    FOR i FROM n-1 DOWNTO 1:
        SWAP nums[0] ↔ nums[i]
        heapify(nums, i, 0)

FUNCTION heapify(nums, heapSize, rootIndex):

    largest := rootIndex
    left    := 2 * rootIndex + 1
    right   := 2 * rootIndex + 2

    IF left < heapSize AND nums[left] > nums[largest]:
        largest := left

    IF right < heapSize AND nums[right] > nums[largest]:
        largest := right

    IF largest != rootIndex:
        SWAP nums[rootIndex] ↔ nums[largest]
        heapify(nums, heapSize, largest)     
```

### 2. Analysis & complexity
##### Heapify (Recursive method):
1. Recurrence relation is: ```T(n) = T(n/2) + Θ(1)```<br>
2. ```a = 1```, ```b = 2```, ```f(n) = 1```.<br>
3. User master method ```\log_b(a)``` = ```\log_2(1) = \n^2 = 1```<br>
4. Since ```\log_b(a)``` = ```f(n)``` we apply case 2.<br>
5. ```T(n) = Θ(\log_b(a) * log n) = Θ(1 * log n) = Θ(log n)```<br>

##### Sort Heap:
1. 1st Loop (Build Max heap): ```\sum_{i=0}^{n/2-1} θ(log n)```<br>
2. ``` T(n) = Θ(n)```.<br>
3. 2nd Loop (Extract elements one by one): ```\sum_{i=1}^{n-1} θ(log i)```<br>
4. T(n) = ```Θ(n log n)```<br>

##### Total Operation Count
```T(n) = Θ(n) + Θ(n log n) + Θ(1)```<br>
Result: Time complexity of the algorithm is: ```Θ(n log n)```<br>
---

## Comparison Between Both Algorithms
| Property | Non-Recursive | Recursive |
| --- | --- | --- |
| Core Method | Single linear scan | Heap Sort |
| Time Complexity | Θ(n) | Θ(n log n) |
| Modifies Array Input | No | Yes (sorts in-place) |
| Handles Negative Inputs | Yes | Yes |
| Practical Speed | Faster — fewer operations | Slower — extra log factor |
| Code Complexity | Low | Medium (heap logic) |
| Best Used When | Only the max-product is needed | Sorted order is also useful |
