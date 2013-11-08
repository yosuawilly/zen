package com.belajar.shalat.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import com.belajar.shalat.BelajarShalatActivity;
import com.belajar.shalat.adapter.MenuListAdapter;
import com.belajar.shalat.util.Constant;

public class FullVideoMenuActivity extends BelajarShalatActivity{
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void initDesignComponents() {
		super.initDesignComponents();
		subTitle.setText("Full Video");
		backButton.setVisibility(Button.VISIBLE);
	}
	
	@Override
	public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3) {
		Intent intent;
		intent = new Intent(this, FullVideoActivity.class);
		if(((MenuListAdapter)adapter.getAdapter()).getItem(position).getMenuTextTop().contains("Subuh")){
			intent.putExtra("type", Constant.SUBUH);
		} else if(((MenuListAdapter)adapter.getAdapter()).getItem(position).getMenuTextTop().contains("Dzuhur")){
			intent.putExtra("type", Constant.DZUHUR);
		} else if(((MenuListAdapter)adapter.getAdapter()).getItem(position).getMenuTextTop().contains("Ashar")){
			intent.putExtra("type", Constant.ASHAR);
		} else if(((MenuListAdapter)adapter.getAdapter()).getItem(position).getMenuTextTop().contains("Maghrib")){
			intent.putExtra("type", Constant.MAGHRIB);
		} else if(((MenuListAdapter)adapter.getAdapter()).getItem(position).getMenuTextTop().contains("Isya")){
			intent.putExtra("type", Constant.ISYA);
		}
		startActivity(intent);
	}

}
