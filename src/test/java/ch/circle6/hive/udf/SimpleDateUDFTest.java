package ch.circle6.hive.udf;

import java.io.IOException;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit test for simple App.
 */
public class SimpleDateUDFTest extends TestCase {
	
	private static Logger logger = LoggerFactory.getLogger(SimpleDateUDF.class); 
    
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SimpleDateUDFTest( String testName ) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( SimpleDateUDFTest.class );
    }

    public void testSimpleDate() throws HiveException, IOException {
        // set up the models we need
        SimpleDateUDF udf = new SimpleDateUDF();
        
        String inputPattern = "EEE MMM dd HH:mm:ss yyyy";
        String datum ="Tue Jul 29 10:02:08 2014";
        
        // Without OutputPattern
        String result = udf.evaluate(datum, inputPattern);
        logger.debug(result);
        Assert.assertEquals("2014-07-29 10:02:08", result);
        
        // With OutputPattern
        result = udf.evaluate(datum, inputPattern, "HH:mm:ss yyyy-MM-dd");
        logger.debug(result);
        Assert.assertEquals("10:02:08 2014-07-29", result);
        
    }
    
}
