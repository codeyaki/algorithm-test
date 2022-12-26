# https://teching.tistory.com/
import sys

n = int(sys.stdin.readline().rstrip())
stat = []
for i in range(n):
    stat.append(list(map(int,sys.stdin.readline().split())))
answer = 2000
def solve(team1,check):
    global n, answer
    if answer == 0: return
    if len(team1) == (n//2):
        team2 = set(range(n))-team1
        answer= min(answer, score(team1, team2))
        return
    for i in range(check,n):
        s = 0
        if i in team1: continue
        team1.add(i)
        solve(team1,i)
        team1.remove(i)

def score(team1, team2):
    score1 = 0
    score2 = 0
    for t1 in team1:
        for i in team1:
            score1 += stat[t1][i]
    for t2 in team2:
        for i in team2:
            score2 += stat[t2][i]
    return abs(score1-score2)

solve(set(),0)
print(answer)