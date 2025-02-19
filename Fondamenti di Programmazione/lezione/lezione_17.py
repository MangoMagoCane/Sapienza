import os
import lib.rtrace as rtrace


# ! unfinishd
def countf(path: str) -> int:
    retval: int = 0
    if os.path.isfile(path):
        return 1
    for name in os.listdir(path):
        if name.startswith("."):
            continue
        pathname = os.path.join(path, name)
        if os.path.isdir(pathname):
            retval += countf(pathname)
        else:
            retval += 1

    return retval


def maxlev(path: str) -> int:
    if os.path.isfile(path):
        return 1
    if not os.path.isdir(path):
        return 0
    depth: int = 0
    for name in os.listdir(path):
        if name.startswith("."):
            continue
        pathname: str = os.path.join(path, name)
        res: int = maxlev(pathname)
        if res > depth:
            depth = res
    return depth + 1


def permute_d(seq: str) -> list[str]:
    if not seq:
        return []
    if len(seq) == 1:
        return [seq]
    perm: list[str] = []
    for c in {el[0] for el in seq}:
        i: int = seq.find(c)
        X: str = seq[i]
        for s in permute_d(seq[:i] + seq[i + 1 :]):
            perm.append(X + s)
    return perm


def change(r: int, coins: list[int]) -> int:
    count: int = 0
    if r < 0:
        return 0
    if r == 0:
        return 1
    count += change(r - coins[0], coins)
    for coin in coins[1:]:
        count += change(r - coin, coins[1:])
    return count


def main():
    print(countf("Informatica"))
    print(countf("Informatica/Software"))
    print(countf("Informatica/Hardware/Architetture/cache.txt"))
    print(maxlev("Informatica"))
    print(maxlev("Informatica/Teoria"))
    print(maxlev("Informatica/Hardware"))
    print(maxlev("Informatica/Software/SistemiOperativi/Linux.txt"))
    print(permute_d("ala"))
    print(change(8, [1, 5]))
    print(change(15, [1, 5, 10]))
    print(change(100, [1, 5, 10, 20, 50]))


if __name__ == "__main__":
    main()
