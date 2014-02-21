package com.belajar.shalat.activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.belajar.shalat.R;
import com.belajar.shalat.activity.base.BaseMainFragmenActivity;
import com.belajar.shalat.adapter.ViewSwiperAdapter;
import com.belajar.shalat.tools.ViewClickListener;
import com.belajar.shalat.util.Constant;
import com.belajar.shalat.widget.MyViewPager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TutorActivity extends BaseMainFragmenActivity implements ViewClickListener<Object>, OnPageChangeListener{
	
	MyViewPager tutorPager;
	ViewSwiperAdapter swiperAdapter;
	List<String> stepShalat;
	int currentPage = 0;
	String typeShalat;
	boolean useQunut = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void initDesignComponents() {
		super.initDesignComponents();
		View v = viewInflater.inflate(R.layout.tutor_layout_activity, null);
		mainBody.addView(v);
		linearSubTitle.setVisibility(LinearLayout.GONE);
		footer.setVisibility(LinearLayout.VISIBLE);
		typeShalat = getIntent().getStringExtra("type");
		txtTitle.setText(Constant.getTitle(typeShalat));
		
		tutorPager = (MyViewPager) findViewById(R.id.tutorPager);
		
		stepShalat = new ArrayList<String>();
		
		if(typeShalat.equals(Constant.SUBUH)){
			stepShalat.addAll(Arrays.asList(getResources().getStringArray(R.array.sholat_subuh)));
		} else if(typeShalat.equals(Constant.DZUHUR)){
			stepShalat.addAll(Arrays.asList(getResources().getStringArray(R.array.sholat_dzuhur)));
		} else if(typeShalat.equals(Constant.ASHAR)){
			stepShalat.addAll(Arrays.asList(getResources().getStringArray(R.array.sholat_ashar)));
		} else if(typeShalat.equals(Constant.MAGHRIB)){
			stepShalat.addAll(Arrays.asList(getResources().getStringArray(R.array.sholat_maghrib)));
		} else if(typeShalat.equals(Constant.ISYA)){
			stepShalat.addAll(Arrays.asList(getResources().getStringArray(R.array.sholat_isya)));
		}
		
	}
	
	@Override
	public void configureFunctionComponents() {
		super.configureFunctionComponents();
		swiperAdapter = new ViewSwiperAdapter(getSupportFragmentManager(), stepShalat, typeShalat, this, this);
		tutorPager.setAdapter(swiperAdapter);
		tutorPager.setCurrentItem(0);
		tutorPager.setOnPageChangeListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.nextButton:
			if(tutorPager.getCurrentItem() == (swiperAdapter.getCount()-1)) return;
			if(stepShalat.get(tutorPager.getCurrentItem()+1).equals("Qunut")){
				openDialog();
				return;
			}
			if( (tutorPager.getCurrentItem()+1) == (swiperAdapter.getCount()-1) )
				nextButton.setVisibility(Button.GONE);
			tutorPager.setCurrentItem(tutorPager.getCurrentItem()+1);
			break;
		case R.id.backButton:
			if(tutorPager.getCurrentItem() == 0) super.onClick(v);
		    else {
		    	if(stepShalat.get(tutorPager.getCurrentItem()-1).equals("Qunut")){
		    		if(!useQunut) {
		    			tutorPager.setCurrentItem(tutorPager.getCurrentItem()-2);
		    			return;
		    		}
		    	}
		    	if( (tutorPager.getCurrentItem()-1) < (swiperAdapter.getCount()-1) )
					nextButton.setVisibility(Button.VISIBLE);
		    	tutorPager.setCurrentItem(tutorPager.getCurrentItem()-1);
		    }
			break;
		default:
			super.onClick(v);
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		if(tutorPager.getCurrentItem() == 0) {
			swiperAdapter.getListSwiper().get(tutorPager.getCurrentItem()).stopTimer();
			super.onBackPressed();
		}
	    else {
	    	if(stepShalat.get(tutorPager.getCurrentItem()-1).equals("Qunut")){
	    		if(!useQunut) {
	    			tutorPager.setCurrentItem(tutorPager.getCurrentItem()-2);
	    			return;
	    		}
	    	}
	    	if( (tutorPager.getCurrentItem()-1) < (swiperAdapter.getCount()-1) )
				nextButton.setVisibility(Button.VISIBLE);
	    	tutorPager.setCurrentItem(tutorPager.getCurrentItem()-1);
	    }
	}
	
	public void openDialog(){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Pertanyaan");
		builder.setMessage("Pakai Qunut atau tidak?");
		builder.setPositiveButton("Pakai", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				tutorPager.setCurrentItem(stepShalat.indexOf(new String("Qunut")));
				useQunut = true;
				dialog.dismiss();
			}
		});
		builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				tutorPager.setCurrentItem(stepShalat.indexOf(new String("Qunut"))+1);
				useQunut = false;
				dialog.dismiss();
			}
		});
		AlertDialog dialog = builder.create();
		dialog.getWindow().getAttributes().windowAnimations = R.style.dialog_animation;
		dialog.show();
	}

	@Override
	public void onViewClick(Object... params) {
		Toast.makeText(this, params[0]+" "+params[1], Toast.LENGTH_LONG).show();
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		Log.i("onPageScrollState", String.valueOf(arg0));
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		Log.i("onPageScrollScrolled", String.valueOf(arg0)+" "+String.valueOf(arg1)+" "+String.valueOf(arg2));
	}

	@Override
	public void onPageSelected(int arg0) {
		swiperAdapter.getListSwiper().get(currentPage).stopVideo();
		if(arg0 > currentPage){
			if(stepShalat.get(arg0).equals("Qunut")){
				openDialog();
				return;
			}
		} else {
			if(stepShalat.get(arg0).equals("Qunut")){
				if(!useQunut) {
	    			tutorPager.setCurrentItem(arg0-1);
	    			return;
	    		}
			}
		}
		this.currentPage = arg0;
		Log.i("selected", String.valueOf(arg0));
	}

}
