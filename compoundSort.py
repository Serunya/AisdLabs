import time
import random

def quick_sort(alist):
    if len(alist) <= 1:
        return alist
    l_nums,p_nums,b_nums = [],[],[]
    pivot = random.choice(alist)
    for i in alist:
        if i < pivot:
            l_nums.append(i)
        if i > pivot:
            b_nums.append(i)
        if i == pivot:
            p_nums.append(i)
    return quick_sort(l_nums) + p_nums + quick_sort(b_nums)

def selection_sort(alist):
    iteration = 0
    compare = 0
    exchange = 0
    for i in range(0, len(alist) - 1):
        smallest = i
        for j in range(i + 1, len(alist)):
            iteration += 1
            if alist[j] < alist[smallest]:
                compare += 1
                smallest = j
        alist[i], alist[smallest] = alist[smallest], alist[i]
        exchange += 1
    return [iteration,compare,exchange]

def insertion_sort(alist):
    iteration = 0
    compare = 0
    exchange = 0
    for i in range(len(alist)):
        cursor = alist[i]
        pos = i
        while pos > 0 and alist[pos - 1] > cursor:
            iteration+=1
            compare += 1
            exchange += 1
            alist[pos] = alist[pos - 1]
            pos = pos - 1
        alist[pos] = cursor
        exchange += 1
    return [iteration,compare,exchange]

def bubble_sort(alist):
    iteration = 0
    compare = 0
    exchange = 0
    n = len(alist)
    for i in range(0,n):
        for j in range(0,n - 1 - i):
            iteration += 1
            compare += 1
            if alist[j] > alist[j+1]:
                exchange += 1
                alist[j],alist[j+1] = alist[j+1],alist[j]
    return [iteration,compare,exchange]


def quicksort(alist):
    iteration = 0
    compare = 0
    iteration+=1
    if len(alist) <= 1:
        return [1,1]
    l_nums,p_nums,b_nums = [],[],[]
    pivot = random.choice(alist)
    for i in alist:
        if i < pivot:
            compare+=1
            l_nums.append(i)
        if i > pivot:
            compare+=1
            b_nums.append(i)
        if i == pivot:
            compare+=1
            p_nums.append(i)
    temp_l_nums = quicksort(l_nums)
    temp_b_nums = quicksort(b_nums)
    iteration +=  temp_l_nums[0]
    iteration += temp_b_nums[0]
    compare += temp_l_nums[1]
    compare += temp_b_nums[1]
    return [iteration,compare]

def get_rand_list(*args):
    alist = []
    for x in range(0, args[0]):
        alist.append(random.randint(-40000, 40000))
    if len(args) == 2:
        if args[1] == 0:
            return quick_sort(alist)
        if args[1] == 1:
            alist = quick_sort(alist)
            return alist[::-1]
        if args[1] == 25:
            sorted_list_len = int(len(alist)/4)
            return quick_sort(alist[:sorted_list_len]) + alist[sorted_list_len:]
        if args[1] == 50:
            sorted_list_len = int(len(alist) / 2)
            return quick_sort(alist[:sorted_list_len]) + alist[sorted_list_len:]
        if args[1] == 75:
            sorted_list_len = int(len(alist) / 4 * 3)
            return quick_sort(alist[:sorted_list_len]) + alist[sorted_list_len:]
    return alist

def output_table(property):
    len_list = [20, 500, 1000, 3000, 5000, 10000]
    #len_list = [10]
    alist = []
    if property == -1 :
        alist = input("Для 20 элементов введите их с клавиатуры,для рандомной генерации ничего\nВвод:").split()
        for i in range(len(alist)): alist[i] = int(alist[i])
    iterate = "Итерации"
    compare = "Сравнения"
    exchange = "Обмены    "
    print(f"\t\t| %-10s |"
          f" %-7s {iterate} {compare} {exchange} |"
          f" %-9s {iterate} {compare} {exchange}|"
          f" %-11s {iterate} {compare} {exchange}|"
          f" %-7s {iterate} {compare} |" % (
    "Количество",
    "Выбором",
    "Вставками",
    "Пузырьковая",
    "Быстрая"))
    for i in len_list:
        print("\t\t| %-10d |" % i, end="")
        if len(alist) != 20:
            alist = get_rand_list(i, property)
        if i != 20:
            alist = get_rand_list(i, property)
        temp = alist.copy()
        sort_time = time.time()
        count = selection_sort(temp)
        print(" %-7f %-8d %-9d %-10d|" % ((time.time() - sort_time),count[0] , count[1], count[2]), end="")
        temp = alist.copy()
        sort_time = time.time()
        count = insertion_sort(temp)
        print(" %-9f %-8d %-9d %-10d|" % ((time.time() - sort_time),count[0] , count[1],count[2]), end="")
        temp = alist.copy()
        sort_time = time.time()
        count = bubble_sort(temp)
        print(" %-11f %-8d %-9d %-10d|" % ((time.time() - sort_time),count[0] , count[1],count[2]), end="")
        temp = alist.copy()
        sort_time = time.time()
        count = quicksort(temp)
        print(" %-7f %-8d %-9d|" % ((time.time() - sort_time), count[0], count[1]))
        #print(alist)
def task():
    list_property = [-1,0,1,25,50,75]
    name_property = {-1: "Стандартный",
                     0:"Отсартированный массив",
                     1:"Отсартированный в обратном порядке",
                     25: "Частично отсартированный на 25%",
                     50: "Частино отсартированный на 50%",
                     75: "Частично отсартированный на 75%"}
    for i in list_property:
        print(name_property[i])
        output_table(i)
        print("\n")

if __name__ == "__main__":
    task()