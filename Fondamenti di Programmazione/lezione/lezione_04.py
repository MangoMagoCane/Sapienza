def prec(g1: int, m1: int, a1: int, g2: int, m2: int, a2: int) -> bool:
    if a1 != a2:
        return a1 < a2
    if m1 != m2:
        return m1 < m2
    if g1 != g2:
        return g1 < g2
    return False


def l2d(lst: list[str]) -> list[int]:
    new_lst: list[int] = []
    lookup_num: list[str] = [
        "zero",
        "uno",
        "due",
        "tre",
        "quattro",
        "cinque",
        "sei",
        "sette",
        "otto",
        "nove",
    ]

    for s in lst:
        for i in range(len(lookup_num)):
            if lookup_num[i] == s:
                new_lst.append(i)
                break
    return new_lst


def distinct(lst: list[int | str]) -> list[int | str]:
    new_lst: list[int | str] = []
    for n in lst:
        if n not in new_lst:
            new_lst.append(n)
    return new_lst


def search(
    lst: list[str], andc: list[str], orc: list[str], notc: list[str]
) -> list[str]:
    new_lst: list[str] = []
    for s1 in lst:
        invalid_str: bool = False
        for s2 in andc:
            if s2 not in s1:
                invalid_str = True
                break
        if invalid_str:
            continue

        if len(orc) > 0:
            invalid_str = True
            for s2 in orc:
                if s2 in s1:
                    invalid_str = False
                    break
            if invalid_str:
                continue

        for s2 in notc:
            if s2 in s1:
                invalid_str = True
                break
        if invalid_str:
            continue

        new_lst.append(s1)
    return new_lst


def main():
    print(prec(13, 11, 2012, 2, 3, 2013))
    print(prec(13, 11, 2012, 27, 12, 2011))
    print(prec(1, 10, 2013, 1, 11, 2013))
    print(l2d(["nove", "due", "due", "tre"]))
    print(distinct([3, 1, 3, 2, 6, 6]))
    print(distinct(["a", "ab", "a", "ab"]))
    lst: list[str] = ["mela", "pera", "melo"]
    print(search(lst, ["el", "a"], ["ra", "pe", "m"], ["tt", "lo"]))
    print(search(lst, [], ["ra", "pe", "m"], ["tt", "lo"]))
    print(search(lst, ["el", "a"], [], ["tt", "lo"]))
    print(search(lst, [], ["ra", "pe", "m"], []))


if __name__ == "__main__":
    main()
