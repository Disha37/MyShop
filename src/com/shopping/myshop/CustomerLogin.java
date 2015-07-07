
package com.shopping.myshop;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class CustomerLogin extends Activity implements OnClickListener {

	Button custlogin;
	ToggleButton passTog;
	EditText id,pass;
	double payment=0.0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.customerlogin);
		custlogin=(Button)findViewById(R.id.bCustLogin);
		id=(EditText)findViewById(R.id.etCustid);
		pass=(EditText)findViewById(R.id.etCustPass);
		passTog=(ToggleButton)findViewById(R.id.tbCustomer);
		passTog.setOnClickListener(this);
		custlogin.setOnClickListener(this);
		Bundle d=getIntent().getExtras();
		payment=d.getDouble("send");
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.bCustLogin:
			
			try
			{
			String check=id.getText().toString();
			Long l=Long.parseLong(check);
			String passw=pass.getText().toString();
			Database d=new Database(this);
			d.open();
			String checkpass=d.getPassword(l);
			            if(checkpass.contains(passw))
			            {
			            	Toast t=Toast.makeText(CustomerLogin.this, "Successful Login"
			    					, Toast.LENGTH_LONG);
			    		           	t.show();
			    		           	Bundle m=new Bundle();
			    		           	m.putDouble("send", payment);
			    		           	m.putLong("id", l);
			    		           	Intent a=new Intent(CustomerLogin.this,Payandupdate.class);
			    		           	a.putExtras(m);
		                              startActivity(a);
			    			
			            }
			            	
			            else
			            {
			            	Toast t=Toast.makeText(CustomerLogin.this, "Incorrect password!!"
			    					, Toast.LENGTH_LONG);
			    		           	t.show();
			    		           	
			            }
			            d.close();
			}
			
			catch(Exception e)
			
			{
				
				Dialog d= new Dialog(this);
				d.setTitle("oops");
				TextView tv=new TextView(this);
				tv.setText("INCORRECT USER ID ");
				d.setContentView(tv);
				d.show();
				
			}
			break;
		case R.id.tbCustomer:
			if(passTog.isChecked())
			{
	      pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
			}
			
		else
		{
			
			pass.setInputType(InputType.TYPE_CLASS_TEXT);
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
