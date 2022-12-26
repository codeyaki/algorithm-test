s = input()
answer =[s.index(chr(i)) if s.count(chr(i)) else -1 for i in range(97,123) ]
print(*answer)