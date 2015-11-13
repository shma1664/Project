'''
Created on 2015年11月11日
输入url，返回域名
@author: admin
'''

import re;

from pip._vendor.distlib.compat import raw_input

url = raw_input("Please input url : ");

pattern = re.compile(r'http://www\..*\.com');
match = pattern.match(url)
if match :
    print(url[11:-4]);
else :
    print("url format error");