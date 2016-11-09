package cn.malin.javamethod;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class IOToFile {

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream ps = new PrintStream(".//log.txt");
		System.setOut(ps);
		System.out.println("aaaaa");

	}

}
