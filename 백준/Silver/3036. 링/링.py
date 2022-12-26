#https://teching.tistory.com/

def gcd(a,b):
    if a%b == 0: return b
    return gcd(b,a%b)

n = int(input())
rings = list(map(int,input().split()))

for i in range(1,n):
    g = gcd(rings[0],rings[i])
    print(f"{rings[0]//g}/{rings[i]//g}")


