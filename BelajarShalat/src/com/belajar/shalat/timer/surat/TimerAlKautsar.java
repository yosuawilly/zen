package com.belajar.shalat.timer.surat;

import com.belajar.shalat.R;
import com.belajar.shalat.timer.TimerListener;
import com.belajar.shalat.timer.TimerTextDoa;

public class TimerAlKautsar extends TimerTextDoa{

	public TimerAlKautsar(TimerListener listener) {
		super(listener);
	}

	@Override
	public void buildSurat() {
		surat.add(new Integer[]{R.drawable.alkausar_1, R.drawable.alkausar_1_arti});
		surat.add(new Integer[]{R.drawable.alkausar_2, R.drawable.alkausar_2_arti});
		surat.add(new Integer[]{R.drawable.alkausar_3, R.drawable.alkausar_3_arti});
	}

	@Override
	public int getJumlahSub() {
		return 3;
	}

	@Override
	public int getPeriod() {
		return 15000;
	}

}
