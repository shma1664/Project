"""
    递归遍历嵌套多层list
    thelist:集合列表
    indent：输入是否缩进
    level：默认缩进级别
"""
def show_list(thelist, indent = False, level = 0) :
    for item in thelist :
        if isinstance(item, list) :
            show_list(item, indent, level+1);
        else :
            if indent :
                #遍历level
                for index in range(level) :
                    print("\t", end='')
            print(item);

teacher = [1001, "孙威",
               [
                   "三年二班",
                   [100101, "马韶华",
                        ["语文", 89, "数学", 97]
                   ],
                   [100102, "齐娇娇",
                        ["语文", 76, "数学", 88, "英语", 99]
                   ]
               ]
           ];
show_list(teacher, True, 3);