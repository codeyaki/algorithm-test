#한수판별기
def d(n) :
    #등차수열 항 : An = a + (n-1)d
    tmp = list(map(int,str(n)))
    d = tmp[1]-tmp[0] if len(tmp)>1 else 0
    for i in range(len(tmp)) :
        if tmp[i] != tmp[0] + ((i)*d) : 
            return 0
    else : 
        return 1

n = int(input())
cnt = 0
for i in range(1,n+1) :
    cnt += d(i)
print(cnt)