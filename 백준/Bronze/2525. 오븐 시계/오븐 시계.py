start = list(map(int,input().split()))
time = int(input().rstrip())

end = (start[0]*60 + start[1] + time)%1440
print(end//60, end%60)