package com.belajar.shalat.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import com.belajar.shalat.R;
import com.belajar.shalat.activity.base.BaseActivity;
import com.belajar.shalat.tools.Functional;
import com.belajar.shalat.util.Constant;

public class MateriActivity extends BaseActivity implements Functional,OnClickListener{
	public Button nextButton, backButton;
	WebView webView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.materi_layout);
		
		initDesignComponents();
		
		configureFunctionComponents();
	}
	
	@SuppressLint("SetJavaScriptEnabled") @Override
	public void initDesignComponents() {
		nextButton = (Button) findViewById(R.id.nextButton);
		backButton = (Button) findViewById(R.id.backButton);
		nextButton.setVisibility(Button.GONE);
		
        String type = getIntent().getExtras().getString("type");
		
		webView = (WebView) findViewById(R.id.webView);
		webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
		webView.setBackgroundColor(0x00000000);
		webView.getSettings().setJavaScriptEnabled(true);
		
		Log.i("viewWeb", "view");
		Log.i("type", type);
		webView.loadUrl(getUrlToLoad(type));
	}

	@Override
	public void configureFunctionComponents() {
		nextButton.setOnClickListener(this);
		backButton.setOnClickListener(this);
	}
	
	private String getUrlToLoad(String type){
		if(type.equals(Constant.STEP)){
			return "file:///android_asset/www/shalat.html";
		} else if(type.equals(Constant.NIAT)){
			return "file:///android_asset/www/niat.html";
		} else if(type.equals(Constant.QUNUT)){
			return "file:///android_asset/www/qunut.html";
		} else if(type.equals(Constant.FATIHAH)){
			return "file:///android_asset/www/alfatihah.html";
		} else if(type.equals(Constant.FALAQ)){
			return "file:///android_asset/www/alfalaq.html";
		} else if(type.equals(Constant.NAS)){
			return "file:///android_asset/www/annas.html";
		} else if(type.equals(Constant.IKHLAS)){
			return "file:///android_asset/www/alikhlas.html";
		}
		return "";
	}

	@Override
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
