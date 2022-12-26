import sys
s = sys.stdin.readline().rstrip()
time = 0
for i in s :
    if i >= 'W' :
        time += 10
    elif i >= 'T' :
        time += 9
    elif i >= 'P' :
        time += 8
    elif i >= 'M' :
        time += 7
    elif i >= 'J' :
        time += 6
    elif i >= 'G' :
        time += 5
    elif i >= 'D' :
        time += 4
    elif i>= 'A' :
        time += 3
print(time)

