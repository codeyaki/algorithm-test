#https://teching.tistory.com/
import sys
from collections import deque

t = int(sys.stdin.readline().rstrip())
for _ in range(t):
    n, m = map(int, sys.stdin.readline().split())
    priority = list(map(int, sys.stdin.readline().split()))
    printer = deque([i, j] for i, j in zip(range(n), priority))
    priority.sort()
    cnt = 0
    while 1:
        if printer[0][1] < priority[-1]:
            printer.rotate(-1)
        elif printer[0][1] == priority[-1]:
            cnt += 1
            tmp = printer.popleft()
            if m == tmp[0]:
                break
            priority.pop()

    print(cnt)
