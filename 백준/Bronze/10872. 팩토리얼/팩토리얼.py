def fact(i) :
    if i <2 : return 1
    return i * fact(i-1)
print(fact(int(input())))