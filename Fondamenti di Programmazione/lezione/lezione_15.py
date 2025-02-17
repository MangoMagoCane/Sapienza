def somma_seconda_colonna(matrice: list[list[int]]) -> int:
    somma: int = 0
    for row in matrice:
        _, x, *_ = row
        somma += x
    return somma


def somma_seconda_colonna_map(matrice: list[list[int]]) -> int:
    return sum(map(lambda r: r[1], matrice))


def terne(*lista: int) -> list[list[int]]:
    lst: list[int] = list(lista)
    ret_lst: list[list[int]] = []
    while True:  # try catch for fun
        try:
            a, b, c, *lst = lst
            ret_lst.append([a, b, c])
        except:
            return ret_lst


def somma_colonna_K(matrice: list[list[int]], K: int) -> int:
    return sum(map(lambda r: r[K], matrice))


def main():
    M: list[list[int]] = [
        [1, 2, 3, 4],
        [5, 6, 7, 8],
        [9, 10, 11, 12],
    ]
    print(somma_seconda_colonna(M))
    print(somma_seconda_colonna_map(M))
    print(terne(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11))
    print(somma_colonna_K(M, 3))


if __name__ == "__main__":
    main()
