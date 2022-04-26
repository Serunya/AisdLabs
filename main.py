import random
import time

def quick_sort(alist):
    if len(alist) <= 1:
        return alist
    e_nums,p_nums,b_nums = [],[],[]
    p = random.choice(alist)
    for i in alist:
        if i < p:
            e_nums.append(i)
        if i > p:
            b_nums.append(i)
        if i == p:
            p_nums.append(i)
    return quick_sort(e_nums) + p_nums + quick_sort(b_nums)

def barier_search(alist,search_item):
    alist.append("end")
    i = 0
    while alist[i] != "end" or alist[i] == search_item:
        i+=1

def linear_search(alist, search_item):
    count_comp = 0
    for i in alist:
        if i == search_item:
            count_comp+=1
            return count_comp
        else:
            count_comp+=1

def binary_search(alist, search_item):
    if len(alist) <= 1:
        return 0
    count_comp = 0
    pos_middle_element = int(len(alist) / 2)
    if alist[pos_middle_element] == search_item:
        return 1
    if alist[pos_middle_element] > search_item:
        count_comp += binary_search(alist[:pos_middle_element - 1], search_item)
    else:
        count_comp += binary_search(alist[1 + pos_middle_element:], search_item)
    return count_comp+1
def get_rand_list(len_list):
    alist = []
    for i in range(len_list):
        alist.append(random.randint(-40000,40000))
    return alist

def first_task():
    task_list = [100,500,1000,3000,10000]
    for i in task_list:
        print("Линейный поиск для", i, "элементов")
        for j in range(3):
            print("\tПопытка", j)
            alist = get_rand_list(i)
            search_item = random.choice(alist)
            start_time = time.time()
            count_comp = linear_search(alist,search_item)
            print("\t\tВремя выполнения: %.6f" % (time.time() - start_time), "Кол-во сравнений", count_comp)
        print()

def second_task():
    task_list = [100, 500, 1000, 3000, 10000]
    for i in task_list:
        print("Бинарный поиск для", i, "элементов")
        for j in range(3):
            print("\tПопытка", j)
            alist = get_rand_list(i)
            alist = quick_sort(alist)
            search_item = random.choice(alist)
            start_time = time.time()
            count_comp = binary_search(alist, search_item)
            print("\t\tВремя выполнения: %.6f" % (time.time() - start_time), "Кол-во сравнений", count_comp)
        print()

def third_task():
    task_list = [100, 500, 1000, 3000, 10000]
    for i in task_list:
        print("Линьйный поиск с барьером для", i, "элементов")
        for j in range(3):
            print("\tПопытка", j)
            alist = get_rand_list(i)
            search_item = random.choice(alist)
            start_time = time.time()
            barier_search(alist, search_item)
            print("\t\tВремя выполнения: %.6f" % (time.time() - start_time))
        print()

if __name__ == '__main__':
    first_task()
    second_task()
    third_task()