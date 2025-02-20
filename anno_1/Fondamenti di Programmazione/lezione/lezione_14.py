from typing import Generator


def ordina_palazzi(lista: list) -> list:
    return sorted(lista, key=lambda el: (el[2], -el[0]), reverse=True)


def palazzo_pui_costoso(lista: list[tuple]) -> tuple:
    def cost(el):
        x_pos, (r, g, b), h = el
        return ((h * (r + g + b) / 3), x_pos)

    return sorted(lista, key=cost)[-1]


def palazzo_coperto(lista: list[tuple]) -> bool:
    # not efficient by any means but I did because I could
    return any(
        [
            any([P2[2] >= P1[2] and abs(P2[0] - P1[0]) < 100 for P2 in lista[i:]])
            for i, P1 in enumerate(lista[:-1])
        ]
    )


def palazzi_scoperti(lista: list[tuple]) -> list[tuple]:
    return [
        P1
        for i, P1 in enumerate(lista)
        if all([abs(P2[0] - P1[0]) >= 100 for P2 in lista[i + 1 :]])
    ]


def quadrati_cubi(L: list[int]) -> Generator[int, None, None]:
    for x in L:
        yield x**2
        yield x**3


def quadrati_cubi_lstcmpr(L: list[int]) -> Generator[int, None, None]:
    return (x**p for x in L for p in [2, 3])


def main():
    lista = [
        (216, (54, 234, 22), 106),
        (740, (94, 236, 163), 71),
        (21, (49, 140, 100), 717),
        (137, (204, 5, 140), 717),
        (922, (15, 244, 140), 569),
        (52, (2, 98, 163), 514),
        (961, (138, 58, 166), 605),
        (396, (116, 149, 25), 448),
        (586, (129, 196, 183), 467),
        (347, (218, 229, 143), 253),
    ]
    print(ordina_palazzi(lista))
    print(palazzo_pui_costoso(lista))
    print(palazzo_coperto(lista))
    print(palazzi_scoperti(lista))
    int_lst: list[int] = [1, 2, 3, 4, 5]
    print(list(quadrati_cubi(int_lst)))
    print(list(quadrati_cubi_lstcmpr(int_lst)))


if __name__ == "__main__":
    main()
