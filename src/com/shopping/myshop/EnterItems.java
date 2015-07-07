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

public class EnterItems extends Activity implements OnClickListener{

	Button itemup;
	
	EditText itemnam,itemquan,itemprice;
	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.enteritems);
		itemup=(Button)findViewById(R.id.bUpdateStock);
				
				itemnam=(EditText)findViewById(R.id.etItemname);
				itemquan=(EditText)findViewById(R.id.etItemquan);
				itemprice=(EditText)findViewById(R.id.etitemprice);
				itemup.setOnClickListener(this);
				
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId())
		{
		case R.id.bUpdateStock: boolean didItWork=true;
			try
			{
			String name=itemnam.getText().toString();
		                        String quan=itemquan.getText().toString();
		                        String price=itemprice.getText().toString();
		                        Database n=new Database(this);
		                        n.open();
		                        n.createEntry2(name,quan,price);
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
				tv.setText("Successfully added item to stock");
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
