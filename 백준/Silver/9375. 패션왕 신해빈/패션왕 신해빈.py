#https://teching.tistory.com/
import sys

t = int(sys.stdin.readline().rstrip())
for _ in range(t):
    n = int(sys.stdin.readline().rstrip())
    clothes = {}
    for _ in range(n):
        a, b = map(str,sys.stdin.readline().split())
        if not b in clothes: clothes[b] = 1
        else: clothes[b] += 1
    answer = 1
    for k in clothes:
        answer *= clothes[k]+1
    print(answer-1)

