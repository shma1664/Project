'''
Created on 2015年10月15日

@author: admin

if：不为0 并且 不为null，则为Ture，为0或者为null，则为False

python 不支持 switch

'''

flag = False;

name = 'shma';
if(name == 'shma') :
    flag = True;
    print("欢迎您，老板");
else :
    print(name);

if(flag) :
    print("欢迎您指导工作");
    

# 多值判断

num = 6;

if(num == 1) :
    print("boss");
elif(num == 2) :
    print("user");
elif(num == 3) :
    print("worker");
elif(num <= 0) :
    print("error");
else :
    print("guest");
    
# 多条件判断

num = 10;

if(num > 0 and num <= 10) :
    print("hello");
else :
    print("undefined");
    
if((num > 0 and num < 10) or (num > 100 and num <120)) :
    print("ok");
else :
    print("error");

#简单语句数组
if num >= 10 : print("success");
print("Good bye!");