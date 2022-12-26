# https://teching.tistory.com/
import sys

memo = [1,1,1,2,2] +[0 for _ in range(95)]
def p(n):
    if not memo[n] and n>4:
        memo[n] = p(n-5) + p(n-1)
    return memo[n]

n = int(sys.stdin.readline().rstrip())
for _ in range(n):
    num = int(sys.stdin.readline().rstrip())
    print(p(num-1))
