
def visita_iterativa(arr_tree):
    length = len(arr_tree)
    i = 0
    stack = [[i, False]]

    while len(stack) > 0:
        elem_i = stack[-1][0]
        was_visited = stack[-1][1]
        child_i = (elem_i + 1) * 2 - 1

        if not was_visited:
            if arr_tree[elem_i] is not None:
                print(elem_i, end=" ")
                print(arr_tree[elem_i])

            stack[-1][1] = True
            if child_i < length:
                stack.append([child_i, False])
        else:
            stack.pop()
            if child_i < length:
                stack.append([child_i + 1, False])


tree = ["a", "f", "b", "z", "g", None, "k"]
visita_iterativa(tree)
