package com.belajar.shalat.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
		final Intent intent;
		intent = new Intent(this, FullVideoActivity.class);
		if(((MenuListAdapter)adapter.getAdapter()).getItem(position).getMenuTextTop().contains("Subuh")){
			intent.putExtra("type", Constant.SUBUH);
			new AlertDialog.Builder(this)
			.setTitle("Pertanyaan").setMessage("Pakai Qunut atau tidak?")
			.setPositiveButton("Pakai", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					intent.putExtra("useQunut", true);
					startActivity(intent);
				}
			})
			.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					intent.putExtra("useQunut", false);
					startActivity(intent);
				}
			}).show();
		} else if(((MenuListAdapter)adapter.getAdapter()).getItem(position).getMenuTextTop().contains("Dzuhur")){
			intent.putExtra("type", Constant.DZUHUR);
			startActivity(intent);
		} else if(((MenuListAdapter)adapter.getAdapter()).getItem(position).getMenuTextTop().contains("Ashar")){
			intent.putExtra("type", Constant.ASHAR);
			startActivity(intent);
		} else if(((MenuListAdapter)adapter.getAdapter()).getItem(position).getMenuTextTop().contains("Maghrib")){
			intent.putExtra("type", Constant.MAGHRIB);
			startActivity(intent);
		} else if(((MenuListAdapter)adapter.getAdapter()).getItem(position).getMenuTextTop().contains("Isya")){
			intent.putExtra("type", Constant.ISYA);
			startActivity(intent);
		}
	}

}
