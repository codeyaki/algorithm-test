#https://teching.tistory.com/
import sys
n = int(sys.stdin.readline().rstrip())
nums = [int(sys.stdin.readline().rstrip()) for _ in range(n)]
print(*sorted(nums), sep="\n")