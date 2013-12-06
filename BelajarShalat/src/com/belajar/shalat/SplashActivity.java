package com.belajar.shalat;

import com.belajar.shalat.activity.MainMenuActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

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
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		unbindDrawables(findViewById(R.id.splash));
		System.gc();
	}
	
	private void unbindDrawables(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback(null);
        }
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                unbindDrawables(((ViewGroup) view).getChildAt(i));
            }
            ((ViewGroup) view).removeAllViews();
        }
    }

}
