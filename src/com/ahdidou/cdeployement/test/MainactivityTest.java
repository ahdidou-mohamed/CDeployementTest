package com.ahdidou.cdeployement.test;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.TextView;

import com.ahdidou.cdeployement.MainActivity;
import com.ahdidou.cdeployement.R;

public class MainactivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

	private static final String NUMBER_24 = "2 4 ENTER ";
	private static final String NUMBER_74 = "7 4 ENTER ";
	private static final String ADD_RESULT = "98";
	private static final String NUMBER_5_DOT_5 = "25";
	private static final String ADD_DECIMAL_RESULT = "98";
	private static final String MULTIPLY_RESULT = "1776";
	private static final String SUBSTRUCT_RESULT = "-50";
	private static final String TAG = "MainactivityTest";

	TextView result;
	private MainActivity activity;

	public MainactivityTest() {

		super(MainActivity.class);

	}

	public  MainactivityTest(Class<MainActivity> name) {

		super(name);

	}

	protected void setUp() throws Exception {

		super.setUp();

		setActivityInitialTouchMode(false);
		
	    activity = getActivity();
		
		result = (TextView)activity.findViewById(R.id.result);

	}

	public void testAddValues() {

		sendKeys(NUMBER_24);  
		// now on value2 entry  
		sendKeys(NUMBER_74);  
		// now on Add button  
		sendKeys("ENTER");  
		// get result  
		String mathResult = result.getText().toString();  
		
		assertTrue("Add result should be 98", mathResult.equals(ADD_RESULT)); 

	}

	public void testAddDecimalValues() {  
		
		sendKeys(NUMBER_24 +NUMBER_74+ "DPAD_LEFT ENTER"); 

		String mathResult = result.getText().toString(); 
		
		if (result == null) {
			
			Log.d(TAG, "Result ADD DECIMALs "+mathResult);
			
		}
		
		assertTrue("Add result should be " + ADD_DECIMAL_RESULT + " but was " + mathResult, mathResult.equals(ADD_DECIMAL_RESULT));  
	}  

	public void testMultiplyValues() {  

		sendKeys(NUMBER_24+NUMBER_74+ "DPAD_RIGHT ENTER"); 

		String mathResult = result.getText().toString();  

		assertTrue("Multiply result should be " + MULTIPLY_RESULT + " but was "+ mathResult, mathResult.equals(MULTIPLY_RESULT));  
	}  
	
	public void testSubstructValues() {  

		sendKeys(NUMBER_24+NUMBER_74+ "DPAD_RIGHT ENTER "+"DPAD_RIGHT ENTER"); 

		String mathResult = result.getText().toString();  

		assertTrue("Multiply result should be " + SUBSTRUCT_RESULT + " but was "+ mathResult, mathResult.equals(SUBSTRUCT_RESULT));  
	}  


}
