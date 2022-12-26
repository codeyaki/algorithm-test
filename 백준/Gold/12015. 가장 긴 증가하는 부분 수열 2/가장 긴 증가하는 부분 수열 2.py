# 블로그: https://teching.tistory.com/
import sys
def binarySearch(target, list):
    left = 0
    right = len(list)
    while left <= right:
        mid = (left + right)//2
        if target > list[mid]:
            left = mid + 1
        elif target < list[mid]:
            right = mid - 1
        else:
            return mid
    return left

n = int(sys.stdin.readline().rstrip())
nums = list(map(int, sys.stdin.readline().split()))
answer = [1000000]
for i in nums:
    if answer[-1] < i:
        answer.append(i)
    else:
        answer[binarySearch(i,answer)] = i
print(len(answer))