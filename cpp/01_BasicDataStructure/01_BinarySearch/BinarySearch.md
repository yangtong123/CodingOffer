
## 搜索左边界

```c++
int left_bound(int[] nums, int target) {
    if (nums.length == 0) {
        return -1;
    }
    
    int left = 0, right = nums.length;
    
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            right = mid; // 收缩右边界
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else if (nums[mid] > target) {
            right = mid;
        }
    }
    
    return left;
}
```

## 搜索右边界

```c++
int right_bound(int[] nums, int target) {
    if (nums.length == 0) {
        return -1;
    }
    
    int left = 0, right = nums.length;
    
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            left = mid + 1;
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else if (nums[mid] > target) {
            right = mid;
        }
    }
    
    return left - 1;
}
```