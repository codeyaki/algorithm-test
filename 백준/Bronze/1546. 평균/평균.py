import sys
sys.stdin.readline()
score = list(map(int,sys.stdin.readline().split()))
score = [i/max(score)*100 for i in score]
print(sum(score)/len(score))