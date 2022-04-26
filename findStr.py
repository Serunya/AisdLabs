def find(substring):
    sub = {}
    count_lines = 1
    file = open('text', 'r+',encoding='utf-8')
    for line in file:
        substring_index = line.find(substring)
        if substring_index != -1:
            sub[count_lines] = substring_index + 1
        count_lines += 1
    return sub


if __name__ == '__main__':
    g = find("дима");
    for i in g:
        print("Строка: " + str(i) + "; Позиция: " + str(g[i]))

