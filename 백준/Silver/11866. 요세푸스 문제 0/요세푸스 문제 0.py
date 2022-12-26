#https://teching.tistory.com/
import sys
from collections import deque

n, k = map(int, sys.stdin.readline().split())
ring = deque(list(range(1,n+1)))
answer = []
while ring:
    ring.rotate(-k)
    answer.append(ring.pop())


print("<", sep="", end="")
print(*answer, sep= ", ", end="")
print(">", sep="", end="")
