#https://teching.tistory.com/

n = int(input())
dis = list(map(int,input().split()))
city = list(map(int,input().split()))

cheapOil = city[0]
answer = 0
for i in range(1,n):
    answer += cheapOil*dis[i-1]
    if cheapOil > city[i]: cheapOil = city[i]

print(answer)
