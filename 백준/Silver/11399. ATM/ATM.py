#https://teching.tistory.com/
import sys

n = int(sys.stdin.readline().rstrip())
nums = sorted(list(map(int,sys.stdin.readline().split())))
answer = 0
for i in range(n):
    answer += nums[i]*(n-i)

print(answer)
