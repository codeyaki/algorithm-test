#https://teching.tistory.com/
import sys
from collections import deque
n = int(sys.stdin.readline().rstrip())
que = deque()
for _ in range(n):
    line = sys.stdin.readline().split()
    if line[0] == 'push_front':
        que.appendleft(int(line[1]))
    elif line[0] == 'push_back':
        que.append(int(line[1]))
    elif line[0] == 'pop_front':
        print(que.popleft() if que else -1)
    elif line[0] == 'pop_back':
        print(que.pop() if que else -1)
    elif line[0] == 'size':
        print(len(que))
    elif line[0] == 'empty':
        print(0 if que else 1)
    elif line[0] == 'front':
        print(que[0] if que else -1)
    elif line[0] == 'back':
        print(que[-1] if que else -1)



