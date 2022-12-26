#https://teching.tistory.com/
mode = 10_007
n, k = map(int, input().split())
fac = [1] * (n + 1)
for i in range(1, n + 1):
    fac[i] = (fac[i - 1] * i)

print((fac[n] // (fac[k] * fac[n - k]))%mode)