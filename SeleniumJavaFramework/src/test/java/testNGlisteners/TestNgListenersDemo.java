package testNGlisteners;

import junit.framework.Assert;

import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(testNGlisteners.TestNGListeners.class)
public class TestNgListenersDemo {

	@Test
	public void test1(){
		System.out.println("I am inside test 1");
	}
	@Test
	public void test2(){
		System.out.println("I am inside test 2");
		Assert.assertTrue(false);    // For failed test
	}
	@Test
	public void test3(){
		System.out.println("I am inside test 2");
		throw new SkipException("This testNG method is skipped");  //For skip the test
	}	
}
