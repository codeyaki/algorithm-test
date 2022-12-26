#https://teching.tistory.com/
import sys

n =int(sys.stdin.readline().rstrip())

priceMemo = [0,0,0]
for i in range(n):
    nums = (list(map(int, sys.stdin.readline().split())))
    tmp = [0,0,0]
    tmp[0] = min(nums[0]+priceMemo[1], nums[0]+priceMemo[2])
    tmp[1] = min(nums[1]+priceMemo[0], nums[1]+priceMemo[2])
    tmp[2] = min(nums[2]+priceMemo[0], nums[2]+priceMemo[1])
    priceMemo = tmp

print(min(priceMemo))