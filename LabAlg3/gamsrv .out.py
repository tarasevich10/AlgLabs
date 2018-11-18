import copy
import math
from collections import defaultdict


class Digraph(object):
    def __init__(self, nodes=[]):
        self.nodes = set()
        self.neighbours = defaultdict(set)
        self.dist = {}

    def add_node(self, *nodes):
        [self.nodes.add(n) for n in nodes]

    def add_edge(self, frm, to, d=1e309):
        self.add_node(frm, to)
        self.neighbours[frm].add(to)
        self.dist[frm, to] = d

    def dijkstra(self, start, maxD=1e309):
        """Returns a map of nodes to distance from start and a map of nodes to
        the neighbouring node that is closest to start."""
        # total distance from origin
        tdist = defaultdict(lambda: 1e309)
        tdist[start] = 0
        # neighbour that is nearest to the origin
        preceding_node = {}
        unvisited = copy.copy(self.nodes)

        while unvisited:
            current = unvisited.intersection(tdist.keys())
            if not current: break
            min_node = min(current, key=tdist.get)
            unvisited.remove(min_node)

            for neighbour in self.neighbours[min_node]:
                d = tdist[min_node] + self.dist[min_node, neighbour]
                if tdist[neighbour] > d and maxD >= d:
                    tdist[neighbour] = d
                    preceding_node[neighbour] = min_node

        return tdist, preceding_node

    def find_min_path(self, start, end, maxD=1e309):
        """Returns the minimum distance and path from start to end."""
        tdist, preceding_node = self.dijkstra(start, maxD)
        dist = tdist[end]
        backpath = [end]
        try:
            while end != start:
                end = preceding_node[end]
                backpath.append(end)
            path = list(reversed(backpath))
        except KeyError:
            path = None

        return dist, path

    def dist_to(self, *args):
        return self.find_min_path(*args)[0]

    def path_to(self, *args):
        return self.find_min_path(*args)[1]


def read_from_file(filename):
    with open(filename) as file:
        lines = file.readlines()

    nodes_count = int(lines[0].split(" ")[0])
    clients = list(map(int, lines[1].split(" ")))
    nodes = []
    for i in range(1, nodes_count + 1):
        nodes.append(i)

    return nodes, clients, lines[2:]


# main function
nodes, clients, edges = read_from_file("gamsrv.in")

graph = Digraph(nodes)

# filling the graph edges
for edge in edges:
    values = list(map(int, edge.split(" ")))
    graph.add_edge(values[0], values[1], values[2])
    graph.add_edge(values[1], values[0], values[2])

min_total_path = math.inf
for node in range(1, nodes.__len__() + 1):
    if node in clients:
        continue

    max_path_length = graph.find_min_path(node, clients[0])[0]

    for j in range(1, clients.__len__()):
        path_length = graph.find_min_path(node, clients[j])[0]
        if max_path_length < path_length:
            max_path_length = path_length

    if min_total_path > max_path_length:
        min_total_path = max_path_length

print(min_total_path)
