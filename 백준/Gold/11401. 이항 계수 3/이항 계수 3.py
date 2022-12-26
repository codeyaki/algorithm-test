# https://teching.tistory.com/

n, k = map(int, input().split())
mode = 1_000_000_007

def pastPow(a, b, c):
    if b == 0:
        return 1
    elif b == 1:
        return a % c
    else:
        DivCon = pastPow(a, b // 2, c)
        if b % 2 == 0:
            return (DivCon * DivCon) % c
        else:
            return (DivCon * DivCon * pastPow(a, 1, c)) % c

fac = [1, 1] + [1] * (n - 1)
for i in range(1, n + 1):
    fac[i] = (fac[i - 1] * i) % mode
    
answer = (fac[n] * pastPow((fac[k]*fac[n-k])%mode, mode-2, mode))%mode
print(answer)