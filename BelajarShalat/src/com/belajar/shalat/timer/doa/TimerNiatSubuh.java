package com.belajar.shalat.timer.doa;

import com.belajar.shalat.R;
import com.belajar.shalat.timer.TimerListener;
import com.belajar.shalat.timer.TimerTextDoa;

public class TimerNiatSubuh extends TimerTextDoa{

	public TimerNiatSubuh(TimerListener listener) {
		super(listener);
	}

	@Override
	public void buildSurat() {
		surat.add(new Integer[]{R.drawable.niat_subuh_1, R.drawable.niat_subuh_1_arti});
	}

	@Override
	public int getJumlahSub() {
		return 1;
	}

	@Override
	public int getPeriod() {
		return 10000;
	}

}
