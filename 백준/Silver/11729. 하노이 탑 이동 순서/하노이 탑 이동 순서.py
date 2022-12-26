def hanoi(n) :
    if n == 1 : return ["1 3"]
    if n%2 == 0 :
        tmp = ["1 2", "2 3", "3 1"]
    else :
        tmp = ["1 3", "3 2", "2 1"]
    pre = hanoi(n-1)
    new = []
    for i in range(len(pre)) :
        new.append(tmp[i%3])
        new.append(pre[i])
    else :
        new.append(tmp[len(pre)%3])
    return new
hanoiList = hanoi(int((input())))
print(len(hanoiList))
print('\n'.join(hanoiList))