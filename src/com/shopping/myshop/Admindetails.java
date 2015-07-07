package com.shopping.myshop;


import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TabHost.TabSpec;

public class Admindetails extends Activity implements OnClickListener{
	
	
	
	Button bcreate,bchange;

	EditText ecreate,eold,enew;
	TabHost th;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admindetails);
		th=(TabHost)findViewById(R.id.tabhost);
		bcreate=(Button)findViewById(R.id.bcreateadmin);
		bchange=(Button)findViewById(R.id.bchangepassword);
		
		bcreate.setOnClickListener(this);
		bchange.setOnClickListener(this);
		
		
		ecreate=(EditText)findViewById(R.id.etcreateadmin);
		eold=(EditText)findViewById(R.id.etold);
		enew=(EditText)findViewById(R.id.etnew);
		
		th.setup();
		TabSpec specs=th.newTabSpec("Tag 1");
		specs.setContent(R.id.tab1);
		specs.setIndicator("Create Admin");
		th.addTab(specs);
	     specs=th.newTabSpec("Tag 2");
		specs.setContent(R.id.tab2);
		specs.setIndicator("Update Admin Password");
		th.addTab(specs);
		 
		
		
								
				
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.bcreateadmin:boolean didItWork=true;
			try
			{
			String id=ecreate.getText().toString();
			
			Database k=new Database(this);
			k.open();
			k.createadmin(id);
				
			k.close();
			 
			break;
			}
			
			catch(Exception e)
			
			{didItWork=false;
			
				String error=e.toString();
				Dialog d= new Dialog(this);
				d.setTitle("Something went wrong");
				TextView tv=new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();
				
			}
			finally
			{

				if(didItWork)
				{
					Dialog d= new Dialog(this);
					d.setTitle("  Success!");
					TextView tv=new TextView(this);
					tv.setText("Admin created Successfully");
					d.setContentView(tv);
					d.show();
					
				}
			}
		case R.id.bchangepassword:
			
			       try
			       {
			String old=eold.getText().toString();
			
			String newpass =enew.getText().toString();
			;
			Database rd=new Database(this);
			rd.open();
			String c=rd.getpass(1);
			
			if(c.contains(old))			
			{
				
						rd.updatepass(1,newpass);
						Toast t=Toast.makeText(Admindetails.this, "Changed Password"
		    					, Toast.LENGTH_LONG);
		    		           	t.show();
			
			
			       }
			else
			{
				Toast t=Toast.makeText(Admindetails.this, "Incorrect  Password"
    					, Toast.LENGTH_LONG);
    		           	t.show();
			}
			rd.close();
			       }
			   	catch(Exception e)
				
				{
			
					String error=e.toString();
					Dialog d= new Dialog(this);
					d.setTitle("Something went wrong!");
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
	
