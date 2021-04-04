import sys
from collections import Counter


def run(names: list) -> dict:
    dict = {}
    for name in names:
        keys = ''.join(sorted(Counter(name).keys()))
        for key_item in keys:
            if key_item in dict.keys():
                dict[key_item].append(name)
            else:
                dict[key_item] = []
                dict[key_item].append(name)

    for (key, value) in dict.items():
        print(key,':', value)


if __name__ == '__main__':
    list = ['anurag', 'rahul', 'saurabh']
    sys.exit(run(list))
