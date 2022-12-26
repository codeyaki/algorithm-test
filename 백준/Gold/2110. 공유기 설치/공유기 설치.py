# https://teching.tistory.com/
import sys
def check(n, d, list):
    cnt = 1
    point = list[0]
    for i in list[1:]:
        if i - point >= d:
            cnt += 1
            point = i
    if cnt >= n:
        return True
    else:
        return False

def solution(c, list):
    left = 0
    right = max(list)
    while left <= right:
        mid = (left + right) // 2
        isPossible = check(c, mid, list)
        if isPossible:
            left = mid + 1
        else:
            right = mid - 1
    return right

n, c = map(int, sys.stdin.readline().split())
houses = sorted([int(sys.stdin.readline().rstrip()) for _ in range(n)])
print(solution(c, houses))