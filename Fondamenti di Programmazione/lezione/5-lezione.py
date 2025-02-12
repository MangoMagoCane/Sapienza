def occ(lst: list[str], v: str) -> list[int]:
    new_lst: list[int] = []
    for i, s in enumerate(lst):
        if s == v:
            new_lst.append(i)
    return new_lst


def rep(lst: list[int], k: int) -> list[int]:
    new_lst: list[int] = []
    table_lst: list[list[int]] = []
    for n in lst:
        elem_found = False
        for j, el in enumerate(table_lst):
            if el[0] == n:
                table_lst[j][1] += 1
                elem_found = True
                break
        if not elem_found:
            table_lst.append([n, 1])

    for el in table_lst:
        if el[1] >= k:
            new_lst.append(el[0])
    return new_lst


def lastfirst(lst: list[str]) -> str | None:
    chr: str = lst[0][-1]
    for s in lst[1:]:
        if s[0] != chr:
            return s
        else:
            chr = s[-1]


def groupd(lst: list) -> None:
    date_lst: list[str] = []
    for i in range(0, len(lst), 3):
        d, m, y = lst[i : i + 3]
        date_lst.append(f"{str(d)}/{str(m)}/{str(y)}")
    lst[:] = date_lst


def main():
    str_lst: list[str] = ["red", "blue", "red", "gray", "yellow", "red"]
    print(occ(str_lst, "red"))
    print(occ(str_lst, "green"))
    int_lst = [1, 2, 1, 5, 3, 4, 2, 1, 3, 5, 6]
    print(rep(int_lst, 2))
    print(rep(int_lst, 3))
    print(rep(int_lst, 4))
    print(lastfirst(["sole", "elmo", "orco", "alba", "asta"]))
    print(lastfirst(["sky", "you", "use", "ear", "right"]))
    date_lst = [1, 2, 2013, 23, 9, 2011, 10, 11, 2000]
    groupd(date_lst)
    print(date_lst)


if __name__ == "__main__":
    main()
