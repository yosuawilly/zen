package com.belajar.shalat.model;

public class Menu {
	
	private String menuTextTop;
	private String menuTextBottom;
	private String menuTextRight;
//	private boolean list;
	
	public Menu() {
		// TODO Auto-generated constructor stub
	}
	
	public Menu(String menuTextTop) {
		this.menuTextTop = menuTextTop;
	}
	
	public Menu(String menuTextTop, String menuTextBottom) {
		this.menuTextTop = menuTextTop;
		this.menuTextBottom = menuTextBottom;
//		this.list = false;
	}
	
	public Menu(String menuTextTop, String menuTextBottom, boolean list) {
		this.menuTextTop = menuTextTop;
		this.menuTextBottom = menuTextBottom;
//		this.list = list;
	}
	
	public Menu(String menuTextTop, String menuTextBottom, String menuTextRight) {
		this.menuTextTop = menuTextTop;
		this.menuTextBottom = menuTextBottom;
		this.menuTextRight = menuTextRight;
	}
	
	public Menu(String menuTextTop, String menuTextBottom, String menuTextRight, boolean list) {
		this.menuTextTop = menuTextTop;
		this.menuTextBottom = menuTextBottom;
		this.menuTextRight = menuTextRight;
//		this.list= list;
	}

	public String getMenuTextTop() {
		return menuTextTop;
	}

	public void setMenuTextTop(String menuTextTop) {
		this.menuTextTop = menuTextTop;
	}

	public String getMenuTextBottom() {
		return menuTextBottom;
	}

	public void setMenuTextBottom(String menuTextBottom) {
		this.menuTextBottom = menuTextBottom;
	}

	public String getMenuTextRight() {
		return menuTextRight;
	}

	public void setMenuTextRight(String menuTextRight) {
		this.menuTextRight = menuTextRight;
	}
	
//	public boolean getList(){
//		return list;
//	}
//	
//	public void setList(boolean list){
//	    this.list=list;
//	}

}
