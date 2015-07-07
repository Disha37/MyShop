package com.shopping.myshop;

import android.app.Activity;
import android.os.Bundle;

public class ExitApp extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exitapp);
	}
	
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		finish();
	}

}
