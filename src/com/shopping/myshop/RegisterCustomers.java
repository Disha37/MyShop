package com.shopping.myshop;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterCustomers extends Activity implements OnClickListener {
   
	EditText ename,eemail,epass,ephone,eaddress,ecredit;
	
	Button breg;
	long c;
	
			
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		ename=(EditText)findViewById(R.id.etsName);
		ecredit=(EditText)findViewById(R.id.etsCredit);
		eemail=(EditText)findViewById(R.id.etsEmail);
		epass=(EditText)findViewById(R.id.etsPass);
		ephone=(EditText)findViewById(R.id.etsPhone);
		eaddress=(EditText)findViewById(R.id.etsAddress);
		
	     breg=(Button)findViewById(R.id.bsRegister);
		breg.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId())
		{
		case R.id.bsRegister:
			boolean didItWork=true;
			try
			{
			String name=ename.getText().toString();
			String email=eemail.getText().toString();
			String pass=epass.getText().toString();
			String phone=ephone.getText().toString();
			String address =eaddress.getText().toString();
			String credit=ecredit.getText().toString();
			Database k=new Database(RegisterCustomers.this);
			k.open();
			k.createEntry(name,email,pass,phone,address,credit);
		
			k.close();
			
			}
			
		catch(Exception e)
		
		{
			didItWork=false;
			String error=e.toString();
			Dialog d= new Dialog(this);
			d.setTitle("oops");
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
				d.setTitle("SUCCESS");
				TextView tv=new TextView(this);
				tv.setText("COLLECT YOUR USER ID FROM THE ADMIN");
				d.setContentView(tv);
				d.show();
				
						}
			}
			
			
			
			
			break;
		}
		
		
		
	}
	


}
