package com.belajar.shalat.timer.surat;

import com.belajar.shalat.R;
import com.belajar.shalat.timer.TimerListener;
import com.belajar.shalat.timer.TimerTextDoa;

public class TimerAlKafirun extends TimerTextDoa{

	public TimerAlKafirun(TimerListener listener) {
		super(listener);
	}

	@Override
	public void buildSurat() {
		surat.add(new Integer[]{R.drawable.alkafirun_1, R.drawable.alkafirun_1_arti});
		surat.add(new Integer[]{R.drawable.alkafirun_2, R.drawable.alkafirun_2_arti});
		surat.add(new Integer[]{R.drawable.alkafirun_3, R.drawable.alkafirun_3_arti});
		surat.add(new Integer[]{R.drawable.alkafirun_4, R.drawable.alkafirun_4_arti});
		surat.add(new Integer[]{R.drawable.alkafirun_5, R.drawable.alkafirun_5_arti});
		surat.add(new Integer[]{R.drawable.alkafirun_6, R.drawable.alkafirun_6_arti});
	}

	@Override
	public int getJumlahSub() {
		return 6;
	}

	@Override
	public int getPeriod() {
		return 36000;
	}

}
