import sys
for _ in range(int(sys.stdin.readline().rstrip())) :
    x,y = map(int,sys.stdin.readline().split())
    distance = y-x
    sqrtDistance = distance**.5
    movecnt = int(sqrtDistance)*2 - 1
    # 거리가 제곱근일 경우
    if sqrtDistance%1 == 0 :
        print(movecnt)
    # 거리의 제곱근의 소수점 부분이 0.5 이하일 경우
    elif sqrtDistance%1 < .5 :
        print(movecnt+1)
    # 거리의 제곱근의 소수점 부분이 0.5이상일 경우
    elif sqrtDistance%1 > .5 :
        print(movecnt+2)