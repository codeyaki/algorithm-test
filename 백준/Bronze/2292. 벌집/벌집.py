import math
an = int(input())
#n테두리의 끝방번호는 계차수열 an= 1+3(n(n-1)) // {bn = 6n}
#일반항 3n^2 - 3n + 1-an = 0
#근의공식중 양수
#그사이에 해당하는 방은 전부 올림처리 
answer = math.ceil((3+(12*an -3)**(1/2))/6)
print(answer)