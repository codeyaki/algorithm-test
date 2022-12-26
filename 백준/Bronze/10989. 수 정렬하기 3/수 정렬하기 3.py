# https://teching.tistory.com/
import sys
countingNum = [0 for i in range(10001)]
for _ in range(int(sys.stdin.readline().rstrip())):
    countingNum[int(sys.stdin.readline().rstrip())] += 1
for i in range(10001):
    for _ in range(countingNum[i]):
        print(i)