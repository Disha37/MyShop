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

public class Payandupdate extends Activity implements OnClickListener {
   double topay=0.0;
Long id;
EditText money;

Button email,pay,exit,up;
String newcred;
TextView amt,bcre,acre,disp;


@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	
setContentView(R.layout.payandupdate);
	email=(Button)findViewById(R.id.bnotifyemail);
	up=(Button)findViewById(R.id.brechargeifless);
	money=(EditText)findViewById(R.id.etrechargeifless);
	pay=(Button)findViewById(R.id.bpayfromcredit);
	exit=(Button)findViewById(R.id.bcreditexit);
	amt=(TextView)findViewById(R.id.tvdisplayamount);
	disp=(TextView)findViewById(R.id.tv22);
	bcre=(TextView)findViewById(R.id.tvbeforepaycredit);
	acre=(TextView)findViewById(R.id.tvafterpaycredit);
	exit.setOnClickListener(this);
	email.setOnClickListener(this);
	up.setOnClickListener(this);
	pay.setOnClickListener(this);
	Bundle d=getIntent().getExtras();
	topay=d.getDouble("send");	
	id=d.getLong("id");
	amt.setText("The amount to be paid is (Rs)"+ topay);
}






@Override
public void onClick(View v) {
	// TODO Auto-generated method stub
	switch(v.getId())
	{
	case R.id.bnotifyemail:boolean diditWork=true;
		try
		{
		       Database k2=new Database(this);
		       k2.open();
		     String email= k2.getEmail(id);
		     k2.close();
		        String emailaddress[]={ email };
		        
		        Intent emailIntent=new Intent(android.content.Intent.ACTION_SEND);


            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,emailaddress);
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT," CREDIT DETAILS");
		
		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,"Credit left in your account  after last transaction is Rs "+ newcred);
		startActivity(emailIntent);

		      
		}
		catch(Exception e)
		{
			diditWork=false;
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
			if(diditWork)
			{
			Toast t=Toast.makeText(Payandupdate.this, "SENDING MAIL", Toast.LENGTH_LONG);
			t.show();
			}
			
		}
		break;
	case R.id.bpayfromcredit:try
	{
	
	Database k=new Database(this);
	k.open();
	String c=k.getCredit(id);
	
    bcre.setText("The old credit was "+ c);

	 double change =Double.parseDouble(c);
	if(change-topay>=0)
	{



	 double changed=change-topay;
	String cha=Double.toString(changed);
		k.updateCredit(id,cha);
	newcred=k.getCredit(id);
	
	acre.setText("Credit after payment is Rs "+ newcred);
	email.setVisibility(View.VISIBLE);
	exit.setVisibility(View.VISIBLE);

	}
	else
	{
	Toast t=Toast.makeText(Payandupdate.this, "NOT ENOUGH CREDIT", Toast.LENGTH_LONG);
	t.show();
	disp.setVisibility(View.VISIBLE);
	up.setVisibility(View.VISIBLE);
	money.setVisibility(View.VISIBLE);
	
	}
	
	k.close();
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
	case R.id.bcreditexit:Intent ba=new Intent(Payandupdate.this,ExitApp.class);
	                 startActivity(ba);
	                 break;
	                 
	case R.id.brechargeifless:
		boolean didItwork=true;
	       try
	       {
	String credit=money.getText().toString();
	double m=Long.parseLong(credit);
	double cre;
	
	Database rd=new Database(this);
	rd.open();
	String c=rd.getCredit(id);
	
	
	cre=m+(Double.parseDouble(c));
	
	String cre1=Double.toString(cre);
	rd.updateCredit(id,cre1);
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
	}
	
	}
protected void onPause() {
	// TODO Auto-generated method stub
	super.onPause();
	
	finish();
}

}






