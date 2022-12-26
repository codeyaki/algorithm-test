#https://teching.tistory.com/
import sys

n = int(sys.stdin.readline().rstrip())
nums = list(map(int,sys.stdin.readline().split()))
answer = [-1] * n
stack = [0]
for i in range(1,n):
    while stack and nums[stack[-1]] < nums[i]:
        answer[stack.pop()] = nums[i]
    stack.append(i)

print(*answer)