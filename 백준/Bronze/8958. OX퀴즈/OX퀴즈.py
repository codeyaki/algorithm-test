import sys
n = int(sys.stdin.readline().rstrip())
for _ in range(n) :
    results = str(sys.stdin.readline().split())
    score = 0
    answer = 0
    for result in results :
        if result == 'O' :
            score +=1
            answer +=score
        else :
            score = 0
    print(answer)