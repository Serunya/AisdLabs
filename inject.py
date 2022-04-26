

def inject(symbol,pos):
    file = open('lab2', 'r+')
    file.seek(pos)
    file_tail = ""
    for line in file:
        file_tail += line
    file.seek(pos)
    file.write(symbol + file_tail)

if __name__ == "__main__":
    inject('w',5)