#https://teching.tistory.com/
import sys

n = int(sys.stdin.readline().rstrip())
wire = {}
cache = []
for i in range(n):
    a, b = map(int,sys.stdin.readline().split())
    wire[a] = b


for k in sorted(wire.keys()):
    for idx in range(len(cache)):
        if cache[idx] >= wire[k]:
            cache[idx] = wire[k]
            break
    else:
        cache.append(wire[k])

print(n-len(cache))