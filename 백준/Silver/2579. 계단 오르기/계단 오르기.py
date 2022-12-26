# https://teching.tistory.com/
import sys

floors = int(sys.stdin.readline().rstrip())
memo1 = [0, 0] # 이전 층을 밟지 않는 경우 // 이전 층을 밟는 경우
memo2 = [0, 0]
for _ in range(floors):
    num = int(sys.stdin.readline().rstrip())
    #n-2층 에서 바로오는 경우
    tmp1 = max(memo2[0] + num, memo2[1] + num)
    #n-1층을 밟고 연속되게 올라오는 경우(다음층은 밟으면 안됨)
    tmp2 = memo1[0] + num
    memo2 = memo1
    memo1 = [tmp1, tmp2]
print(max(memo1))