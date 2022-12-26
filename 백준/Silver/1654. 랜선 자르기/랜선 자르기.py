# https://teching.tistory.com/
import sys

def solution(n, list):
    left = 1
    right = max(list)
    while left <= right:
        mid = (left + right) // 2
        cnt = 0
        for i in list:
            cnt += i//mid
        if cnt >= n:
            left = mid + 1
        else:
            right = mid - 1
    return right

k, n = map(int, sys.stdin.readline().split())
cables = [int(sys.stdin.readline().rstrip()) for _ in range(k)]

print(solution(n, cables))