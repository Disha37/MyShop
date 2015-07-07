package com.shopping.myshop;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Displaying extends Activity implements OnClickListener {
   
	
	Button reg,shop,bdet,item,babt,bad;
	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.displaying);
		reg=(Button)findViewById(R.id.bRegister);
		shop=(Button)findViewById(R.id.bShop);
		bdet=(Button)findViewById(R.id.bcustdetails);
		item=(Button)findViewById(R.id.bitems);
		babt=(Button)findViewById(R.id.bAbout);
		bad=(Button)findViewById(R.id.badmin);
		bad.setOnClickListener(this);
		reg.setOnClickListener(this);
		babt.setOnClickListener(this);
		shop.setOnClickListener(this);
		bdet.setOnClickListener(this);
		item.setOnClickListener(this);
	
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		
		{
		case R.id.bRegister:Intent a=new Intent(Displaying.this,Admin1.class);
                              startActivity(a);
			break;
		case R.id.bShop:
			Intent c=new Intent(Displaying.this,Buy.class);
                            startActivity(c);
                            break;
		case R.id.bcustdetails:Intent a2=new Intent(Displaying.this,Admin2.class);
                               startActivity(a2);

			break;
		case R.id.bitems:Intent d1=new Intent(Displaying.this,Admin3.class);
        startActivity(d1);
			
			break;
		case R.id.bAbout:
			
			
			Dialog d=new Dialog(this);
			d.setTitle("         About the App");
			TextView tv= new TextView(this);
		 tv.setText(" MyShop is for use by shops that have almost the same set of customers.Credit based shopping minimizes the efforts of the customer as well as the Shopkeeper.");
		d.setContentView(tv);
		d.show();
			
	
			
		 break;
		case R.id.badmin:Intent a4=new Intent(Displaying.this,Admindetails.class);
        startActivity(a4);
			break;
		
			
		}
		
	}

}