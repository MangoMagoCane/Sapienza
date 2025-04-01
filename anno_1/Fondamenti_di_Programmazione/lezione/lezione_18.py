# ! unfinished


def revescia(lista: list):
    if lista == []:
        return []
    else:
        el = [lista.pop(0)]
        return revescia(lista) + el


def main():
    lst: list = [1, 2, 3, 4, 5]
    print(revescia(lst))


if __name__ == "__main__":
    main()
