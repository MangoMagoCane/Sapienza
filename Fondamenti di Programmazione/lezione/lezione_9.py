import io
import os
import time
import requests
import files_9_lezione.words as words
from lezione_6 import countw


def clines(fname: str, s: str) -> int:
    count: int = 0
    lower_s = s.lower()
    with open(fname) as file:
        for line in file:
            if lower_s in line.lower():
                count += 1
    return count


def all_char(fname: str, enc: str) -> str:
    char_arr: list[str] = []
    with open(fname, encoding=enc) as file:
        for char in file.read():
            if char not in char_arr:
                char_arr.append(char)
    return "".join(char_arr)


def anagrams(fname: str, w: str) -> list[str]:
    word_lst: list[str] = []
    sorted_w = "".join(sorted(w))
    with open(fname) as file:
        print(type(file))
        for word in words.words(file.read()):
            sorted_word = "".join(sorted(word))
            if sorted_word == sorted_w and word not in word_lst:
                word_lst.append(word)
    return word_lst


def log_update(filelog: io.TextIOWrapper, evento: str) -> None:
    filelog.write(f"{time.ctime()}: {evento}\n")


def findurl(lista_url: list[str], s: str, k: int) -> list[str]:
    url_lst: list[str] = []
    for url in lista_url:
        if countw(requests.get(url).text, s) >= k:
            url_lst.append(url)
    return url_lst


def main():
    os.chdir("files_9_lezione")
    print(clines("testo.txt", "err"))
    print(clines("testo.txt", "Errori"))
    print(all_char("testo.txt", "utf8"))
    print(anagrams("alice.txt", "read"))
    with open("log.log", "a") as file:
        log_update(file, "New event!")
    urls: list[str] = [
        "http://python.org",
        "http://google.com",
        "http://docs.python.org/2.7/index.html",
    ]
    print(findurl(urls, "Python", 2))
    print(findurl(urls, "Python", 7))


if __name__ == "__main__":
    main()
