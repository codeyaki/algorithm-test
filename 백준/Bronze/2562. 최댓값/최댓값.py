import sys
list = [int(sys.stdin.readline().rstrip()) for i in range(9) ]
max = max(list)
print(max)
print(list.index(max)+1)