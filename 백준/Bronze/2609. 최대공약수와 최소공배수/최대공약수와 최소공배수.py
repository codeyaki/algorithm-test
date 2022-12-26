#https://teching.tistory.com/

#유클리드호제법
def gcd(a, b):
    if b == 0: return a
    return gcd(b, a%b)

num1, num2 = map(int, input().split())
g = gcd(num1, num2)
l = (num1 * num2) // g
print(g)
print(l)
