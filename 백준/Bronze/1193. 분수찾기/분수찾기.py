n= int(input())
index = int((1+((8*n-7)**.5))*.5)
mole= int(n - (index-1)*(index)*.5)
deno = index - mole +1

print(f"{mole}/{deno}" if index %2 ==0 else f"{deno}/{mole}")