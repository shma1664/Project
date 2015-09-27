#创建一个列表
movies = ["射雕英雄传", "天龙八部", "倚天屠龙记"];

#打印列表
print(movies);

#按照下标打印列表某一项值
print(movies[0]);
print(movies[1]);
print(movies[2]);

#打印列表长度
print(len(movies));

#添加一个元素
movies.append("天下第一");
print(movies);

#移除一个元素 先进后出，后进先出
print(movies.pop());
print(movies);

#添加一个集合
movies.extend(["鹿鼎记", "小李飞刀", "书剑恩仇录"]);
print(movies);

#删除指定的元素
print(movies.remove("鹿鼎记"));
print(movies);

#指定位置插入数据
movies.insert(0, "还珠格格");
movies.insert(2, "宫心锁玉");
print(movies);

#for循环遍历
for movie in movies :
    print("For循环遍历：" + movie);

#while循环遍历
count = 0;
while count < len(movies) :
    print("while遍历：" + movies[count]);
    count = count + 1;

#列表保存不同类型的数据
users = ["马韶华", 18,
             "齐娇娇", 19,
             "孙威", 20,
             "樊慧", 20
            ];
for user in users :
    print(user);

#列表越界,抛出异常：IndexError: list index out of range
#print(users[8]);

#python不区分双引号、单引号
movies.append('"雪山飞狐"');
movies.append("\"完美世界\"");
movies.extend(["'碧血剑'", '\'绝世唐门\'']);
print(movies);

#python区分大小写

#列表多层嵌套，类似于json
teacher = [1001, "孙威",
               [
                   [100101, "马韶华",
                        ["语文", 89, "数学", 97]
                   ],
                   [100102, "齐娇娇",
                        ["语文", 76, "数学", 88, "英语", 99]
                   ]
               ]
           ];
print(teacher);
for tt in teacher :
    print(tt);

#isinstance：查询类型
print(isinstance(teacher, list));
print(isinstance(len(teacher), list));
print(isinstance(len(teacher), int));

#显示bif列表
dir(__builtins__)

#使用isinstance循环遍历
for tt in teacher :
    if isinstance(tt, list) :
        for t in tt :
            if isinstance(t, list) :
                for tmp in t :
                    if isinstance(tmp, list) :
                        for tm in tmp :
                            print(tm);
                    else :
                        print(tmp);
            else :
                print(t);
    else :
        print(tt)

#创建函数
def show_lol(the_list) :
    for item in the_list :
        if isinstance(item, list) :
            show_lol(item);
        else :
            print(item);

show_lol(teacher);
