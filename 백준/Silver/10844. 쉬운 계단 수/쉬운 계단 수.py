# https://teching.tistory.com/
n = int(input())
cache = {
    1: [0, 1, 1, 1, 1, 1, 1, 1, 1, 1]
}
mode = 1_000_000_000
for i in range(2, n + 1):
    cache[i] = [0] * 10
    for j in range(10):
        if j < 9:
            cache[i][j] = (cache[i][j]+cache[i - 1][j + 1]) % mode
        if j > 0:
            cache[i][j] = (cache[i][j]+cache[i - 1][j - 1]) % mode
print(sum(cache[n]) % mode)