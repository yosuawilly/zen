package com.belajar.shalat;

import com.belajar.shalat.activity.MainMenuActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		Thread timer = new Thread(){
			
			@Override
			public void run() {
				try{
					int time = 0;
					while(time < 3000){
						sleep(100);
						time += 100;
					}
				}catch(Exception ex){
					ex.printStackTrace();
				} finally {
//					startActivity(new Intent(SplashActivity.this, BelajarShalatActivity.class));
					startActivity(new Intent(SplashActivity.this, MainMenuActivity.class));
					finish();
				}
			}
			
		};
		
		timer.start();
	}

}
