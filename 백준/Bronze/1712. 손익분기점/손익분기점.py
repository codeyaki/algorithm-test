import sys
#a:고정비용, b:가변비용, c:노트북가격
a,b,c = map(int,sys.stdin.readline().split())
#1000 + (b*n) - c*n = 0 을 만족하는 n+1이 손익분기점
#즉 n = a/(c-b)+1
if c-b == 0 : n=-1
else : n = int((a/(c-b)) + 1) if (a/(c-b))>=0 else -1
print(n)