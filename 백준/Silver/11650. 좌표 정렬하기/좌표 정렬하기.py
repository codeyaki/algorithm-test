#https://teching.tistory.com/
import sys
dots = [tuple(map(int,sys.stdin.readline().split())) for _ in range(int(sys.stdin.readline().rstrip()))]
dots.sort(key= lambda x : (x[0], x[1]))
for i in dots:
    print(i[0], i[1])