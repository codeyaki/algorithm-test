#https://teching.tistory.com/
a, b, c = map(int, input().split())


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

res = pastPow(a, b, c)
print(res)