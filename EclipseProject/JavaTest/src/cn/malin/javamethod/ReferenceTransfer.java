package cn.malin.javamethod;

public class ReferenceTransfer {
	public String test(String s){
		s= s + "aaaa";
		return s;
	}
	
	public char[] test2(char[] t){
		t[0]='A';
		return t;
	}
	
	public static void main(String[] args) {
		
		ReferenceTransfer tr = new ReferenceTransfer();
		
		// ֵ���ݷ�ʽ
		String x = "KKK";
		System.out.println(tr.test(x));
		System.out.println(x);
		
		// ֵ���ݷ�ʽ
		String y = new String("TTTTTTTTTTT");
		System.out.println(tr.test(y));
		System.out.println(y);
		
		// ����������ô���
		char[] z = "aaa".toCharArray();
		System.out.println(tr.test2(z));
		System.out.println(z);
		
	}
}
