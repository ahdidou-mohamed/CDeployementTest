package com.ahdidou.cdeployement.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.widget.Button;

import com.ahdidou.cdeployement.MainActivity;
import com.ahdidou.cdeployement.MainAsynkActivity;
import com.ahdidou.cdeployement.MainAsynkActivity.IJobListener;
import com.ahdidou.cdeployement.R;

public class MainAsykActivityTest extends ActivityUnitTestCase<MainAsynkActivity> {

	private MainAsynkActivity activity;

	public MainAsykActivityTest() {
		
		super(MainAsynkActivity.class);
		
	}

	protected void setUp() throws Exception {
		super.setUp();
		Intent intent = new Intent(getInstrumentation().getTargetContext(),
				MainActivity.class);
		startActivity(intent, null, null);
		activity = getActivity();
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testSomeAsynTask () throws Throwable {
		// create CountDownLatch for which the test can wait.
		final CountDownLatch latch = new CountDownLatch(1);

		activity.setListener(new IJobListener() {

			@Override
			public void executionDone() {
				latch.countDown();
			}
		});

		// Execute the async task on the UI thread! THIS IS KEY!
		runTestOnUiThread(new Runnable() {

			@Override
			public void run() {
				Button button = (Button) activity.findViewById(R.id.button1);
				button.performClick();
			}
		});       


		boolean await = latch.await(30, TimeUnit.SECONDS);

		assertTrue(await);
	}

} 