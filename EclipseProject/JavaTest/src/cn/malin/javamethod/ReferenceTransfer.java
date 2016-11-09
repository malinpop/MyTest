package cn.malin.javamethod;

public class ReferenceTransfer {
	public String test(String s){
		s= s + "aaaa";
		return s;
	}
	public static void main(String[] args) {
		String x = "KKK";
		ReferenceTransfer tr = new ReferenceTransfer();
		System.out.println(tr.test(x));
		System.out.println(x);
	}
}
