# 블로그: https://teching.tistory.com/
import sys

vowel = ['a', 'i', 'y', 'e', 'o', 'u']
con = ['b', 'k', 'x', 'z', 'n', 'h', 'd', 'c', 'w', 'g', 'p', 'v', 'j', 'q', 't', 's', 'r', 'l', 'm', 'f']

answer = ''
for line in sys.stdin:
    for c in line:
        if c.isalpha():
            isUp = c.isupper()
            res = ''
            if isUp:
                c = c.lower()
            if c in vowel:
                res = vowel[(vowel.index(c)+3)%6]
            elif c in con:
                res = con[(con.index(c)+10)%20]
            if isUp:
                res = res.upper()
            answer += res
        else:
            answer += c
print(answer)



