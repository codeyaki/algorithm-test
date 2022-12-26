#https://teching.tistory.com/
import sys

n = int(sys.stdin.readline().rstrip())
for _ in range(n):
    ps = sys.stdin.readline().rstrip()
    stack = []
    for s in ps:
        if s == '(':
            stack.append('(')
        if s == ')':
            if stack and stack[-1] == '(':
                stack.pop()
            else:
                stack.append(')')
    if stack:
        print("NO")
    else:
        print("YES")
