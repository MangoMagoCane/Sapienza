import os
import files_1.words as words


def wset(fname: str) -> set[str]:
    return {w.lower() for w in words.fwords(fname)}


def wsub(fn1: str, fn2: str) -> set[str]:
    return wset(fn1) - wset(fn2)


def wdict(fname: str) -> dict[str, int]:
    word_dict: dict[str, int] = {}
    word_lst: list[str] = [w.lower() for w in words.fwords(fname)]
    for word in word_lst:
        if word_dict.get(word):
            word_dict[word] += 1
        else:
            word_dict[word] = 1
    return word_dict


def nextw(fname: str) -> dict[str, set[str]]:
    word_dict: dict[str, set[str]] = {}
    word_lst: list[str] = [w.lower() for w in words.fwords(fname)]
    for i in range(len(word_lst) - 1):
        if word_dict.get(word_lst[i]):
            word_dict[word_lst[i]].add(word_lst[i + 1])
        else:
            word_dict[word_lst[i]] = {word_lst[i + 1]}
    return word_dict


def mostf(fname: str, l: int) -> set[str]:
    word_set: set[str] = set()
    highest_freq: int = 0
    for word, freq in wdict(fname).items():
        if len(word) != l:
            continue
        if freq == highest_freq:
            word_set.add(word)
        elif freq > highest_freq:
            word_set.clear()
            word_set.add(word)
            highest_freq = freq
    return word_set


def main():
    os.chdir("files_1")
    print(len(wset("alice.txt")))
    print(len(wsub("alice.txt", "holmes.txt")))
    d1: dict[str, int] = wdict("alice.txt")
    print(d1["alice"], d1["rabbit"], d1["queen"])
    d2: dict[str, set[str]] = nextw("alice.txt")
    print(d2["go"], d2["write"], sep="\n")
    print(mostf("holmes.txt", 7))
    print(mostf("frankenstein.txt", 16))


if __name__ == "__main__":
    main()
