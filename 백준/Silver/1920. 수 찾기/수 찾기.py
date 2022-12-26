#https://teching.tistory.com/
import sys
def find(a, list):
    left = 0
    right = len(list)
    mid = 0
    while left < right:
        mid = (left + right) // 2
        if list[mid] == a:
            return 1
        elif list[mid] > a:
            right = mid
        else:
            left = mid + 1
    if list[mid] != a:
        return 0

n = int(sys.stdin.readline().rstrip())
nums = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline().rstrip())
needs = list(map(int, sys.stdin.readline().split()))
nums.sort()

for i in needs:
    print(find(i,nums))