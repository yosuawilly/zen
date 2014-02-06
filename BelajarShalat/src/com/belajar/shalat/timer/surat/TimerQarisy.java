package com.belajar.shalat.timer.surat;

import com.belajar.shalat.R;
import com.belajar.shalat.timer.TimerListener;
import com.belajar.shalat.timer.TimerTextDoa;

public class TimerQarisy extends TimerTextDoa{

	public TimerQarisy(TimerListener listener) {
		super(listener);
	}

	@Override
	public void buildSurat() {
		surat.add(new Integer[]{R.drawable.alquraisy_1, R.drawable.alquraisy_1_arti});
		surat.add(new Integer[]{R.drawable.alquraisy_2, R.drawable.alquraisy_2_arti});
		surat.add(new Integer[]{R.drawable.alquraisy_3, R.drawable.alquraisy_3_arti});
		surat.add(new Integer[]{R.drawable.alquraisy_4, R.drawable.alquraisy_4_arti});
	}

	@Override
	public int getJumlahSub() {
		return 4;
	}

	@Override
	public int getPeriod() {
		return 23000;
	}

}
