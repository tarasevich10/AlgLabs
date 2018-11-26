class Graph:
    def __init__(self, size):
        self.vertexes = {}
        for i in range(size):
            self.vertexes[i] = []

    def add_vertex(self, head, neighbour):
        self.vertexes[head].append(neighbour)

    def friends_counter(self, head):
        counter = -1
        visited = []

        for neighbour in self.vertexes[head]:
            if neighbour not in visited:
                counter += 1
                visited.append(neighbour)
            for sub_neighbour in self.vertexes[neighbour]:
                if sub_neighbour not in visited:
                    counter += 1
                    visited.append(sub_neighbour)

        return counter


def parse_string(str):
    rows = str.split(" ")
    matrix = []
    for i in range(rows.__len__()):
        matrix.append(list(rows[i]))
    return matrix


def find_max_friends(matrix):
    graph = Graph(matrix.__len__())

    for i in range(matrix.__len__()):
        for j in range(i + 1, matrix.__len__()):
            if matrix[i][j] is 'Y':
                graph.add_vertex(i, j)
                graph.add_vertex(j, i)

    max_friend_count = 0
    for i in range(matrix.__len__()):
        friends = graph.friends_counter(i)
        if max_friend_count < friends:
            max_friend_count = friends

    return max_friend_count



""" Main method """
str = "NYNNN YNYNN NYNYN NNYNY NNNYN"
students = parse_string(str)
print(find_max_friends(students))
