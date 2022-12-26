#https://teching.tistory.com/
import sys


def matrixMultiple(matrix1, matrix2):
    res = [[0] * len(matrix2[0]) for _ in range(len(matrix1))]
    for i in range(len(matrix1)):
        for j in range(len(matrix2[0])):
            for k in range(len(matrix1[0])):
                res[i][j] += matrix1[i][k] * matrix2[k][j]
                res[i][j] %= 1_000_000_007
    return res


def matrixSquare(matrix, b):
    if b == 1:
        return matrix
    divMatrix = matrixSquare(matrix, b // 2)
    squareMatrix = matrixMultiple(divMatrix, divMatrix)
    if b % 2 == 0:
        return squareMatrix
    else:
        return matrixMultiple(squareMatrix, matrix)


n = int(input())
matrix = [[1, 1], [1, 0]]
if n <= 1:
    print(n)
else:
    answer = matrixSquare(matrix, n - 1)
    print(answer[0][0] % 1_000_000_007)
