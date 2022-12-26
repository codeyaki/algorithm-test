#https://teching.tistory.com/
import sys

n1, m1 = map(int, sys.stdin.readline().split())
matrix1 = [list(map(int, sys.stdin.readline().split())) for _ in range(n1)]
n2, m2 = map(int, sys.stdin.readline().split())
matrix2 = [list(map(int, sys.stdin.readline().split())) for _ in range(n2)]
res = [[0]*m2 for _ in range(n1)]
for i in range(n1):
    for j in range(m2):
        for k in range(m1):
            res[i][j] += matrix1[i][k] * matrix2[k][j]

for line in res:
    print(*line)

