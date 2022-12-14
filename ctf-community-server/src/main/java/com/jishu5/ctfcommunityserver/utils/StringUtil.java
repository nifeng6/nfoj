package com.jishu5.ctfcommunityserver.utils;

import java.util.*;

/**
 * 字符串工具类
 * @author 
 *
 */
public class StringUtil {

	/**
	 * 判断是否是空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str==null||"".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 判断是否不是空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		if((str!=null)&&!"".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 格式化模糊查询
	 * @param str
	 * @return
	 */
	public static String formatLike(String str){
		if(isNotEmpty(str)){
			return "%"+str+"%";
		}else{
			return null;
		}
	}
	
	/**
	 * 过滤掉集合里的空格
	 * @param list
	 * @return
	 */
	public static List<String> filterWhite(List<String> list){
		List<String> resultList=new ArrayList<String>();
		for(String l:list){
			if(isNotEmpty(l)){
				resultList.add(l);
			}
		}
		return resultList;
	}
	
	/**
	 * 去除html标签
	 */
	public static String stripHtml(String content) { 
	    // <p>段落替换为换行 
	    content = content.replaceAll("<p .*?>", "\r\n"); 
	    // <br><br/>替换为换行 
	    content = content.replaceAll("<br\\s*/?>", "\r\n"); 
	    // 去掉其它的<>之间的东西 
	    content = content.replaceAll("\\<.*?>", ""); 
	    // 去掉空格 
	    content = content.replaceAll(" ", ""); 
	    return content;   
	}
	
	/**
	 * 生成六位随机数
	 * @return
	 */
	public static String getRandomNum(int length){
		Random random = new Random();
		String result="";
		for (int i=0;i<length;i++)
		{
			result+=random.nextInt(10);
		}
		return result;
	}

	/**
	 * 生成由[A-Z,0-9]生成的随机字符串
	 * @param length  欲生成的字符串长度
	 * @return
	 */
	public static String getRandomString(int length){
		Random random = new Random();

		StringBuffer sb = new StringBuffer();

		for(int i = 0; i < length; ++i){
			int number = random.nextInt(2);
			long result = 0;

			switch(number){
				case 0:
					result = Math.round(Math.random() * 25 + 65);
					sb.append(String.valueOf((char)result));
					break;
				case 1:

					sb.append(String.valueOf(new Random().nextInt(10)));
					break;
			}
		}
		return sb.toString();
	}

	/**
	 * 生成由随机UUID
	 * @return
	 */
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		// 去掉"-"符号
		String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
		return temp;
	}
	//获得指定数量的UUID
	public static String[] getUUID(int number) {
		if (number < 1) {
			return null;
		}
		String[] ss = new String[number];
		for (int i = 0; i < number; i++) {
			ss[i] = getUUID();
		}
		return ss;
	}


	public static <K extends Comparable<? super K>, V > Map<K, V> sortByKey(Map<K, V> map) {
		Map<K, V> result = new LinkedHashMap<>();

		map.entrySet().stream()
				.sorted(Map.Entry.<K, V>comparingByKey()).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
		return result;
	}



}
