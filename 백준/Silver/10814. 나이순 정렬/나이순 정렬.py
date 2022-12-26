# https://www.acmicpc.net/problem/1181
# https://teching.tistory.com/
import sys
res = [list(map(str, sys.stdin.readline().split()))+[i] for i in range(int(sys.stdin.readline().rstrip()))]
res.sort(key=lambda x: (int(x[0]), x[2]))
for i in res:
    print(int(i[0]), i[1])