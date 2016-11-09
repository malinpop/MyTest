package cn.malin.javamethod;

public class getSysProperty {

	public static void main(String[] args) {
		System.setProperty(
				"webdriver.firefox.bin",
				"C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		//"webdriver.firefox.bin"
		System.out.println("当前工作目录："+System.getProperty("user.dir"));
		System.out.println("操作系统名称：" +System.getProperty("os.name"));
		System.out.println("操作系统版本：" +System.getProperty("os.version"));
		System.out.println("Java版本：" +System.getProperty("java.version"));
		System.out.println("Firefox位置：" +System.getProperty("webdriver.firefox.bin"));
	}

}
