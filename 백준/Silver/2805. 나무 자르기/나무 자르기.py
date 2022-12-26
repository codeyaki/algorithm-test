# https://teching.tistory.com/
import sys

def solution(m, list):
    left = 0
    right = max(list)
    while left <= right:
        mid = (left + right) // 2
        wood = 0
        for i in list:
            if i > mid:
                wood += i-mid
        if wood >= m:
            left = mid + 1
        else:
            right = mid - 1
    return right


n, m = map(int, sys.stdin.readline().split())
trees = list(map(int, sys.stdin.readline().split()))

print(solution(m, trees))