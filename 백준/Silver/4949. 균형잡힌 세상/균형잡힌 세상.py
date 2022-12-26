#https://teching.tistory.com/
import sys

for inp in sys.stdin:
    ps = inp.rstrip()
    if ps == '.':
        break
    stack = []
    for s in ps:
        if s == '(':
            stack.append('(')
        elif s == ')':
            if stack and stack[-1] == '(':
                stack.pop()
            else:
                stack.append(')')
        elif s == '[':
            stack.append('[')
        elif s == ']':
            if stack and stack[-1] == '[':
                stack.pop()
            else:
                stack.append(']')

    if stack:
        print("no")
    else:
        print("yes")
