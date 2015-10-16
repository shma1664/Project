'''
Created on 2015年10月15日

@author: admin
'''
from pip._vendor.distlib.compat import raw_input

num = 10;

print("start while");
while(num > 0) :
    print("This is count : ", num);
    num -= 1;
print("end while");

#使用break，continue

i = -1;
while(i < 10) :
    i += 1;
    if(i % 2 == 0) :
        continue;
    print(i);
print("end....");

j = 0;
while 1 :
    j += 2;
    if(j > 10) : break;
    print(j);
print("end....");

#无限循环
while 1==1 :
    num = raw_input("Enter number : ");
    print(str.isdigit(num));
    if(int(num) == -1) : break;
    print("Your enter num : " + num);
print("good bye");

'''
while ... else ...
如果while循环正常执行结束，即没有通过break退出，则会执行else语句
'''

'''
1  less than 5
3  less than 5
5  less than 5
6  not less than 5
'''
k = 0;
while (k <= 5) :
    k += 1;
    if(k % 2 == 0) : continue;
    print(k , " less than 5");
else :
    print(k , " not less than 5");

'''
1  less than 5
2  less than 5
'''
l = 0;
while(l <= 5) :
    l += 1;
    if(l == 3) : break;
    print(l , " less than 5");
else :
    print(l , " not less than 5");

m = 1;
while(m) : print("Given flag is really true!"); # die loop
print("good bye");