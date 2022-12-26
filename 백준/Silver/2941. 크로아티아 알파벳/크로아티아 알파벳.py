import sys
s = sys.stdin.readline().rstrip()
croAlpha = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
cnt = 0
for i in croAlpha :
    s = s.replace(i, '1')
print(len(s))
