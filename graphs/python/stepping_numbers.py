# A Stepping Number is an integer such that all of its adjacent digits have an absolute difference of exactly 1. For example, 321 is a Stepping Number while 421 is not.
#
# Given two integers low and high, find and return a sorted list of all the Stepping Numbers in the range [low, high] inclusive.
#
# Input  -> low = 0, high = 100
# Result ->[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98]
# Input  -> low = 100, high = 200
# Result -> [101, 121, 123]
#

def stepping_numbers(low, high):
    result = []
    if low > high: return result
    
    queue = list(range(1, 10))
    
    if low == 0: result.append(low)
    
    while queue:
        current = queue.pop(0)
        
        if current >= low and current <= high:
            result.append(current)
        
        if current < high:
            remainder = current % 10
            if remainder > 0:
                queue.append(current * 10 + remainder - 1)
            if remainder < 9:
                queue.append(current * 10 + remainder + 1)
    
    return result

if __name__ == '__main__':
    print(stepping_numbers(0, 100))
    print(stepping_numbers(100, 200))
