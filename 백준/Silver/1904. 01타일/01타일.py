# https://teching.tistory.com/
n = int(input())
num1 = 1
num2 = 1
for i in range(n-1):
    num1, num2 = num2, (num1+num2)%15746
print(num2)