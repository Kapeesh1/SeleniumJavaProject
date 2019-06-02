package log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {

	private static Logger logger= LogManager.getLogger(Log4jDemo.class);

	public static void main(String[] args) {
	
		System.out.println("\n Hello World....\n ");

		logger.info("This is info message");
		logger.fatal("This is fatal Message");
		logger.warn("This is warning message");
		logger.error("This is error message");
		
		System.out.println("\n Test is completed");
	}

}
