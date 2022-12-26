# https://www.acmicpc.net/problem/18870
# https://teching.tistory.com/
import sys
sys.stdin.readline()
nums = list(map(int, sys.stdin.readline().split()))
sNums = sorted(set(nums))
dictNum = {}
for i, n in enumerate(sNums):
    dictNum[n] = i
for n in nums:
    print(dictNum[n], sep=' ')