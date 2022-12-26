import sys
import itertools
n,m = map(int,sys.stdin.readline().split())
sel = list(itertools.combinations(map(int,sys.stdin.readline().split()),3))
print(max([sum(i) for i in sel if sum(i) <= m]))