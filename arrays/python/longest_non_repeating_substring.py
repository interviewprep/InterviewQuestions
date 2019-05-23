def length_of_longest_substring(self, s):

    x = -1
    distinct = {}
    window = 0
    
    for y in range(len(s)):
        char = s[y]
        x = max(distinct.get(char, -1), x)
        window = max(window, y - x)
        distinct[char] = y
    
    return window