#https://teching.tistory.com/
from collections import deque
import sys

t = int(sys.stdin.readline().rstrip())
for _ in range(t):
    ops = sys.stdin.readline().rstrip()
    sys.stdin.readline()
    nums = sys.stdin.readline()[1:-2]
    reverse = -1
    if nums == '':
        que = deque()
    else:
        que = deque(nums.split(','))
    for op in ops:
        if op == 'R':
            reverse *= -1
        elif op == 'D':
            if que:
                if reverse == 1:
                    que.pop()
                else:
                    que.popleft()
            else:
                print('error')
                break
    else:
        if reverse == 1:
            que.reverse()
        print("[" + ",".join(que) + "]")
