package com.belajar.shalat.activity.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.belajar.shalat.BelajarShalatActivity;
import com.belajar.shalat.R;
import com.belajar.shalat.tools.Functional;

public class BaseMainFragmenActivity extends BaseFragmentActivity implements Functional, OnClickListener{
	public Button nextButton, backButton, homeButton;
	public LinearLayout mainBody;
	public LinearLayout footer;
	public LinearLayout linearSubTitle;
	public TextView txtTitle, subTitle;
	public LayoutInflater viewInflater;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		initDesignComponents();
		
		configureFunctionComponents();
	}

	@Override
	public void initDesignComponents() {
		viewInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		txtTitle = (TextView) findViewById(R.id.txtTitle);
		subTitle = (TextView) findViewById(R.id.subTitle);
		linearSubTitle = (LinearLayout) findViewById(R.id.linearSubTitle);
		
		nextButton = (Button) findViewById(R.id.nextButton);
		backButton = (Button) findViewById(R.id.backButton);
		homeButton = (Button) findViewById(R.id.home_button);
		
		mainBody = (LinearLayout) findViewById(R.id.mainBody);
		footer = (LinearLayout) findViewById(R.id.footer);
	}

	@Override
	public void configureFunctionComponents() {
		nextButton.setOnClickListener(this);
		backButton.setOnClickListener(this);
		homeButton.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.nextButton:
			
			break;
		case R.id.backButton:
			onBackPressed();
			break;
		case R.id.home_button:
			Intent intent = new Intent(this, BelajarShalatActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			break;
		default:
			break;
		}
	}

}
