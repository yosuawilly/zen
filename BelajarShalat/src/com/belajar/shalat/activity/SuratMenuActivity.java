package com.belajar.shalat.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import com.belajar.shalat.BelajarShalatActivity;
import com.belajar.shalat.adapter.MenuListAdapter;
import com.belajar.shalat.model.Menu;
import com.belajar.shalat.util.Constant;

public class SuratMenuActivity extends BelajarShalatActivity{
	
	@Override
	public void initDesignComponents() {
		super.initDesignComponents();
		subTitle.setText("Surat-surat Pendek");
		backButton.setVisibility(Button.VISIBLE);
	}
	
	@Override
	public void configureFunctionComponents() {
		super.configureFunctionComponents();
		menus.clear();
    	menus.add(new Menu("Surat Al-Fatihah"));
    	menus.add(new Menu("Surat An-Nas"));
    	menus.add(new Menu("Surat Al-Falaq"));
    	menus.add(new Menu("Surat Al-Ikhlas"));
    	menuAdapter.notifyDataSetChanged();
	}
	
	@Override
	public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3) {
		Intent intent;
		intent = new Intent(this, MateriActivity.class);
		if(((MenuListAdapter)adapter.getAdapter()).getItem(position).getMenuTextTop().contains("Fatihah")){
			intent.putExtra("type", Constant.FATIHAH);
		} else if(((MenuListAdapter)adapter.getAdapter()).getItem(position).getMenuTextTop().contains("Nas")){
			intent.putExtra("type", Constant.NAS);
		} else if(((MenuListAdapter)adapter.getAdapter()).getItem(position).getMenuTextTop().contains("Falaq")){
			intent.putExtra("type", Constant.FALAQ);
		} else if(((MenuListAdapter)adapter.getAdapter()).getItem(position).getMenuTextTop().contains("Ikhlas")){
			intent.putExtra("type", Constant.IKHLAS);
		}
		startActivity(intent);
	}

}
