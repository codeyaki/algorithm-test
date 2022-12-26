import sys
N = int(sys.stdin.readline())
cache = {1: 0, 2: 1}

def dp(n):
    if n in cache:
        return cache[n]

    cache[n] = 1 + min(dp(n//3) + n%3, dp(n//2) + n%2)
    return cache[n]

print(dp(N))