package com.shopping.myshop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Enterorupdate extends Activity implements OnClickListener {

	
	
	Button enter,change,viewstock,viewcust;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.enterorupdate);
		enter=(Button)findViewById(R.id.bAdditem);
		change=(Button)findViewById(R.id.bUpdatequantity);
		viewstock=(Button)findViewById(R.id.bviewstockdetails);
		viewcust=(Button)findViewById(R.id.bviewcustdetails);
	
		change.setOnClickListener(this);
		enter.setOnClickListener(this);
		viewstock.setOnClickListener(this);
		viewcust.setOnClickListener(this);
	
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId())
		{
		case R.id.bviewstockdetails:Intent d1=new Intent(Enterorupdate.this,Viewstock.class);
                                   startActivity(d1);

			break;
		case R.id.bviewcustdetails:Intent d2=new Intent(Enterorupdate.this,Viewcust.class);
                            startActivity(d2);
			break;
		case R.id.bAdditem:Intent d3=new Intent(Enterorupdate.this,EnterItems.class);
                             startActivity(d3);
			break;
		case R.id.bUpdatequantity:Intent d4=new Intent(Enterorupdate.this,Updatequan.class);
                          startActivity(d4);
			break;
		
		}
		
	}
	
	}


