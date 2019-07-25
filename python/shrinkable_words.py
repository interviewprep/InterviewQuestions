
# Shrinkable words
#
# A  shrinkable word  is a word that can be reduced down to the empty string by deleting 
#one letter at a time such that, at each stage, the remaining string is a word. 
# For example, the word “startling” is shirnkable because of this sequence of words:
#
# startling -> starting -> staring -> string -> sting -> sing -> sin -> in -> i -> (empty)
#
# Write a function that accepts as input a string and a set of all the words in English, 
# then reports whether the input word is shrinkable

def is_shrinkable(s):
	print(s)
	if not s: return True
	if len(s) == 1 and s in words: return True

	for x in range(len(s)):
		w = s[:x] + s[x + 1:]
		if w in words:
			return is_shrinkable(w)
		if x == len(s) - 1:
			return False

if __name__ == '__main__':
    words = {'startling', 'starting', 'staring', 'string', 'sting', 'sing', 'sin', 'in', 'i'}
    print(is_shrinkable('startling'))
	print(is_shrinkable(''))
