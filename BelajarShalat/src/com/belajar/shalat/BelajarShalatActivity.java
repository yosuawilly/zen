package com.belajar.shalat;

import java.util.ArrayList;
import java.util.List;

import com.belajar.shalat.activity.MainMenuActivity;
import com.belajar.shalat.activity.TutorActivity;
import com.belajar.shalat.activity.base.BaseMainActivity;
import com.belajar.shalat.adapter.MenuListAdapter;
import com.belajar.shalat.model.Menu;
import com.belajar.shalat.util.Constant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class BelajarShalatActivity extends BaseMainActivity implements OnItemClickListener {
	public ListView listMenu;
	public List<Menu> menus;
	public MenuListAdapter menuAdapter;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    
    @Override
    public void initDesignComponents() {
    	super.initDesignComponents();
    	View v = viewInflater.inflate(R.layout.main_layout, null);
    	mainBody.addView(v);
    	subTitle.setText("Step Video");
    	listMenu = (ListView) findViewById(R.id.list_menu);
    	nextButton.setVisibility(Button.GONE);
//    	backButton.setVisibility(Button.GONE);
    }
    
    @Override
    public void configureFunctionComponents() {
    	super.configureFunctionComponents();
    	menuAdapter = new MenuListAdapter(this, R.layout.list_layout);
    	menus = new ArrayList<Menu>();
    	menus.add(new Menu("Shalat Subuh", "Shalat Subh - Morning Prayer"));
    	menus.add(new Menu("Shalat Dzuhur", "Shalat Zuhr - Noon Prayer"));
    	menus.add(new Menu("Shalat Ashar", "Shalat Asr - Afternoon Prayer"));
    	menus.add(new Menu("Shalat Maghrib", "Shalat Maghrib - Evening Prayer"));
    	menus.add(new Menu("Shalat Isya", "Shalat Isha - Night Prayer"));
    	menuAdapter.setMainMenus(menus);
    	listMenu.setAdapter(menuAdapter);
    	listMenu.setOnItemClickListener(this);
    }

	public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3) {
		// TODO Auto-generated method stub
		Intent intent;
		intent = new Intent(this, TutorActivity.class);
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
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
//		Intent intent = new Intent(this, MainMenuActivity.class);
//		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//		startActivity(intent);
	}
    
}