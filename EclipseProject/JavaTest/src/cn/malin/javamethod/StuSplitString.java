package cn.malin.javamethod;

public class StuSplitString {
	public static void main(String[] args){
		String str = "aaa&bbb&ccc";
		
		String x = (str.split("&"))[0];
		System.out.println(x);
	}
}
