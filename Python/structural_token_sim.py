import javalang
import sys

def tokenize(method):
    tokens  = list(javalang.tokenizer.tokenize(method))
    # for token in tokens:
    #   print(token)
    tree = javalang.parse.parse(tokens)
    print(tree.types)
    

tokenize(sys.argv[1])