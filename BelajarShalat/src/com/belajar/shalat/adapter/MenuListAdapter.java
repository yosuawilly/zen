package com.belajar.shalat.adapter;

import java.util.List;
import com.belajar.shalat.R;
import com.belajar.shalat.model.Menu;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MenuListAdapter extends ArrayAdapter<Menu>{
	private List<Menu> menus;
	int resourceId;
	Context context ;
	LayoutInflater viewInflater;
	TextView menuTextTop, menuTextBottom, menuTextRight, txtNumber;
	LinearLayout nextIcon;

	public MenuListAdapter(Context context, int textViewResourceId) {
		super(context, textViewResourceId);
		this.resourceId = textViewResourceId;
		this.context = context;
		viewInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	public void setMainMenus(List<Menu> menus) {
		this.menus = menus;
	}
	
	public List<Menu> getMenus() {
		return menus;
	}
	
	@Override
	public int getCount() {
		return menus.size();
	}

	@Override
	public Menu getItem(int position) {
		return this.menus.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return super.getItemId(position);
	}
	
	@Override
	public View getView(int position, View view, ViewGroup viewGroup) {
		view = viewInflater.inflate(R.layout.list_layout, viewGroup,false);
		txtNumber = (TextView) view.findViewById(R.id.txtNumber);
		txtNumber.setText(String.valueOf(position+1));
		menuTextTop = (TextView) view.findViewById(R.id.menuTextTop);
		menuTextBottom = (TextView) view.findViewById(R.id.menuTextBottom);
		if(!(getMenus().get(position).getMenuTextRight()==null)){
			menuTextRight = (TextView)view.findViewById(R.id.menuTextRight);
			nextIcon = (LinearLayout)view.findViewById(R.id.nextIcon);
			menuTextRight.setVisibility(TextView.VISIBLE);
			nextIcon.setVisibility(LinearLayout.GONE);
			menuTextTop.setText(getMenus().get(position).getMenuTextTop());
			
			if(getMenus().get(position).getMenuTextBottom()==null){
				menuTextBottom.setVisibility(TextView.GONE);
			} else 
			menuTextBottom.setText(getMenus().get(position).getMenuTextBottom());
			
			menuTextRight.setText(getMenus().get(position).getMenuTextRight());
		}else {
			menuTextTop.setText(getMenus().get(position).getMenuTextTop());
			
			if(getMenus().get(position).getMenuTextBottom()==null){
				menuTextBottom.setVisibility(TextView.GONE);
			} else 
			menuTextBottom.setText(getMenus().get(position).getMenuTextBottom());	
		}
		
		return view;
	}

}
