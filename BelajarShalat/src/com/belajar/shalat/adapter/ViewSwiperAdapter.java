package com.belajar.shalat.adapter;

import java.util.ArrayList;
import java.util.List;
import com.belajar.shalat.tools.ViewClickListener;
import com.belajar.shalat.tools.ViewSwiper;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

public class ViewSwiperAdapter extends FragmentStatePagerAdapter{
	Context context;
	List<String> stepShalat;
	ViewClickListener<Object> viewListener;
	ViewSwiper viewSwiper;
	List<ViewSwiper> listSwiper;
	String typeShalat;

	public ViewSwiperAdapter(FragmentManager fm, List<String> stepShalat, String typeShalat, Context context, ViewClickListener<Object> viewListener) {
		super(fm);
		this.context = context;
		this.stepShalat = stepShalat;
		this.typeShalat = typeShalat;
		this.viewListener = viewListener;
		viewSwiper = new ViewSwiper(context, viewListener);
		listSwiper = new ArrayList<ViewSwiper>();
	}

	@Override
	public Fragment getItem(int arg0) {
		ViewSwiper fragment = viewSwiper.create(arg0, stepShalat, typeShalat);
		listSwiper.add(arg0, fragment);
		//return viewSwiper.create(arg0, stepShalat);
		Log.i("create", "fragment"+arg0);
		return fragment;
	}
	
	public List<ViewSwiper> getListSwiper() {
		return listSwiper;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return stepShalat.size();
	}

}
