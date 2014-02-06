package com.belajar.shalat.timer.doa;

import com.belajar.shalat.R;
import com.belajar.shalat.timer.TimerListener;
import com.belajar.shalat.timer.TimerTextDoa;

public class TimerIftitah extends TimerTextDoa{

	public TimerIftitah(TimerListener listener) {
		super(listener);
	}

	@Override
	public void buildSurat() {
		surat.add(new Integer[]{R.drawable.iftitah_1, R.drawable.iftitah_1_arti});
		surat.add(new Integer[]{R.drawable.iftitah_2, R.drawable.iftitah_2_arti});
		surat.add(new Integer[]{R.drawable.iftitah_3, R.drawable.iftitah_3_arti});
		surat.add(new Integer[]{R.drawable.iftitah_4, R.drawable.iftitah_4_arti});
	}

	@Override
	public int getJumlahSub() {
		return 4;
	}

	@Override
	public int getPeriod() {
		return 50000;
	}

}
