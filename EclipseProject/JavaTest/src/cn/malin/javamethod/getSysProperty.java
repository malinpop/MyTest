package cn.malin.javamethod;

public class getSysProperty {

	public static void main(String[] args) {
		System.setProperty(
				"webdriver.firefox.bin",
				"C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		//"webdriver.firefox.bin"
		System.out.println("��ǰ����Ŀ¼��"+System.getProperty("user.dir"));
		System.out.println("����ϵͳ���ƣ�" +System.getProperty("os.name"));
		System.out.println("����ϵͳ�汾��" +System.getProperty("os.version"));
		System.out.println("Java�汾��" +System.getProperty("java.version"));
		System.out.println("Firefoxλ�ã�" +System.getProperty("webdriver.firefox.bin"));
	}

}
