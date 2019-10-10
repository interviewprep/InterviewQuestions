# You are given a string s that consists of lower case English letters and brackets. 
# Reverse the strings in each pair of matching parentheses, starting from the innermost one.
# Your result should not contain any brackets.
# Example 1:
#
# Input: s = "(abcd)"
# Output: "dcba"
#
# Example 2:
# 
# Input: s = "(u(love)i)"
# Output: "iloveu"
# Explanation: The substring "love" is reversed first, then the whole string is reversed.
#
# Example 3:
# 
# Input: s = "(es(iv(re))nU)"
# Output: "Universe"
# Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
# 
# Example 4:
# 
# Input: s = "a(bcdefghijkl(mno)p)q"
# Output: "apmnolkjihgfedcbq"

def reverse_parentheses(s):
    stack = []
    
    for x in s:
        if x != ')':
            stack.append(x)
        else:
            temp = get_reverse(stack)
            for c in temp:
                stack.append(c)
    
    return ''.join(stack)

def get_reverse(stack):
    result = []
    x = len(stack) - 1
    while stack[x] != '(':
        result.append(stack.pop())
        x -= 1
    
    stack.pop() # Get rid of '('
    return result

if __name__ == '__main__':
    tests = ["(abcd)", "(u(love)i)", "(es(iv(re))nU)", "a(bcdefghijkl(mno)p)q"]
    for t in tests:
        print(reverse_parentheses(t))
