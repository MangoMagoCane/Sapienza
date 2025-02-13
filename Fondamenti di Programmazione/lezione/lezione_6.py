def firstline(t: str, s: str) -> str | None:
    for line in t.splitlines():
        if s in line:
            return line
    return None


def countw(t: str, w: str) -> int:
    i: int = -1
    count: int = 0
    lent: int = len(t)
    lenw: int = len(w)
    while (i := t.find(w, i + 1)) != -1:
        if i + lenw >= lent or not t[i + lenw].isalpha():
            count += 1
    return count


def digits(t: str) -> list[str]:
    new_str: bool = True
    int_lst: list[str] = []
    for c in t:
        if c.isnumeric():
            if new_str:
                int_lst.append("")
            int_lst[-1] += c
            new_str = False
        else:
            new_str = True
    return int_lst


def column(table: str, k: int) -> list[str]:
    lst_str: list[str] = []
    for col in table.splitlines():
        lst_str.append(col.split(";")[k])
    return lst_str


def main():
    t1: str = """Quant'e' bella giovinezza
che ti fugge tuttavia!
Chi vuol esser lieto, sia:
del doman non c'e' certezza."""
    print(firstline(t1, "non"))
    t2: str = "le cose non sono solo cose, ma anche cosette"
    print(countw(t2, "cose"))
    t3: str = "via Po n.23, tel. 06 7867555 - cell. 345 675665676 (cc 34565)"
    print(digits(t3))
    t4 = """Milano;12;13
Roma;16;25
Napoli;15;27
Firenze;11;20"""
    print(column(t4, 1))


if __name__ == "__main__":
    main()
