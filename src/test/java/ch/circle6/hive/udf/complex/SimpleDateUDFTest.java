package ch.circle6.hive.udf.complex;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDF.DeferredJavaObject;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDF.DeferredObject;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.JavaStringObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.circle6.hive.udf.complex.SimpleDateUDF;

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
        ObjectInspector stringOI = PrimitiveObjectInspectorFactory.javaStringObjectInspector;
        ObjectInspector listOI = ObjectInspectorFactory.getStandardListObjectInspector(stringOI);
        JavaStringObjectInspector resultInspector = (JavaStringObjectInspector) udf.initialize(new ObjectInspector[]{listOI, stringOI});
        
        // create the actual UDF arguments
        List<String> list = new ArrayList<String>();
        list.add("EEE MMM dd HH:mm:ss yyyy");
        list.add("Locale.ENGLISH");
        
        // the value
        Object result = udf.evaluate(new DeferredObject[]{new DeferredJavaObject(list), new DeferredJavaObject("Tue Jul 29 10:02:08 2014")});
        logger.debug(resultInspector.getPrimitiveJavaObject(result));
        Assert.assertEquals("2014-07-29 10:02:08", resultInspector.getPrimitiveJavaObject(result));
        
        udf.close();
    }
}
