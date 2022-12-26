n = int(input())
while n>1 :
    for i in range(2,int(n**.5)+1):
        if n%i == 0 :
            print(i)
            n //= i
            break
    else :
        print(n)
        break