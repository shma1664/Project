'''
Created on 2015年11月11日

@author: admin

在屏幕中打印包含输入字符的盒子

'''
from pip._vendor.distlib.compat import raw_input

#以正确的宽高在居中的盒子中打印一段句子

screen_width = 80;

sentence = raw_input("Please input sentence : ");
sen_width = len(sentence);

box_width = sen_width + 6;
left_margin = (screen_width - box_width) // 2;

print(' ' * left_margin + '+' + '-' * (box_width - 2) + '+');
print(' ' * left_margin + '|' + ' ' * (box_width - 2) + '|');
print(' ' * left_margin + '|' + ' ' * 2 + sentence + ' ' * 2 + '|');
print(' ' * left_margin + '|' + ' ' * (box_width - 2) + '|');
print(' ' * left_margin + '+' + '-' * (box_width - 2) + '+');
