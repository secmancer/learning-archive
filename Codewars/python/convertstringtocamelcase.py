def to_camel_case(text):
    if (len(text) == 0):
        return ''
    answer = text.replace("_", " ").replace("-", " ")
    answer = answer.split()
    return answer[0] + ''.join(i.capitalize() for i in answer[1::])