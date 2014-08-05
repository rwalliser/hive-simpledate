package ch.circle6.hive.udf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.hadoop.hive.ql.exec.UDF;

public final class SimpleDateUDF extends UDF {
	
	private String outputPattern = "yyyy-MM-dd HH:mm:ss";
	private Locale locale = Locale.ENGLISH;
	
	public String evaluate(final String datum, final String inputPattern) {	
		return this.parseDate(datum, inputPattern, outputPattern);
	}

	public String evaluate(final String datum, final String inputPattern, final String outputPattern) {
		return this.parseDate(datum, inputPattern, outputPattern);
	}
		
	private String parseDate(final String datum, final String inputPattern, final String outputPattern){
		String result;
		Date date;
		try {
			date = new SimpleDateFormat(inputPattern, locale).parse(datum);
			result = new SimpleDateFormat(outputPattern).format(date).toString();
		} catch (ParseException e) {
			result = null;
		}
		return result;		
	}
	
	
	
	

}
