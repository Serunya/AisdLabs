def out_string(num_str):
    file = open('text', 'r+',encoding='utf-8')
    count_str = 0
    for line in file:
        if count_str == num_str:
            print(str(line))
            break
        else:
            count_str += 1
    if count_str < num_str:
        print("Такой строки нет")

if __name__ == '__main__':
    out_string(0)
