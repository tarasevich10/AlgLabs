def alg(list):
    left = 0
    right = 1
    list_len = list.__len__()

    # realize sort to have list sorted
    for n in range(1, list_len):
        index = n - 1

        while index > -1 and list[index] > list[index + 1]:
            list[index], list[index + 1] = list[index + 1], list[index]
            index -= 1

    i = 0  # number of first element
    while i < list_len - 1:
        j = i + 1  # number of second element
        while j < list_len:
            if list[i][right] > list[j][right]:
                list.pop(j)
                # when we delete the j-th element we decrement the size of our list
                list_len -= 1
            else:
                if list[i][right] < list[j][left]:
                    j += 1
                    continue
                else:
                    #  we merge left element of first item with the right element of second item
                    merged_element = (list[i][left], list[j][right])
                    list[i] = merged_element
                    list.pop(j)
                    list_len -= 1
        i += 1
    return list


LIST = [(1, 3), (7, 9), (2,6), (12, 16)]

print(alg(LIST))
