n = int(input())
data = [list(map(int,input().split())) for i in range(n)]
for i in data :
  print(sum(i))