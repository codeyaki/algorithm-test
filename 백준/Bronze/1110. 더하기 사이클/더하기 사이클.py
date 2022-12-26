new = num = int(input())
cnt = 0
while True:
    cnt += 1 
    n10 = new//10
    n1 = new%10
    sum = n1 + n10
    new =(n1*10) + (sum%10)
    if new == num : break
print(cnt)