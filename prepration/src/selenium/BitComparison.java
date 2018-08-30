package selenium;

import org.im4java.core.CompareCmd;
import org.im4java.process.StandardStream;
import org.im4java.core.IMOperation;

public class BitComparison {
	
	public static boolean compareImages (String exp, String cur) {
		  // This instance wraps the compare command
		  CompareCmd compare = new CompareCmd();
		 
//		  // For metric-output
//		  compare.setErrorConsumer(StandardStream.STDERR);
//		  IMOperation cmpOp = new IMOperation();
//		  // Set the compare metric
//		  cmpOp.metric("mae");
		  IMOperation cmpOp = new IMOperation();
		  // Add the expected image
		  cmpOp.addImage(exp);
		 
		  // Add the current image
		  cmpOp.addImage(cur);
		 
		  // This stores the difference
		  //cmpOp.addImage(diff);
		 
		  try {
		    // Do the compare
		    compare.run(cmpOp);
		    return true;
		  }
		  catch (Exception ex) {
			  System.out.println("In catch block");
			  ex.printStackTrace();
		    return false;
		  }
		}

	public static void main(String[] args) {
		boolean res = compareImages("./test1.jpg", 
				"./test1.jpg"
				);
		System.out.println("Result is: "+res);
	}

}
