import random

file = open("lab2", 'w')

for i in range(0,random.randint(10,20)):
    randNumber = random.randint(-100,100)
    file.write(str(randNumber) + "\n")
file.close()

file = open("lab2", 'r')
negative = 0
for line in file:
    line = line.split()
    for i in line:
        if int(i) < 0:
            negative += 1

print("Отрицательных чисел в файле: " + str(negative))
