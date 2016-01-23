package com.herotculb.qunhaichat;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.herotculb.qunhaichat.activity.SignInActivity;

public class MainActivity extends Activity {
	private long splashDelay = 5000; //5 seconds
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		 TimerTask task = new TimerTask()
	        {

				@Override
				public void run() {
				    SharedPreferences preferences = getSharedPreferences("usermessage", Activity.MODE_PRIVATE);
				    String userName = preferences.getString("username", "");
				    String passWord =preferences.getString("password", "");
					
					if ("".equals(userName)||"".equals(passWord)) {
						Intent mainIntent = new Intent().setClass(MainActivity.this, SignInActivity.class);
						startActivity(mainIntent);
					} else {
						Intent mainIntent = new Intent().setClass(MainActivity.this, SignInActivity.class);
						mainIntent.putExtra("username", userName);
						mainIntent.putExtra("password", passWord);
						mainIntent.putExtra("key", "1");
						startActivity(mainIntent);
					}
					finish();
					
					overridePendingTransition(android.R.anim.fade_in,
							android.R.anim.fade_out);
				}
	        	
	        };
	        
	        Timer timer = new Timer();
	        timer.schedule(task, splashDelay);
		
	}


}
