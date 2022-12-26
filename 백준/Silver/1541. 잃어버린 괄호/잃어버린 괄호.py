#https://teching.tistory.com/

line = input().split('-')
answer = sum(map(int,line[0].split('+')))
for i in range(1,len(line)):
    answer -= sum(map(int,line[i].split('+')))
print(answer)
