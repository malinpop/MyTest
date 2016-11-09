package cn.malin.javamethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class StuPropertiesFile {

	public static void main(String[] args) throws IOException {
		Properties props = new Properties();
		FileInputStream  fileInptStrm = new FileInputStream("Test.properties");
		props.load(fileInptStrm);
		
		System.out.println(props.getProperty("username"));
		System.out.println(props.getProperty("password"));
	}

}
