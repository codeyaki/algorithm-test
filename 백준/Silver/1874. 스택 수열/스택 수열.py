#https://teching.tistory.com/
import sys
printer = []
n = int(sys.stdin.readline().rstrip())
nums = [0] * n
for i in range(n):
    nums[i] = int(sys.stdin.readline().rstrip())
sortNums = sorted(nums)
stack = []
answer = []
idx = 0
for i in range(n):
    stack.append(sortNums[i])
    printer.append('+')
    while nums and stack and stack[-1] == nums[idx]:
        answer.append(stack.pop())
        printer.append('-')
        idx += 1


if answer == nums:
    print(*printer, sep="\n")
else:
    print("NO")