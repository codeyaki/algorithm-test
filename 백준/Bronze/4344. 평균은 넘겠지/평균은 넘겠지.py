import sys
n = int(sys.stdin.readline().rstrip())
for _ in range(n) :
    score = list(map(int,sys.stdin.readline().split()))[1:]
    average = sum(score)/len(score)
    winner = [i for i in score if i>average]
    print(f"{len(winner)/len(score)*100:.3f}%")