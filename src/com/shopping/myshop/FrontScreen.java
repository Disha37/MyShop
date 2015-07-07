package com.shopping.myshop;


import android.view.Menu;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class FrontScreen extends Activity {



	MediaPlayer mySong;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_front_screen);
		mySong = MediaPlayer.create(FrontScreen.this,R.raw.start);
		mySong.start();
		Thread timer=new Thread()
		{
			@Override
			public void run()
			{
				try
				{
				sleep(3000);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
				finally
				{
					

						Intent openStarting=new Intent("com.shopping.myshop.DISPLAYING");
						startActivity(openStarting);
					
				}
				}
			
			};
		
		
	
			timer.start();
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		mySong.release();
		finish();
	}

	

}
