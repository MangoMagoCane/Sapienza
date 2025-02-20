def media(vals: list[int]) -> float:
    sum: int = 0
    for val in vals:
        sum += val
    return sum / len(vals)


def space(s: str, k: int) -> str:
    new_s: str = ""
    for i in range(len(s) - 1):
        new_s += s[i] + " " * k
    return new_s + s[-1]


def crossing_over(m: list[int], f: list[int]) -> list[int]:
    new_lst: list[int] = []
    for i in range(len(m)):
        new_lst.append(m[i])
        new_lst.append(f[i])
    return new_lst


def main():
    print(media([1, 3, 5]))
    print(space("ciao ciao", 1))
    print(crossing_over([1, 3, 5], [2, 4, 6]))


if __name__ == "__main__":
    main()
