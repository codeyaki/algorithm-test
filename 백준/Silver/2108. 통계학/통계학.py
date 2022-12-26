# https://teching.tistory.com/
import sys
cnt = [0 for _ in range(8001)]
n = int(sys.stdin.readline().rstrip())
for _ in range(n):
    num = int(sys.stdin.readline().rstrip())
    cnt[num+4000] += 1
mode = []
total = index = mid = 0
maxN = -4000
minN = 4000
for i in range(8001):
    num = i-4000
    if cnt[i] == max(cnt):
        mode.append(num)
    if cnt[i] > 0:
        maxN = max(maxN, num)
        minN = min(minN, num)
    for _ in range(cnt[i]):
        total += num
        if index == n//2:
            mid = num
        index += 1

print(round(total/n))
print(mid)
print(mode[1] if len(mode)>1 else mode[0])
print(maxN -minN)