import sys

n = int(sys.stdin.readline().rstrip())
cache = [0]*n
wine = [0] * n
for i in range(n):
    wine[i] = int(sys.stdin.readline().rstrip())
    if i == 0:
        cache[i] = wine[i]
    elif i == 1:
        cache[i] = wine[i - 1] + wine[i]
    elif i == 2:
        cache[i] = max(wine[i - 1] + wine[i], wine[i - 2] + wine[i], wine[i - 2] + wine[i - 1])
    else:
        cache[i] = max(cache[i-3]+wine[i-1]+wine[i], cache[i-2]+wine[i], cache[i-1])

print(cache[n-1])