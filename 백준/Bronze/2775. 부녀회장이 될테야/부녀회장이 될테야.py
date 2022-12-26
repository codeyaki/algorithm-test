import sys
def plusFloor(preFloor):
    nextFloor = [sum(preFloor[:i + 1]) for i in range(len(preFloor))]
    return nextFloor

for _ in range(int(sys.stdin.readline().rstrip())):
    k = int(sys.stdin.readline().rstrip())
    n = int(sys.stdin.readline().rstrip())
    liveFloor = [i for i in range(1, n + 1)]
    for _ in range(k):
        liveFloor = plusFloor(liveFloor)
    print(liveFloor[-1])
