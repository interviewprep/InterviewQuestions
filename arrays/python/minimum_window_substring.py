def min_window(self, s: str, t: str) -> str:
    l, r, window = 0, 0, {}
    
    # Dictionary to keep track of count of all unique characters in t
    dict_t = {}
    for x in t: dict_t[x] = dict_t.get(x, 0) + 1
        
    # Number of unique characters that need to be present in answer
    required = len(dict_t)
    
    # Number of unique characters in current window that are present in right frequency
    formed = 0
    
    ans = (len(s), 0 ,0)
    
    while r < len(s):
        # Expand window
        char = s[r]
        window[char] = window.get(char, 0) + 1
        
        # If char in t and also present in window and the number of occurences are as desired then increment formed
        if char in dict_t and window[char] == dict_t[char]:
            formed += 1
            
        # If the desired window is formed then start shrinking it from left
        while formed == required and l <= r:
            c = s[l]
            
            # Save the smallest window
            if ans[0] > r - l + 1:
                ans = (r - l + 1, l, r)
            
            # Remove the character that is out of window because of shrinking
            window[c] -= 1
            if c in dict_t and window[c] < dict_t[c]:
                formed -= 1
            
            l += 1
            
        # Expand window
        r += 1
        
    return "" if ans[0] == 0 else s[ans[1]: ans[2] + 1]