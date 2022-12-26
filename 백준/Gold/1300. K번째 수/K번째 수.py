# https://teching.tistory.com/
import sys

def cnt_lowNum(n, target):
    cnt = 0
    for i in range(1, min(n,target)+1):
        cnt += min(target // i, n)
    return cnt

def solution(n, k):
    left = 1
    right = k
    while left <= right:
        mid = (left + right) // 2
        if cnt_lowNum(n, mid) < k:
            left = mid + 1
        else:
            right = mid - 1
    return left

n = int(sys.stdin.readline().rstrip())
k = int(sys.stdin.readline().rstrip())
print(solution(n, k))