import random


def triangolo(N: int) -> list[list[int]]:
    return [[X * Y for X in range(1, Y + 1)] for Y in range(1, N + 1)]


def potenze_crescenti(lista: list[int]) -> list[int]:
    return [el**i for i, el in enumerate(lista)]


def non_divisibili(N: int, divisori: list[int]) -> list[int]:
    return [
        Z
        for Z in range(1, N + 1)
        if Z not in {X for X in range(1, N + 1) for Y in divisori if X % Y == 0}
    ]


def doppio_dado() -> int:
    count: int = 0
    while True:
        X: int = random.randint(1, 6)
        Y: int = random.randint(1, 6)
        print(X, Y)
        count += 1
        if X == 6 and Y == 6:
            return count


def main():
    print(triangolo(4))
    print(potenze_crescenti([2, 3, 4, 5, 6]))
    print(non_divisibili(10, [2, 3]))
    random.seed(0)
    print(doppio_dado())


if __name__ == "__main__":
    main()
