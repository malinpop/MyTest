package cn.malin.javamethod;

import static org.junit.Assert.*;

import org.junit.Test;
import org.testng.log4testng.Logger;

public class StuLog4jInJUnit {

	Logger lg = Logger.getLogger(StuLog4jInJUnit.class);
	@Test
	public void test() {
		lg.info("≤‚ ‘”√¿˝±ª÷¥––");
		assertEquals("aaa", "aaa");
	}

}
