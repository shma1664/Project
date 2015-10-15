'''
Created on 2015年10月13日
@author: shma

'''

'''
python有五个标准数据类型：

            数字：Numbers
           字符串：String
            列表：List
            元组：Tuple
            字典：Dictionary

'''

'''
数字类型Numbers：用于存储数值，是不可改变的类型，如果改变数值，则会重新创建新的对象
python支持四种数值类型：
    带符号的整型：int
   长整型：long
    浮点数：float
   复数：complex
'''
#当指定一个变量赋值时，即创建了一个数字类型
var1 = 10;
var2 = 13.5;
print(var1);
print(var2);

del var1, var2; # 删除对象
print(var1); # NameError: name 'var1' is not defined
