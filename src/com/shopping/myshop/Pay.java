package com.shopping.myshop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Pay extends Activity implements OnClickListener
{

	
	double finalpay;
	
	TextView t;
	Button bgoback,bexit;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pay);
		initialize();
		Bundle d=getIntent().getExtras();
		finalpay=d.getDouble("send");
		t.setText("Amount to be paid is Rs "+finalpay);
	}

	private void initialize() {
		// TODO Auto-generated method stub
		t=(TextView)findViewById(R.id.tVpay);
		bgoback=(Button)findViewById(R.id.bmainmenu);
		 bexit=(Button)findViewById(R.id.bexit);
		 bgoback.setOnClickListener(this);
		 bexit.setOnClickListener(this);
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.bmainmenu:Intent menustart=new Intent(Pay.this,Displaying.class);
		                    startActivity(menustart);
			break;
		case R.id.bexit:Intent exit=new Intent(Pay.this,ExitApp.class);
                        startActivity(exit);
		break;
		}
		
	}
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		finish();
	}

}
