import sys
sys.stdin.readline()
nums = list(map(int,sys.stdin.readline().split()))
answer = 0
for num in nums :
    if num == 1 : continue
    for i in range(2,int(num**.5)+1) :
        if num%i ==0 :
            break
    else : answer +=1
print(answer)