#https://teching.tistory.com/
import sys
def divisor(num):
    res = set()
    for i in range(1, int(num**.5)+1):
        if num%i==0:
            res.add(i)
            res.add(num//i)
    else:
        res.remove(1)
    return res

n = int(sys.stdin.readline().rstrip())
nums = []
for _ in range(n):
    nums.append(int(sys.stdin.readline().rstrip()))
dif = max(nums) - min(nums)
div = divisor(dif)
answer = []
for i in div:
    tmp = nums[0]%i
    for j in nums:
        if tmp != (j%i): break
    else:
        answer.append(i)

print(*sorted(answer))