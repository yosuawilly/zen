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
    	menus.add(new Menu("Step Shalat"));
    	menus.add(new Menu("Niat Shalat"));
    	menus.add(new Menu("Do'a Qunut"));
    	menus.add(new Menu("Surat-surat pendek"));
    	menus.add(new Menu("Pengertian Shalat"));
    	menus.add(new Menu("Syarat-syarat Shalat"));
    	menus.add(new Menu("Rukun Shalat"));
    	menus.add(new Menu("Yang Membatalkan Shalat"));
    	menus.add(new Menu("Perbedaan Laki-laki & wanita dalam Shalat"));
    	menus.add(new Menu("Waktu-waktu Shalat"));
    	menus.add(new Menu("Makmum Masbuq"));
    	menus.add(new Menu("Shalat Jumat"));
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
		} else if(((MenuListAdapter)adapter.getAdapter()).getItem(position).getMenuTextTop().contains("Pengertian")){
			intent.putExtra("type", Constant.PENGERTIAN_SHALAT);
		} else if(((MenuListAdapter)adapter.getAdapter()).getItem(position).getMenuTextTop().contains("Syarat")){
			intent.putExtra("type", Constant.SYARAT_SHALAT);
		} else if(((MenuListAdapter)adapter.getAdapter()).getItem(position).getMenuTextTop().contains("Rukun")){
			intent.putExtra("type", Constant.RUKUN_SHALAT);
		} else if(((MenuListAdapter)adapter.getAdapter()).getItem(position).getMenuTextTop().contains("Yang")){
			intent.putExtra("type", Constant.YANG_MEMBATALKAN_SHALAT);
		} else if(((MenuListAdapter)adapter.getAdapter()).getItem(position).getMenuTextTop().contains("Perbedaan")){
			intent.putExtra("type", Constant.PERBEDAAN_SHALAT);
		} else if(((MenuListAdapter)adapter.getAdapter()).getItem(position).getMenuTextTop().contains("Waktu")){
			intent.putExtra("type", Constant.WAKTU_SHALAT);
		} else if(((MenuListAdapter)adapter.getAdapter()).getItem(position).getMenuTextTop().contains("Makmum")){
			intent.putExtra("type", Constant.MAKMUM_MASBUQ);
		} else if(((MenuListAdapter)adapter.getAdapter()).getItem(position).getMenuTextTop().contains("Jumat")){
			intent.putExtra("type", Constant.SHALAT_JUMAT);
		}
		startActivity(intent);
	}

}
