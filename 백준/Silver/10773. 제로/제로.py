import sys
stack = []
for _ in range(int(sys.stdin.readline().rstrip())):
    n = int(sys.stdin.readline().rstrip())
    if n == 0 :
        if stack == []:
            stack.append(0)
        else: stack.pop()
    else:
        stack.append(n)

print(sum(stack))