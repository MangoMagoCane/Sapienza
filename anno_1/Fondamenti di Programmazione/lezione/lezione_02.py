def scontato(importo: int, sconto: int) -> int:
    return int(importo * (1 - sconto / 100))


def secondi(hh: int, mm: int, ss: int) -> int:
    return int((hh * 60 + mm) * 60 + ss)


def invest(C: int, i: int, n: int) -> int:
    return int(C * (1 + i / 100) ** n)


def main():
    print(scontato(1000, 20))
    print(secondi(2, 1, 11))
    print(invest(1000, 10, 2))


if __name__ == "__main__":
    main()
