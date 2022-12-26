# https://teching.tistory.com/
import sys

n, k = map(int, sys.stdin.readline().split())
dp = [[0] * (k + 1) for _ in range(n + 1)]
nums = []
for _ in range(n):
    nums.append(list(map(int, sys.stdin.readline().split())))
nums.sort()
for line in range(n):
    w, v = map(int, nums[line])
    if w <= k:
        for i in range(w):
            dp[line+1][i] = dp[line][i]
        for i in range(w,k+1):
            dp[line+1][i] = max(dp[line][i-w] + v, dp[line][i])
    else:
        for i in range(k+1):
            dp[line+1][i] = dp[line][i]
print(dp[-1][-1])
