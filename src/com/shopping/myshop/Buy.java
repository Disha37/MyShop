package com.shopping.myshop;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Buy extends Activity implements OnClickListener{

	Button addb,remb,payb,det;
	EditText pid;
	TextView quan,price,name;
	int c=0;
	double pricefinal=0.0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.buy);
		addb=(Button)findViewById(R.id.baddbasket);
		remb=(Button)findViewById(R.id.bremovebasket);
		payb=(Button)findViewById(R.id.bfinalpay);
		det=(Button)findViewById(R.id.bVIEWPRODUCT);
		pid=(EditText)findViewById(R.id.etproductid);
	
		quan=(TextView)findViewById(R.id.tvQuanpurchased);
		price=(TextView)findViewById(R.id.tvproductprice);
		name=(TextView)findViewById(R.id.tvproductname);
		payb.setOnClickListener(this);
		addb.setOnClickListener(this);
		det.setOnClickListener(this);
		remb.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		
		{
		case R.id.baddbasket: 
			try
			{
				String check2=pid.getText().toString();
                            long l2=Long.parseLong(check2);
		                    	 Database  k2=new Database(this);
		                      	 k2.open();
			                 String o2=k2.getQuantity(l2);     
			                 String n2=k2.getPrice(l2);
			                 long qua=Long.parseLong(o2);
			                 double p=Double.parseDouble(n2);
			                 if(qua>0)
			                 {
			                	 qua--;
			                	 pricefinal+=p;
			                	 c++;
			                	 String upquan=Long.toString(qua);
			                	 k2.updateQuantity(l2,upquan);
			                    quan.setText("The Quantity purchased is "+ c + "units");
			                 }
			                 else
			                 {
			                	 Toast t=Toast.makeText(Buy.this,"OUT OF STOCK", Toast.LENGTH_LONG);
			                	 t.show();
			                 }
			                 k2.close();
			}
			
			catch(Exception e)
			
			{
				
				String error=e.toString();
				Dialog d= new Dialog(this);
				d.setTitle("oops");
				TextView tv=new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();
				
			}
			break;
			
		case R.id.bremovebasket:        try
		{String check3=pid.getText().toString();
                                long l3=Long.parseLong(check3);
                         	 Database  k3=new Database(this);
                                             	 k3.open();
                                      String o3=k3.getQuantity(l3);    
                                      String n3=k3.getPrice(l3);
         			                
         			                 double p2=Double.parseDouble(n3);
                                        long qua2=Long.parseLong(o3);
                                        qua2++;
                                        c--;
                                        quan.setText("The Quantity purchased is "+ c + "units");
                                        pricefinal-=p2;
       			                	 String upquan2=Long.toString(qua2);
       			                	 k3.updateQuantity(l3,upquan2);
       			                	 k3.close();
		}
		
		catch(Exception e)
		
		{
			
			String error=e.toString();
			Dialog d= new Dialog(this);
			d.setTitle("oops");
			TextView tv=new TextView(this);
			tv.setText(error);
			d.setContentView(tv);
			d.show();
			
		}
                                        
			break;
		case R.id.bfinalpay:Bundle b=new Bundle();
		                        b.putDouble("amount", pricefinal);
		                        Intent i =new Intent(Buy.this,Ask.class);
		                        i.putExtras(b);
		                        startActivity(i);
		                        
			break;
		case R.id.bVIEWPRODUCT:
			try
			{String check=pid.getText().toString();
                      long l=Long.parseLong(check);
                       Database  k=new Database(this);
                       k.open();
                         String m =k.getName(l);
                         String n=k.getPrice(l);
                        
                         name.setText("Product name is " + m);
                         price.setText("Product price is Rs " +  n);
                        c=0;
                           k.close();
			}
			
			catch(Exception e)
			
			{
				
				String error=e.toString();
				Dialog d= new Dialog(this);
				d.setTitle("oops");
				TextView tv=new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();
				
			}
			
			break;
			
		
		}
		
		
		
		
		
	}
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	
		finish();
	}


}
