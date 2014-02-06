package com.belajar.shalat.timer.surat;

import com.belajar.shalat.R;
import com.belajar.shalat.timer.TimerListener;
import com.belajar.shalat.timer.TimerTextDoa;

public class TimerAnnass extends TimerTextDoa{

	public TimerAnnass(TimerListener listener) {
		super(listener);
	}

	@Override
	public void buildSurat() {
		surat.add(new Integer[]{R.drawable.annass_0, R.drawable.annass_0_arti});
		surat.add(new Integer[]{R.drawable.annass_1, R.drawable.annass_1_arti});
		surat.add(new Integer[]{R.drawable.annass_2, R.drawable.annass_2_arti});
		surat.add(new Integer[]{R.drawable.annass_3, R.drawable.annass_3_arti});
		surat.add(new Integer[]{R.drawable.annass_4, R.drawable.annass_4_arti});
		surat.add(new Integer[]{R.drawable.annass_5, R.drawable.annass_5_arti});
	}

	@Override
	public int getJumlahSub() {
		return 6;
	}

	@Override
	public int getPeriod() {
		return 22000;
	}

}
