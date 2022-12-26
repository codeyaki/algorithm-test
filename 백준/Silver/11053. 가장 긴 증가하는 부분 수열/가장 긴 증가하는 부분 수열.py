# https://teching.tistory.com/
import sys
n = int(sys.stdin.readline().rstrip())
nums = list(map(int,sys.stdin.readline().split()))
cache = []
for i in range(len(nums)):
    for c in range(len(cache)):
        if cache[c] >= nums[i]:
            cache[c] = nums[i]
            break
    else:
        cache.append(nums[i])
print(len(cache))