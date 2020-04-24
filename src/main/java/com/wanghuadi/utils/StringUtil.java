package com.wanghuadi.utils;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

/**
 * 字符串工具类
 * @author wanghd
 */
public class StringUtil {
	
	/**
	 * 判断源字符串是否有值，空引号也算没值和空格也算没值
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		return str == null || str.trim().length()<1;
	}
	
	/**
	 * 判断是否为手机号码
	 * @param str
	 * @return
	 */
	public static boolean isPhone(String str){
		String regex = "1[3|4|6|8|9]\\d{9}";
		return str.matches(regex);
	}
	
	/**
	 * 判断是否为电子邮箱        数字字母下划线    @  数字字母下划线  .com   .cn ....
	 * @param str
	 * @return
	 */
	public static boolean isEmail(String str){
		String regex = "\\w+@\\w+(.com|.cn|.com.cn)";
		return str.matches(regex );
	}
	
	/**
	 * 判断是否全部为字母
	 * @return
	 */
	public static boolean isString(String str){
		String reg = "[a-zA-Z]+";
		return str.matches(reg);
	}
	
	/**
	 * 判断是否是整数
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str){
		String regex = "\\d+";
		return str.matches(regex );
	}
	
	/**
	 * 判断是否是小数
	 * @param str
	 * @return
	 */
	public static boolean isFloat(String str){
		String regex = "\\d+\\.?\\d+";
		return str.matches(regex );
	}
	
	/**
	 * 获取n位随机英文字符串
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length){
		//A 65  Z 90
		//a 97	z 122
		Random a = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int num = a.nextInt(122)+1;
			if(num>=65 && num<=90 || num>=97 && num<=122){
				String str = (char)num+"";
				sb.append(str);
			}else{
				i--;
			}
		}
		return sb.toString();
	}
	
	/**
	 * 判断List、Set之类的对象是否有值，对象为空算没值
	 * @param src
	 * @return
	 */
	public static boolean isEmpty(Collection<?> src){
		return src.isEmpty();
	}
	
	/**
	 * 获取n位随机英文字符串
	 * @param length
	 * @return
	 */
	public static String getString(int length){
		Random random = new Random();
		StringBuffer result = new StringBuffer();
		char[] words = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		for(int i = 0 ; i < length ; i++){
			int index = random.nextInt(26);
			String word = words[index] + "";
			int bigorsmall = random.nextInt();
			if(bigorsmall % 2 == 0){
				word = word.toLowerCase();
			}
			result.append(word);
		}
		
		return result.toString();
	}
	
	/**
	 * 获取n位随机英文和数字字符串
	 * @param length
	 * @return
	 */
	public static String getStringAndNumber(int length){
		Random random = new Random();
		StringBuffer result = new StringBuffer();
		char[] words = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','1','2','3','4','5','6','7','8','9','0'};
		for(int i = 0 ; i < length ; i++){
			int index = random.nextInt(36);
			String word = words[index] + "";
			if(!StringUtil.isNumber(word)){
				int bigorsmall = random.nextInt();
				if(bigorsmall % 2 == 0){
					word = word.toLowerCase();
				}
			}
			result.append(word);
		}
		
		return result.toString();
	}
	
	/**
	 * 获取n个随机中文字符串
	 * @return
	 */
	public static String getAChinese(int length) {
        StringBuilder str = new StringBuilder();
        int hs = 0 ;
        int ls = 0; 
        Random random = new Random();
        for(int i = 0 ; i < length ; i++){
	        hs = (176 + Math.abs(random.nextInt(39))); 
	        ls = (161 + Math.abs(random.nextInt(93)));
	        byte[] b = new byte[2];
	        b[0] = (new Integer(hs).byteValue());
	        b[1] = (new Integer(ls).byteValue());
	        try {
	          str.append(new String(b, "GBk")); 
	        } catch (UnsupportedEncodingException e) {
	          e.printStackTrace();
	        }
        }
        return str.toString();
  }
}
