# Compile dependencies
#
# You are a compiler, responsible for managing dependencies in a project. A project contains multiple programs. Each program specifies what other files it depends on. These dependencies are expressed in the form a adjacency list.
#
# Example - 1 (PASS)
# A -> B, C, D
# B -> E
# C -> F, G
#
# Example - 2 (FAIL)
#
# A -> B, C, D
# B -> E
# E -> A
#
# Example - 3 (PASS)
#
# A -> B, C, D
# B -> C
# C -> F, G
#
#
# Write a function to raise a flag if there are cyclical dependencies.

def compile(graph):
    visited = set()
    path = []

    for vertex in graph:
        if not dfs(vertex, graph, visited, path):
            return False
        else:
            return True

def dfs(vertex, graph, visited, path):
    if vertex in visited:
        return True

    if is_cycle(vertex, path):
        return False

    path.append(vertex)

    for nbr in graph[vertex]:
        if not dfs(nbr, graph, visited, path):
            return False

    visited.add(vertex)
    path.pop()
    return True

def is_cycle(vertex, path):
    if vertex in path:
        return True
    else:
        return False

if __name__ == '__main__':
    d1 = {'a' : ['b', 'c', 'd'], 'b' : ['e'], 'c' : ['f', 'g'], 'd' : [], 'e' : [], 'f' : [], 'g' : []}
    d2 = {'a' : ['b', 'c', 'd'], 'b' : ['e'], 'c' : ['f', 'g'], 'd' : [], 'e' : ['a'], 'f' : [], 'g' : []}
    d3 = {'a' : ['b', 'c', 'd'], 'b' : ['c'], 'c' : ['f', 'g'], 'd' : [], 'e' : [], 'f' : [], 'g' : []}
    print(compile(d1))
    print(compile(d2))
    print(compile(d3))
