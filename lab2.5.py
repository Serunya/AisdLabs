def unique_words():
    file = open("text",'r',encoding='utf-8')
    unique_words = set()
    repeat_words = set()
    for line in file:
        temp_words = set(line.split())
        repeat_words = repeat_words | (unique_words & temp_words)
        unique_words = (unique_words | temp_words) - repeat_words
    file.close()
    return len(unique_words)

def repeat_words():
    file = open("text",'r',encoding='utf-8')
    repeat_words = {}
    for line in file:
        for i in line.split():
            if i in repeat_words:
                repeat_words[i] += 1
            else:
                repeat_words[i] = 1
    file.close()
    return repeat_words

def remove_punctuation():
    punctuation = set('.,;:!?()')
    file = open("text", "r+", encoding='utf-8')
    char = file.read(1)
    while char != "":
        if char in punctuation:
            file.seek(file.tell() - 1)
            file.write(" ")
            file.seek(file.tell())
        char = file.read(1)
    return "done"

print(unique_words())
