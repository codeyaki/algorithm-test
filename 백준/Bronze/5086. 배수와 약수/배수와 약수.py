#https://teching.tistory.com/
import sys

for line in sys.stdin:
    a, b = map(int,line.split())
    if (a and b) == 0: break
    if a%b == 0: print("multiple")
    elif b%a == 0: print("factor")
    else : print("neither")