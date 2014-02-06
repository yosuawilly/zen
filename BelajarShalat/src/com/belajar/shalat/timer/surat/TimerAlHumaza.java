package com.belajar.shalat.timer.surat;

import com.belajar.shalat.R;
import com.belajar.shalat.timer.TimerListener;
import com.belajar.shalat.timer.TimerTextDoa;

public class TimerAlHumaza extends TimerTextDoa{

	public TimerAlHumaza(TimerListener listener) {
		super(listener);
	}

	@Override
	public void buildSurat() {
		surat.add(new Integer[]{R.drawable.alhumaza_1, R.drawable.alhumaza_1_arti});
		surat.add(new Integer[]{R.drawable.alhumaza_2, R.drawable.alhumaza_2_arti});
		surat.add(new Integer[]{R.drawable.alhumaza_3, R.drawable.alhumaza_3_arti});
		surat.add(new Integer[]{R.drawable.alhumaza_4, R.drawable.alhumaza_4_arti});
		surat.add(new Integer[]{R.drawable.alhumaza_5, R.drawable.alhumaza_5_arti});
		surat.add(new Integer[]{R.drawable.alhumaza_6, R.drawable.alhumaza_6_arti});
		surat.add(new Integer[]{R.drawable.alhumaza_7, R.drawable.alhumaza_7_arti});
		surat.add(new Integer[]{R.drawable.alhumaza_8, R.drawable.alhumaza_8_arti});
		surat.add(new Integer[]{R.drawable.alhumaza_9, R.drawable.alhumaza_9_arti});
	}

	@Override
	public int getJumlahSub() {
		return 9;
	}

	@Override
	public int getPeriod() {
		return 39000;
	}

}
