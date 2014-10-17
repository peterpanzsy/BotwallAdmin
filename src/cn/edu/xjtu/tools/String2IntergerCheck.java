package cn.edu.xjtu.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class String2IntergerCheck {
	public static boolean check(String sessionNum){
		Pattern pattern = Pattern.compile("^\\d+$");
		Matcher matcher = pattern.matcher(sessionNum);
		if(matcher.matches()==false)
        {
             return false;
        }
        else
        {
             return true;
        }
	}
}
