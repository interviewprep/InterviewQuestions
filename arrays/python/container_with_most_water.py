def max_area(self, height):
    
    result = 0
    l, r = 0, len(height) - 1
    
    while l < r:
        current_area = min(height[l], height[r]) * (r - l)
        result = max(result, current_area)
        
        if height[l] < height[r]:
            l += 1
        else:
            r -= 1
    
    return result
