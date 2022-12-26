# https://teching.tistory.com/
import sys

n = int(sys.stdin.readline().rstrip())
nums = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline().rstrip())
needs = list(map(int, sys.stdin.readline().split()))
card = {}
for i in nums:
    if i in card:
        card[i] += 1
    else:
        card[i] = 1
for key in needs:
    if key in card:
        print(card[key], end=" ")
    else:
        print(0, end=" ")
