#https://teching.tistory.com/
import sys

n = int(sys.stdin.readline().strip())
nums = list(map(int, sys.stdin.readline().split()))
cache1 = [0] * n
cache2 = [0] * n
for i in range(n):
    tmp = [0, 0]
    for j in range(i - 1, -1, -1):
        if nums[i] > nums[j]:
            if tmp[1] < cache1[j]:
                tmp = [nums[j], cache1[j]]
    cache1[i] = tmp[1] + 1
for i in range(n - 1, -1, -1):
    tmp = [0, 0]
    for j in range(i+1, n):
        if nums[i] > nums[j]:
            if tmp[1] < cache2[j]:
                tmp = [nums[j], cache2[j]]
    cache2[i] = tmp[1] + 1
answer = list(map(lambda x, y: x + y - 1, cache1, cache2))
print(max(answer))
