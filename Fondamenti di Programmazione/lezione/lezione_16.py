import math


# ! unfinished
class CatetoError(Exception):
    pass


def ipotenusa(x, y):
    if not isinstance(x, (int, float)):
        raise CatetoError("il cateto x non è un numero")
    if not isinstance(y, (int, float)):
        raise CatetoError("il cateto y non è un numero")
    return math.sqrt(x * x + y * y)


def ipotenusa_err(x, y):
    return math.sqrt(x * x + y * y)


def main(): ...


if __name__ == "__main__":
    main()
