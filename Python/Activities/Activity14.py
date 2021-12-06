def fibo(num):
    if num <= 1:
        return num
    else:
        return(fibo(num-1) + fibo(num-2))

n = int(input("Enter a number: "))

if n <= 0:
    print("Please enter a positive num")
else:
    print("fibonacci Sequence: ")
    for i in range(n):
        print(fibo(i))