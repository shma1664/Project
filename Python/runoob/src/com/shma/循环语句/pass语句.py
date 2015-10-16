'''
Created on 2015年10月16日

@author: admin

Python pass是空语句，是为了保持程序结构的完整性。
passass 不做任何事情，一般用做占位语句。

'''

for letter in 'python' :
    if letter == 'h' :
        pass;
        print("这是pass块");
    else :
        print(letter);
