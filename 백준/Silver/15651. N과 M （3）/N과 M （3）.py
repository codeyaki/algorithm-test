# https://teching.tistory.com/
def bts(n, m, visited = [],k=0):
    if len(visited) == m:
        print(' '.join(map(str,visited)))
        return
    for i in range(1,n+1):
        visited.append(i)
        bts(n,m,visited,i)
        visited.pop()

n, m = map(int, input().split())
bts(n,m)