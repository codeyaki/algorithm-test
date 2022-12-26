import sys

str1 = sys.stdin.readline().rstrip()
str2 = sys.stdin.readline().rstrip()
cache = [[0] * (len(str2)+1) for _ in range(len(str1)+1)]
for i in range(1, len(str1)+1):
    for j in range(1, len(str2)+1):
        if str1[i-1] == str2[j-1]:
            cache[i][j] = cache[i-1][j-1] + 1
        else:
            cache[i][j] = max(cache[i - 1][j], cache[i][j - 1])

print(cache[-1][-1])
