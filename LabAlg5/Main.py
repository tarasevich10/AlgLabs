"""In this method we will find minimal quantity of pieces we could have."""


def find_divide_count(somestr):
    begin_of_next_str = 1
    result = 0

    while begin_of_next_str <= somestr.__len__():
        if somestr[:begin_of_next_str] in powered_numbers:
            if begin_of_next_str is somestr.__len__():
                return 1
            right_part_divide_counter = find_divide_count(somestr[begin_of_next_str:])
            if right_part_divide_counter is not 0:
                if result is 0:
                    result = right_part_divide_counter
                elif result > right_part_divide_counter + 1:
                    result = right_part_divide_counter
                result += 1
        begin_of_next_str += 1
    return result


"""This method will return an array of all possible binary values of our @param number till binary number is <=100"""

powered_numbers = []


def to_binary_array(n, str):
    binary_value = ''
    power = 0

    while binary_value.__len__() <= str.__len__():
        number_value = pow(n, power)
        binary_value = format(number_value, 'b')
        powered_numbers.append(binary_value)
        power += 1


"""Initializing main method"""

binary_string = '110011011'
number = 5
to_binary_array(number, binary_string)
print(find_divide_count(binary_string))
