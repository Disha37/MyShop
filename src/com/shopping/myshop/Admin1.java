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

public class Admin1 extends Activity implements OnClickListener {

	Button admin;
	ToggleButton passTog;
			EditText eadmin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admin);
		admin=(Button)findViewById(R.id.badmin);
		eadmin=(EditText)findViewById(R.id.etadmin);
		passTog=(ToggleButton)findViewById(R.id.tbon);
		passTog.setOnClickListener(this);
		admin.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.badmin:
			try
			{
			
			String check=eadmin.getText().toString();
			Database rd=new Database(this);
			rd.open();
			String c=rd.getpass(1);
			            if(check.contentEquals(c))
			            {
			            	Toast t=Toast.makeText(Admin1.this, "Successful Login"
			    					, Toast.LENGTH_LONG);
			    		           	t.show();
			    		           	Intent a=new Intent(Admin1.this,RegisterCustomers.class);
		                              startActivity(a);
			    			
			            }
			            	
			            else
			            {
			            	Toast t=Toast.makeText(Admin1.this, "Incorrect password!!"
			    					, Toast.LENGTH_LONG);
			    		           	t.show();
			      
			            }
			            rd.close();
			}
			
			catch(Exception e)
			
			{
			
				Dialog d= new Dialog(this);
				d.setTitle("oops");
				TextView tv=new TextView(this);
				tv.setText("NO ADMIN YET!!");
				d.setContentView(tv);
				d.show();
				
			}
			
			break;
		case R.id.tbon:
			if(passTog.isChecked())
			{
	      eadmin.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
			}
			
		else
		{
			
			eadmin.setInputType(InputType.TYPE_CLASS_TEXT);
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
