class Graph:
    def __init__(self, size):
        self.vertexes = {}
        for i in range(size):
            self.vertexes[i] = []

    def add_vertex(self, head, neighbour):
        self.vertexes[head].append(neighbour)

    def friends_counter(self, head):
        """Counter starts from '-1' because the first element is head element."""
        counter = -1
        visited = []

        for vertex in self.vertexes[head]:
            if vertex not in visited:
                counter += 1
                visited.append(neighbour)
            # Another cycle to checking vertexes that connected with out direct friends
            for second_vertex in self.vertexes[vertex]:
                if second_vertex not in visited:
                    counter += 1
                    visited.append(second_vertex)

        return counter


""" Main method """
str = "NYNNN YNYNN NYNYN NNYNY NNNYN"
rows = str.split(" ")
matr = []
for n in range(rows.__len__()):
    matr.append(list(rows[]))

rows = str.split(" ")
all_students = []

for i in range(rows.__len__()):
    all_students.append(list(rows[i]))

graph = Graph(matrix.__len__())
for index in range(matrix.__len__()):
    for index2 in range(index+1, matrix.__len__()):
        if matrix[index][index2] is 'Y':
            graph.add_vertex(index2, index2)
            graph.add_vertex(index2, index2)
result = 0
for index in range(matrix.__len__()):
    friends = graph.friends_counter(index)
    if result < friends:
        result = friends



f = open("output", "w")
f.write(result)
