package cn.malin.javamethod;

public class Lab_ExceptionAndCatch {

	public static void main(String[] args) {
		int x = 10;
		try{
		  System.out.println(x/0);
		} catch (Exception e){
			System.out.println("adfsdf");
		}
		
		// 只要捕获了上面的异常，这句输出就可以执行。否则程序运行将被终止
		System.out.println("aaaaaaaaaaaaaaaaaaa");
	}

}
