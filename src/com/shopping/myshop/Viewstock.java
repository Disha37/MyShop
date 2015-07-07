package com.shopping.myshop;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Viewstock extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewstock);
		TextView tv=(TextView)findViewById(R.id.tvStock);
		Database get=new Database(this);
		get.open();
		
		String info=get.getData2();
		get.close();
		tv.setText(info);
	}
	
	
	
	
	

}
