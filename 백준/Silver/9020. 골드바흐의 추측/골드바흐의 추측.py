import sys
nums = []
#입력 저장
for _ in range(int(sys.stdin.readline().rstrip())) :
    nums.append(int(sys.stdin.readline().rstrip()))
#에라토스테네스의 체
isPrime = [True for i in range(max(nums) + 1)]
isPrime[0]=isPrime[1]=False
for i in range(2, len(isPrime)) :
    if isPrime[i]==False : continue
    else :
        for j in range(i*2, len(isPrime), i) :
            isPrime[j] = False
#골드바흐 파티션
for num in nums :
    for i in range(num//2,num+1) :
        if isPrime[i] :
            if isPrime[num-i] :
                print(num-i,i)
                break


