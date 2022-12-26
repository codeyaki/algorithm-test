#https://teching.tistory.com/
import sys
def gcd(a,b):
    if a%b == 0 : return b
    return gcd(b,a%b)

n = int(sys.stdin.readline().rstrip())
for _ in range(n):
    n1, n2 = map(int, sys.stdin.readline().split())
    print(n1*n2//gcd(n1,n2))