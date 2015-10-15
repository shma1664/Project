'''
Created on 2015年10月15日

@author: admin

and    布尔"与" - 如果x为False，x and y返回False，否则它返回y的计算值。    (a and b) 返回 true。
or     布尔"或" - 如果x是True，它返回True，否则它返回y的计算值。    (a or b) 返回 true。
not    布尔"非" - 如果x为True，返回False。如果x为False，它返回True。    not(a and b) 返回 false。

'''

a = 10;
b = 20;

if (a and b) :
    print(a, " and ", b, " != 0");
else :
    print(a, " and ", b, " == 0");

c = 0;

if (c or a) :
    print(a, " or ", c, " != 0");
else :
    print(a, " or ", c, " == 0");

if not(c or a) :
    print(a, " or ", c, " != 0");
else :
    print(a, " or ", c, " == 0");
