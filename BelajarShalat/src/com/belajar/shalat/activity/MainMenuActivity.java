package com.belajar.shalat.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.belajar.shalat.BelajarShalatActivity;
import com.belajar.shalat.R;
import com.belajar.shalat.activity.base.BaseActivity;
import com.belajar.shalat.tools.Functional;

public class MainMenuActivity extends BaseActivity implements Functional, OnClickListener{
	Button btnMateri, btnVideo, btnFullVideo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu_layout);
		
		initDesignComponents();
		
		configureFunctionComponents();
	}

	@Override
	public void initDesignComponents() {
		btnMateri = (Button) findViewById(R.id.btnMateri);
		btnVideo = (Button) findViewById(R.id.btnVideo);
		btnFullVideo = (Button) findViewById(R.id.btnFullVideo);
	}

	@Override
	public void configureFunctionComponents() {
		btnMateri.setOnClickListener(this);
		btnVideo.setOnClickListener(this);
		btnFullVideo.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = null;
		switch (v.getId()) {
		case R.id.btnMateri:
			intent = new Intent(this, MateriMenuActivity.class);
			break;
		case R.id.btnVideo:
			intent = new Intent(this, BelajarShalatActivity.class);
			break;
		case R.id.btnFullVideo:
			intent = new Intent(this, FullVideoMenuActivity.class);
			break;
		default:
			break;
		}
		startActivity(intent);
	}

}
