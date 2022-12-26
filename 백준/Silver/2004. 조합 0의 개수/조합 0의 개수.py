#https://teching.tistory.com/
import sys
input = sys.stdin.readline

n, k = map(int, input().split())
def countTF(num, d):
    cnt = 0
    div = d
    while div <= num:
        cnt += num//div
        div *= d
    return cnt

print(min(countTF(n,2)-countTF(k,2)-countTF(n-k,2),
          countTF(n,5)-countTF(k,5)-countTF(n-k,5)))