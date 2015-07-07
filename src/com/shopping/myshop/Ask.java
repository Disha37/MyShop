package com.shopping.myshop;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Ask extends Activity implements OnClickListener{
   TextView t;
   Button by,bn;
	int pay;
	double gotb;
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ask);
		initialize();
		Bundle gotprice=getIntent().getExtras();
        gotb=gotprice.getDouble("amount");
      
        
		
	}

	private void initialize() {
		// TODO Auto-generated method stub
		t=(TextView)findViewById(R.id.tVask);
		by=(Button)findViewById(R.id.bYes);
	    bn=(Button)findViewById(R.id.bNo);
		by.setOnClickListener(this);
		bn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.bYes :Bundle b=new Bundle ();
		                  b.putDouble("send",gotb);	
		                  Intent send=new Intent(Ask.this,CustomerLogin.class);
		                  send.putExtras(b);
		                  startActivity(send);
		                  
			break;
		case R.id.bNo:   Bundle c=new Bundle ();
                        c.putDouble("send",gotb);	
                    Intent send2=new Intent(Ask.this,Pay.class);
                         send2.putExtras(c);
                         startActivity(send2);
			break;
		}
		
		
		
	}
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		finish();
	}


}
