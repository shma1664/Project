'''
Created on 2015年10月14日
@author: admin


==    等于 -     比较对象是否相等    (a == b) 返回 False。
!=    不等于 -    比较两个对象是否不相等    (a != b) 返回 true.
<>    不等于 -    比较两个对象是否不相等    (a <> b) 返回 true。这个运算符类似 != 。
>     大于 -     返回x是否大于y    (a > b) 返回 False。
<     小于 -     返回x是否小于y。所有比较运算符返回1表示真，返回0表示假。这分别与特殊的变量True和False等价。注意，这些变量名的大写。    (a < b) 返回 true。
>=    大于等于 -  返回x是否大于等于y。    (a >= b) 返回 False。
<=    小于等于 -  返回x是否小于等于y。    (a <= b) 返回 true。

'''

a = 9;
b = 20;
c = 31;
d = 2;
e = 3;

print("Line 1 - Value of c is " , (a + b + c));
print("Line 2 - Value of c is " , (c - b));
print("Line 3 - Value of c is " , (a * b));
print("Line 4 - Value of c is " , (c / a));
print("Line 5 - Value of c is " , (c % a));
print("Line 6 - Value of c is " , (c // a)); # 取商
print("Line 7 - Value of c is " , (e ** d)); # e的d次方