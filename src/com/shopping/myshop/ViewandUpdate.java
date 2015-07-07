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
import android.widget.TabHost.TabSpec;

public class ViewandUpdate extends Activity implements OnClickListener{
	
	
	
	Button bshow,bupdate,bdel;
	TextView  nameshow,creditshow,nameupdate,creditupdate;
	EditText eid,ecreditsh,eidup,ecreditup,etdel;
	TabHost th;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewandupdate);
		th=(TabHost)findViewById(R.id.tabhost);
		bshow=(Button)findViewById(R.id.bSHOWCREDIT);
		bupdate=(Button)findViewById(R.id.bUPDATECREDIT);
		bdel=(Button)findViewById(R.id.bDELETE);
		bshow.setOnClickListener(this);
		bdel.setOnClickListener(this);
		bupdate.setOnClickListener(this);
		nameshow=(TextView)findViewById(R.id.tvshowname);
		nameupdate=(TextView)findViewById(R.id.tvupdatename);
		creditshow=(TextView)findViewById(R.id.tvshowcredit);
		creditupdate=(TextView)findViewById(R.id.tvupdatecredit);
		eid=(EditText)findViewById(R.id.etshowname);
		etdel=(EditText)findViewById(R.id.etdeleteid);
		ecreditsh=(EditText)findViewById(R.id.etshowcredit);
		eidup=(EditText)findViewById(R.id.etupdatename);
		ecreditup=(EditText)findViewById(R.id.etupdatecredit);
		th.setup();
		TabSpec specs=th.newTabSpec("Tag 1");
		specs.setContent(R.id.tab1);
		specs.setIndicator("View Credit");
		th.addTab(specs);
	     specs=th.newTabSpec("Tag 2");
		specs.setContent(R.id.tab2);
		specs.setIndicator("Update credit");
		th.addTab(specs);
		 specs=th.newTabSpec("Tag 3");
			specs.setContent(R.id.tab3);
			specs.setIndicator("Delete a record");
			th.addTab(specs);
		
		
		
								
				
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.bSHOWCREDIT:
			try
			{
			String id=eid.getText().toString();
			long l=Long.parseLong(id);
			Database k=new Database(this);
			k.open();
			String c=k.getCredit(l);
				
			k.close();
			 ecreditsh.setText(c);
			break;
			}
			
			catch(Exception e)
			
			{
			
				String error=e.toString();
				Dialog d= new Dialog(this);
				d.setTitle("Something went wrong");
				TextView tv=new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();
				
			}
		case R.id.bUPDATECREDIT:
			boolean didItwork=true;
			       try
			       {
			String credit=ecreditup.getText().toString();
			double m=Long.parseLong(credit);
			double cre;
			String row=eidup.getText().toString();
			Long lr=Long.parseLong(row);
			Database rd=new Database(this);
			rd.open();
			String c=rd.getCredit(lr);
			
			
			cre=m+(Double.parseDouble(c));
			
			String cre1=Double.toString(cre);
			rd.updateCredit(lr,cre1);
			rd.close();
			
			       }
			       
			   	catch(Exception e)
				
				{
				didItwork=false;
					String error=e.toString();
					Dialog d= new Dialog(this);
					d.setTitle("Something went wrong!");
					TextView tv=new TextView(this);
					tv.setText(error);
					d.setContentView(tv);
					d.show();
					
				}
			       finally
					{
						if(didItwork)
						{
							Dialog d= new Dialog(this);
							d.setTitle("  Success!");
							TextView tv=new TextView(this);
							tv.setText("Entry Updated Successfully");
							d.setContentView(tv);
							d.show();
							
						}
						
					}
			       break;
		case R.id.bDELETE:
			boolean did=true;
			try
			{String row2=etdel.getText().toString();
		Long lr=Long.parseLong(row2);
		Database rd2=new Database(this);
		rd2.open();
		rd2.deleteEntry(lr);
		rd2.close();
			}
			catch(Exception e)
			{
				did=false;
				String error=e.toString();
				Dialog d= new Dialog(this);
				d.setTitle("Something went wrong!");
				TextView tv=new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();
			} 
			finally
			{
				if(did)
				{
					Dialog d= new Dialog(this);
					d.setTitle("       Success!");
					TextView tv=new TextView(this);
					tv.setText("Entry deleted Successfully");
					d.setContentView(tv);
					d.show();
					
				}
				
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
	

