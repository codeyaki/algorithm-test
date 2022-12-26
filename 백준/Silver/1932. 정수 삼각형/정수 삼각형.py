# https://teching.tistory.com/
import sys
n = int(sys.stdin.readline().rstrip())
memo = [0]*n
for l in range(1,n+1):
    nums = list(map(int,sys.stdin.readline().split()))
    tmp = [0]*l
    for i in range(l):
        if i == 0: tmp[i] += memo[i]+nums[i]
        else:
            tmp[i] = max(nums[i]+memo[i-1], nums[i]+memo[i])
    memo[:l] = tmp
print(max(memo))
