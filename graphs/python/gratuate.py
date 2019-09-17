# Graduate!

# You are enrolled in a degree program and you need to finish certain
# courses before you can graduate. Courses cannot be taken at will.
# Some of them have prerequisites. Only after the completion of prerequisite,
# can you take the course. Given the number of courses and prerequisites
# given to you, write a function that returns true if you have a path to
# graduation.

# Example input -

# Let the courses be represented by a number N. This means you need to take 0..N-1 courses. The prerequisites are expressed in the form of array of array. Following,

# N = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]

# would mean, course 0 is prerequisite for 1 and 2. Similarly, 3 has two prerequisites, 1 and 2.

from collections import defaultdict

def graduate(N, prerequisites):
    graph = build_graph(prerequisites)
    #print(graph)

    current = []
    visited = set()

    for k in graph:
        if not dfs(k, graph, visited, current):
            return False
        else:
            return True

def build_graph(prerequisites):
    graph = defaultdict(list)
    for k, v in prerequisites: graph[v].append(k)
    return graph

def dfs(vertex, graph, visited, current):
    if vertex in visited:
        return True

    if vertex in current:
        print_cycle(current, vertex)
        return False

    current.append(vertex)

    for nbr in graph[vertex]:
        if not dfs(nbr, graph, visited, current):
            return False
        else:
            return True

    current.pop()
    visited.add(vertex)
    return True

def print_cycle(path, vertex):
    result = [vertex]
    x = path.pop()
    while x != vertex:
        result.append(x)
        x = path.pop()
    result.append(vertex)
    print('Cycle ->', result)


if __name__ == "__main__":
    N = 4
    prerequisites = [[1, 0], [2, 0], [3, 1], [3, 2]]
    print(graduate(N, prerequisites))

    prerequisites = [[1, 0], [2, 0], [3, 1], [3, 2], [1, 3]]
    print(graduate(N, prerequisites))
