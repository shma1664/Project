'''
Created on 2015年10月14日

@author: admin

=     简单的赋值运算符    c = a + b 将 a + b 的运算结果赋值为 c
+=    加法赋值运算符    c += a 等效于 c = c + a
-=    减法赋值运算符    c -= a 等效于 c = c - a
*=    乘法赋值运算符    c *= a 等效于 c = c * a
/=    除法赋值运算符    c /= a 等效于 c = c / a
%=    取模赋值运算符    c %= a 等效于 c = c % a
**=   幂赋值运算符    c **= a 等效于 c = c ** a
//=   取整除赋值运算符    c //= a 等效于 c = c // a

'''

a = 10;
b = 20;

c = a + b;
print("c = ", c);

d = 1;
d += a;
print("d = ", d);

e = 30;
e -= a;
print("e = ", e);

f = 2;
f *= a;
print("f = ", f);

g = 50;
g /= a;
print("g = ", g);

h = 61;
h %= a;
print("h = ", h);

i = 2;
i **=a;
print("i = ", i);

j = 61;
j //=a;
print("j = ", j);




