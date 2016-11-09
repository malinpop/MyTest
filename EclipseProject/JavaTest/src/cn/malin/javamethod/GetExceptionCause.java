package cn.malin.javamethod;

public class GetExceptionCause {
	
	public static void throwTheException() throws Exception {
		throw new Exception("Exception...");
	}
	
	public static int throwMathematicException() throws Exception {
		int x = 9;
		int y = 0;
		// 此处会产生异常
		return x/y;
	}
	
	public static void main(String[] args) throws Throwable {
		System.out.println("A-------------------------A");
		try {
			throwTheException();
		} catch(Throwable e) {
			//System.err.println("aaa:  "+ e + "|  Cause = " + e.getCause());
			System.out.println("aaa:  "+ e + "|  Cause = " + e.getCause());
		}
		
		System.out.println("B-------------------------B");
		try{
			throwMathematicException();
		} catch (Exception u){
			System.out.println("bbb:  "+ u + "|  Cause = " + u.getCause());
		}
	}
}
