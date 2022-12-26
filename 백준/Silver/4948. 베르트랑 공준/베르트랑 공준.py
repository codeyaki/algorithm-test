import sys
nums=[]
#입력
for line in sys.stdin:
    if int(line.rstrip()) == 0 : break
    nums.append(int(line.rstrip()))
#에라토스테네스 체
isPrime = [True if i>1 else False for i in range(max(nums)*2+1) ]
for i in range(2, int(len(isPrime)**.5)+1) :
    if isPrime[i] :
        isPrime[i*2::i] = [False]*(max(nums)*2//i-1)
#출력
for num in nums :
    print(sum(isPrime[num+1:num*2+1]))