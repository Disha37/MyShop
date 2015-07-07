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

public class Updatequan extends Activity implements OnClickListener{

	Button itemup;
	
	EditText itemid,itemquan;
	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.updatequantity);
		itemup=(Button)findViewById(R.id.bUpdatequantity);
				
				itemid=(EditText)findViewById(R.id.etproducttochange);
				itemquan=(EditText)findViewById(R.id.etquantochange);
				
				itemup.setOnClickListener(this);
				
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId())
		{
		case R.id.bUpdatequantity: 
			boolean didItWork=true;
			try
			{
			String id=itemid.getText().toString();
			Long l=Long.parseLong(id);
		                        String quan=itemquan.getText().toString();
		                        
		                        Database n=new Database(this);
		                        n.open();
		                        n.updateQuantity(l, quan);
		                        n.close();
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
				tv.setText("Successfully updated quantity of item ");
				d.setContentView(tv);
				d.show();
				
						}
			break;
		
		}
	}

	}
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		finish();
	}

}
