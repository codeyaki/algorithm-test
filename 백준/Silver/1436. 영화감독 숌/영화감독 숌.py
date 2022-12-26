#https://teching.tistory.com/
hellNum = []
i = 0
n = int(input())
while len(hellNum) < n:
    i += 1
    if '666' in str(i):
        hellNum.append(i)
print(hellNum[-1])