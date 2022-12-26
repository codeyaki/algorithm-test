# https://teching.tistory.com/
def bts(n, m, visited = [], k=1):
    if len(visited) == m:
        print(' '.join(map(str,visited)))
        return
    for i in range(k,n+1):
        if i in visited: continue
        visited.append(i)
        bts(n,m,visited,i)
        visited.pop()

n, m = map(int, input().split())
bts(n,m)