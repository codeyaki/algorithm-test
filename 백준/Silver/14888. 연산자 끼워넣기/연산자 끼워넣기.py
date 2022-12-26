# https://teching.tistory.com/
import sys

n = int(sys.stdin.readline().rstrip())
nums = list(map(int,sys.stdin.readline().split()))
#operator  0: +, 1: -, 2: *, 3: /
operator = list(map(int,sys.stdin.readline().split()))
answerMax = -1000000000
answerMin = 1000000000
def solve(idx,res):
    global n, answerMin, answerMax, log
    if idx == n:
        answerMin = min(answerMin, res)
        answerMax = max(answerMax, res)
        return
    for i in range(4):
        if operator[i] > 0:
            if i == 0:
                tmp = res+nums[idx]
            elif i == 1:
                tmp = res-nums[idx]
            elif i == 2:
                tmp = res*nums[idx]
            elif i == 3:
                tmp = (res//nums[idx]) if res>=0 else -(-res//nums[idx])
            operator[i] -= 1
            solve(idx+1, tmp)
            operator[i] += 1

solve(1,nums[0])
print(answerMax)
print(answerMin)
