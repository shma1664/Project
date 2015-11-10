package com.shma.common.lang;

import org.apache.commons.lang3.StringUtils;

public class TestStringUtils {

	public static void main(String[] args) {
		
		String str1 = "" ;
        String str2 = "" ;
        String str3 = "\t" ;
        String str4 = null ;
        String str5 = "123" ;
        String str6 = "ABCDEFG" ;
        String str7 = "Itfeels good to use JakartaCommons.\r\n";
        
        System.out.println(StringUtils.isBlank(str1)); //true
        System.out.println(StringUtils.isBlank(str2)); //true
        System.out.println(StringUtils.isBlank(str3)); //true
        System.out.println(StringUtils.isBlank(str4)); //true
        System.out.println(StringUtils.isBlank(str5)); //false
        System.out.println(StringUtils.isBlank(str6)); //false
        System.out.println(StringUtils.isBlank(str7)); //false
        
        
        System.out.println(StringUtils.isNumeric(str5));
        System.out.println(StringUtils.isNumeric(str6));
        
        System.out.println(StringUtils.reverse(str6));
        System.out.println(StringUtils.reverseDelimited(StringUtils.chomp(str7), ','));

        str5 = StringUtils.join(str5, "1", "2");
        System.out.println(str5);
        
	}
}
