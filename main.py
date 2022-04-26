import os
import random

class hash:
    hash_table = []

    def set(self,value):
        hash_sum = hash_string(value)
        e = self.get(self,hash_sum)
        if e == -1:
            self.hash_table.append([hash_sum, value])
            return -1
        filer = open("hash_table", "r")
        filew = open("temp", "w")
        c = True
        for i in filer:
            j = i.split()
            if int(j[0]) == hash_sum:
                if i.find(value) == -1:
                    c = False
                    filew.write(i.rstrip() + " " + value + "\n")
            else:
                filew.write(i)
        if c:
            filew.write(str(hash_sum) + " " + str(e[0]) + " " + str(value).rstrip() + "\n")
        filew.close()
        filer.close()
        os.remove("hash_table")
        os.rename("temp", "hash_table")

    def get(self,hash_sum):
        count = 0
        for i in self.hash_table:
            count += 1
            if i[0] == hash_sum:
                return [i[1],count]
        return -1

    def file_get(self,hash_sum):
        file = open("hash_table","r")
        for i in file:
            j = i.split()
            if int(j[0]) == hash_sum:
                file.close()
                return i
        file.close()
        return -1
    def sort_table(self):
        self.hash_table = quick_sort(self.hash_table)

def quick_sort(ls):
    if len(ls) < 2:
        return ls
    p_num = random.choice(ls)[0]
    b_nums = []
    l_nums = []
    p_nums = []
    for i in ls:
        if p_num < i[0]:
            b_nums.append(i)
        if p_num > i[0]:
            l_nums.append(i)
        if p_num == i[0]:
            p_nums.append(i)
    return quick_sort(l_nums) + p_nums + quick_sort(b_nums)


def get_num_ABC(i):
    i = i.lower()
    if not i.isalpha():
        return 0
    ru = ord(i) - 1071
    if ru < 0:
        return ord(i) - 96
    return ru

def hash_string(string):
    hash_sum = 0
    for i in string:
        hash_sum += get_num_ABC(i)
    return hash_sum

def h_string(string):
    hash_sum = 0
    for i in string:
        hash_sum += ord(i)
    return hash_sum
if __name__ == '__main__':
    h = hash
    h.set(h,"ааа")
    h.set(h, "ба")
    h.set(h, "в")
    h.set(h, "г")
    h.set(h, "бб")
    h.set(h,"aaaa")
    h.set(h,"ва")
    print(h.file_get(h,38))
    h.sort_table(h)