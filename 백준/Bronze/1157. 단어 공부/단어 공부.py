import sys
T= sys.stdin.readline().rstrip().upper()
cnt = [T.count(chr(i)) for i in range(65, 91)]
if cnt.count(max(cnt)) > 1 : print('?')
else : print(chr(cnt.index(max(cnt))+65))