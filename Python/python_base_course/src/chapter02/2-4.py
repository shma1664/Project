'''
Created on 2015年11月12日

@author: admin

检查用户名和PIN码是否一致

'''
from pip._vendor.distlib.compat import raw_input

database = [['Lucy', 789122],
            ['LiLei', 892121],
            ['Lily', 222199],
            ['HanMeimei', 228912]];

userName = raw_input("Please input username : ");
pin = raw_input("Please input PIN码 : ");

if [userName, int(pin)] in database :
    print("Access granted");
else :
    print("Error");
