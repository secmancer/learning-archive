def filter_list(l):
    answer = []
    for i in l:
        if isinstance(i, int) and i >= 0:
            answer.append(i);
    return answer;
