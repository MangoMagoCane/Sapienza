import os
import random
import lib.image as im
from lib.types import *
from typing import Callable


def rotL90(img):
    ih: int = len(img)
    iw: int = len(img[0])
    ret_img = im.create(ih, iw, im.black)
    for i in range(ih):
        for j in range(iw):
            ret_img[j][i] = img[i][j]
    return ret_img


def red(img, s: int):
    new_h: int = len(img) // s
    new_w: int = len(img[0]) // s
    ret_img = im.create(new_w, new_h, im.black)
    mos_avg = im.mosaic_average(img, s)
    for i in range(new_h):
        for j in range(new_w):
            ret_img[i][j] = mos_avg[i * s][j * s]
    return ret_img


def mult(img, s: int):
    ih: int = len(img)
    iw: int = len(img[0])
    new_h: int = ih // s
    new_w: int = iw // s
    ret_img = im.create(iw, ih, im.black)
    red_img = red(img, s)
    for i in range(s):
        for j in range(s):
            im.copy(ret_img, red_img, j * new_w, i * new_h, 0, 0, new_w, new_h)
    return ret_img


def gray(img):
    ih: int = len(img)
    iw: int = len(img[0])
    ret_img = im.create(iw, ih, im.black)
    for i in range(ih):
        for j in range(iw):
            c = img[i][j]
            channel = (c[0] + c[1] + c[2]) // 3
            ret_img[i][j] = (channel, channel, channel)
    return ret_img


def patchwork(img, s: int):
    ih: int = len(img)
    iw: int = len(img[0])
    div_img = im.create(s, s, im.black)
    ret_img = im.create(iw, ih, im.black)
    i = 0
    funcs: list[Callable[[]]] = [
        lambda: div_img,
        lambda: im.invert(div_img),
        lambda: im.contrast(div_img, 0.5),
        lambda: im.contrast(div_img, 2.0),
        lambda: gray(div_img),
    ]
    funcs_end = len(funcs) - 1
    for i in range(ih // s):
        for j in range(iw // s):
            im.copy(div_img, img, 0, 0, j * s, i * s, s, s)
            tmp_img = funcs[random.randint(0, funcs_end)]()
            im.copy(ret_img, tmp_img, j * s, i * s, 0, 0, s, s)
    return ret_img


def edge(img, t: float, bg: Color | None):
    ih: int = len(img)
    iw: int = len(img[0])
    ret_img = im.create(iw, ih, im.black)
    for ii in range(1, ih - 1):
        for jj in range(1, iw - 1):
            orig_c = img[ii][jj]
            border: bool = False
            for i in range(ii - 1, ii + 2):
                if border:
                    break
                for j in range(jj - 1, jj + 2):
                    if not i == ii or j == jj:
                        curr_c = img[i][j]
                        s: int = 0
                        if not sum(orig_c) > sum(curr_c):
                            break
                        for i in range(3):
                            s += abs(orig_c[i] - curr_c[i])
                        if s / (765) >= t:
                            border = True
                            break
            ret_img[ii][jj] = im.black if border else bg if bg != None else img[ii][jj]
    return ret_img


def main():
    os.chdir("files_3")
    flower1 = im.load("img_in_01.png")
    flower2 = im.load("img_in_02.png")
    im.visd(rotL90(flower1))
    im.visd(red(flower1, 2))
    im.visd(red(flower1, 4))
    im.visd(mult(flower1, 2))
    im.visd(mult(flower1, 4))
    im.visd(gray(flower1))
    im.visd(patchwork(flower1, 64))
    im.visd(patchwork(flower1, 16))
    im.visd(edge(flower1, 0.1, None))
    im.visd(edge(flower1, 0.05, None))
    im.visd(edge(flower2, 0.2, (240, 240, 240)))
    im.visd(edge(flower2, 0.15, (240, 240, 240)))


if __name__ == "__main__":
    main()
