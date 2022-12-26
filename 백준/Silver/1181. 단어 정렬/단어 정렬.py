# https://www.acmicpc.net/problem/1181
# https://teching.tistory.com/
import sys
words = list({sys.stdin.readline().rstrip() for _ in range(int(sys.stdin.readline().rstrip()))})
words.sort(key= lambda x: (len(x),x))
print(*words, sep='\n')