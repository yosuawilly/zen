package com.belajar.shalat.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import com.belajar.shalat.BelajarShalatActivity;
import com.belajar.shalat.adapter.MenuListAdapter;
import com.belajar.shalat.model.Menu;
import com.belajar.shalat.util.Constant;

public class MateriMenuActivity extends BelajarShalatActivity{
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void initDesignComponents() {
		super.initDesignComponents();
		subTitle.setText("Materi");
		backButton.setVisibility(Button.VISIBLE);
	}
	
	@Override
	public void configureFunctionComponents() {
		super.configureFunctionComponents();
		menus.clear();
//		menus.add(new Menu("Do'a Bacaaan Shalat"));
//    	menus.add(new Menu("Gambar Gerakan Shalat"));
//    	menus.add(new Menu("Surat-surat pendek"));
    	menus.add(new Menu("Step Shalat"));
    	menus.add(new Menu("Niat Shalat"));
    	menus.add(new Menu("Do'a Qunut"));
    	menus.add(new Menu("Surat-surat pendek"));
    	menuAdapter.notifyDataSetChanged();
	}
	
	@Override
	public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3) {
		Intent intent;
		intent = new Intent(this, MateriActivity.class);
		if(((MenuListAdapter)adapter.getAdapter()).getItem(position).getMenuTextTop().contains("Step")){
			intent.putExtra("type", Constant.STEP);
		} else if(((MenuListAdapter)adapter.getAdapter()).getItem(position).getMenuTextTop().contains("Niat")){
			intent.putExtra("type", Constant.NIAT);
		} else if(((MenuListAdapter)adapter.getAdapter()).getItem(position).getMenuTextTop().contains("Qunut")){
			intent.putExtra("type", Constant.QUNUT);
		} else if(((MenuListAdapter)adapter.getAdapter()).getItem(position).getMenuTextTop().contains("Surat")){
			intent = new Intent(this, SuratMenuActivity.class);
		}
		startActivity(intent);
	}

}
