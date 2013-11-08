package com.belajar.shalat.activity.base;

import com.belajar.shalat.R;
import com.belajar.shalat.tools.Functional;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BaseMainActivity extends BaseActivity implements Functional, OnClickListener{
	public Button nextButton, backButton;
	public LinearLayout mainBody;
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

	public void initDesignComponents() {
		viewInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		linearSubTitle = (LinearLayout) findViewById(R.id.linearSubTitle);
		txtTitle = (TextView) findViewById(R.id.txtTitle);
		subTitle = (TextView) findViewById(R.id.subTitle);
		
		nextButton = (Button) findViewById(R.id.nextButton);
		backButton = (Button) findViewById(R.id.backButton);
		
		mainBody = (LinearLayout) findViewById(R.id.mainBody);
	}

	public void configureFunctionComponents() {
		nextButton.setOnClickListener(this);
		backButton.setOnClickListener(this);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.nextButton:
			
			break;
		case R.id.backButton:
			onBackPressed();
			break;
		default:
			break;
		}
	}
	
}
