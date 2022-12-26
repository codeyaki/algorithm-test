#https://teching.tistory.com/

import sys

n, k = map(int,sys.stdin.readline().split())
coin = []
for _ in range(n):
    insert = int(sys.stdin.readline().rstrip())
    if insert > k : break
    coin.append(insert)

cnt = 0
for i in range(len(coin)-1,-1,-1):
    cnt += k // coin[i]
    k %= coin[i]
    if k == 0 : break

print(cnt)