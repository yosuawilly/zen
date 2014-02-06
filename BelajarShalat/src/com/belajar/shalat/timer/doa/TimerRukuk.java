package com.belajar.shalat.timer.doa;

import com.belajar.shalat.R;
import com.belajar.shalat.timer.TimerListener;
import com.belajar.shalat.timer.TimerTextDoa;

public class TimerRukuk extends TimerTextDoa{

	public TimerRukuk(TimerListener listener) {
		super(listener);
	}

	@Override
	public void buildSurat() {
		surat.add(new Integer[]{R.drawable.rukuk, R.drawable.rukuk_arti});
	}

	@Override
	public int getJumlahSub() {
		return 1;
	}

	@Override
	public int getPeriod() {
		return 14000;
	}

}
