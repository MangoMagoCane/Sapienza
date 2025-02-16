import sys
from typing import TypeAlias
import lib.image as image

Color: TypeAlias = tuple[int, int, int]
Img: TypeAlias = list[list[Color]]


def size(ll: list[list]) -> tuple[int, int, int, int]:
    col_count: int = 0
    min_len: int = sys.maxsize
    max_len: int = 0
    elem_count: int = 0
    for l in ll:
        l_len = len(l)
        elem_count += l_len
        col_count += 1
        if l_len > max_len:
            max_len = l_len
        if l_len < min_len:
            min_len = l_len
    return (col_count, min_len, max_len, elem_count)


def draw_h_line(img: Img, x: int, y: int, w: int, c: Color) -> None:
    for i in range(x, w + x):
        if image.inside(img, i, y + 1):
            img[y][i] = c


def draw_v_line(img: Img, x: int, y: int, w: int, c: Color) -> None:
    for i in range(y, w + y + 1):
        if image.inside(img, x, i):
            img[i][x] = c


def draw_quad_out(img: Img, x1: int, y1: int, x2: int, y2: int, c: Color) -> None:
    x_dist: int = x2 - x1
    y_dist: int = y2 - y1
    draw_h_line(img, x1, y1, x_dist, c)
    draw_h_line(img, x1, y2, x_dist, c)
    draw_v_line(img, x1, y1, y_dist, c)
    draw_v_line(img, x2, y1, y_dist, c)


def draw_grid(img: Img, s: int, c: Color) -> None:
    ih: int = len(img)
    iw: int = len(img[0])
    for i in range(0, iw + 1, s):
        draw_v_line(img, i, 0, ih, c)
    for i in range(0, ih + 1, s):
        draw_h_line(img, 0, i, iw, c)


def main():
    print(size([[1, 2, 3], ["a", "b"], [1, 2, "A", 4, 5]]))
    img: Img = image.create(500, 150, (0, 255, 0))
    draw_h_line(img, 100, 50, 300, (255, 0, 0))
    draw_h_line(img, 50, 100, 700, (0, 0, 255))
    image.visd(img)
    img = image.create(500, 150, (0, 0, 0))
    draw_v_line(img, 100, 50, 300, (255, 0, 0))
    draw_v_line(img, 50, 100, 700, (0, 0, 255))
    image.visd(img)
    img = image.create(300, 150, (0, 0, 0))
    draw_quad_out(img, 50, 20, 100, 140, (255, 128, 0))
    image.visd(img)
    draw_quad_out(img, 120, -10, 180, 70, (255, 255, 255))
    image.visd(img)
    draw_quad_out(img, 140, 40, 320, 120, (80, 80, 255))
    image.visd(img)
    img = image.create(400, 200, (240, 240, 240))
    for k in range(6):
        s = int(8 * (1.5**k))
        c = 200 - 40 * k
        draw_grid(img, s, (c, c, c))
    image.visd(img)


if __name__ == "__main__":
    main()
