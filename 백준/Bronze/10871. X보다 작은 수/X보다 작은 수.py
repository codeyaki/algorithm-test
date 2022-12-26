import sys
N, X = map(int,sys.stdin.readline().split())
data =[i for i in sys.stdin.readline().split() if int(i)<int(X)]

print(*data)