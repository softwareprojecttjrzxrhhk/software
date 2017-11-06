package webCl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegRes {
	public static String baiduTieba(String html) {
		StringBuffer buffer = new StringBuffer();  
        
        Pattern p = Pattern.compile("<cc>            <div id=.*?>(.*?)</div><br>            </cc>.*<span class=\"tail-info\">(.*?)¥</span><span class=\"tail-info\">(.*?)</span>");
        Matcher m = p.matcher(html);
        while (m.find()) {
        	//System.out.println("ss");
        	buffer.append(m.group(1) + "" + m.group(2) + "" + m.group(3) + "\r\n");
        }
        
        return buffer.toString();
	} 
	
}
