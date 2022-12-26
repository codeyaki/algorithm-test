import sys
A,B= sys.stdin.readline().split()
a=b=''
for i in range(2,-1,-1) :
    a += A[i]
    b += B[i]

print(int(max(a,b)))