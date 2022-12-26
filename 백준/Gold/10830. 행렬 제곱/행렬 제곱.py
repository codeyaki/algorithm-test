#https://teching.tistory.com/
import sys

def matrixMultiple(matrix1, matrix2):
    res = [[0]*len(matrix2[0]) for _ in range(len(matrix1))]
    for i in range(len(matrix1)):
        for j in range(len(matrix2[0])):
            for k in range(len(matrix1[0])):
                res[i][j] += matrix1[i][k] * matrix2[k][j]
                res[i][j] %= 1000
    return res


def matrixSquare(matrix, n, b):
    if b == 1:
        return matrix
    divMatrix = matrixSquare(matrix, n, b//2)
    squareMatrix = matrixMultiple(divMatrix, divMatrix)
    if b%2 == 0:
        return squareMatrix
    else:
        return matrixMultiple(squareMatrix, matrix)

n, b = map(int, sys.stdin.readline().split())
matrix = [list(map(int, sys.stdin.readline().split())) for i in range(n)]
answer = matrixSquare(matrix, n, b)
for i in answer:
    for j in i:
        print(j%1000, end=" ")
    print("")