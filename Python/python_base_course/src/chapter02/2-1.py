'''
Created on 2015年11月11日

根据给定的年月日，以数字形式答应出日期

@author: admin
'''
from pip._vendor.distlib.compat import raw_input

months = [{'month' : 'January', 'day' : 31},
          {'month' : 'February', 'day' : 28},
          {'month' : 'March', 'day' : 31},
          {'month' : 'April', 'day' : 30},
          {'month' : 'May', 'day' : 31},
          {'month' : 'June', 'day' : 30},
          {'month' : 'July', 'day' : 31},
          {'month' : 'August', 'day' : 31},
          {'month' : 'September', 'day' : 30},
          {'month' : 'October', 'day' : 31},
          {'month' : 'November', 'day' : 30},
          {'month' : 'December', 'day' : 31}];

dayEndings = ['st', 'nd', 'rd'] + 17 * ['th'] \
             + ['st', 'nd', 'rd'] + 7 * ['th'] \
             + ['st']; 

year = raw_input('Year: ');
month = raw_input('Month(1-12): ');
day = raw_input("day(1-31): ");

year_num = int(year);
month_num = int(month);
day_num = int(day);
#参数验证
if year_num <= 0 :
    print("year error");
    exit();
    
if month_num <= 0 or month_num > 12 :
    print("month error, 1-12");
    exit();
    
if day_num <= 0 or day_num >= 31 :
    print("day error, 1-31");
    exit();

if year_num % 4 == 0 :
    months[1].update({'day':29});
    
if months[month_num - 1].get("day") < day_num :
    print("day error");
    exit();

month_name = months[month_num - 1].get("month");
day_name = day + dayEndings[day_num - 1];

print(month_name + ' ' + day_name + ". " + year);