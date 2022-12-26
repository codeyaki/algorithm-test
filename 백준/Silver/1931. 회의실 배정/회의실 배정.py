#https://teching.tistory.com/
import sys

n = int(sys.stdin.readline().rstrip())
time = []
for _ in range(n):
    time.append(list(map(int,sys.stdin.readline().split())))
time.sort(key=lambda x: (x[1], x[0]))
useTime = 0
answer = 0
for i in range(n):
    if useTime <= time[i][0]:
        useTime = time[i][1]
        answer += 1

print(answer)
