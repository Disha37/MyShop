package com.shopping.myshop;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Viewcust extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewcustomer);
		TextView tv=(TextView)findViewById(R.id.tvCustomer);
		Database get=new Database(this);
		get.open();
		
		String info=get.getData();
		get.close();
		tv.setText(info);
	}
	
	
	


	

}
