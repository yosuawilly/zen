package com.belajar.shalat.timer.surat;

import com.belajar.shalat.R;
import com.belajar.shalat.timer.TimerListener;
import com.belajar.shalat.timer.TimerTextDoa;

public class TimerAlFill extends TimerTextDoa{

	public TimerAlFill(TimerListener listener) {
		super(listener);
	}

	@Override
	public void buildSurat() {
		surat.add(new Integer[]{R.drawable.alfill_1, R.drawable.alfill_1_arti});
		surat.add(new Integer[]{R.drawable.alfill_2, R.drawable.alfill_2_arti});
		surat.add(new Integer[]{R.drawable.alfill_3, R.drawable.alfill_3_arti});
		surat.add(new Integer[]{R.drawable.alfill_4, R.drawable.alfill_4_arti});
		surat.add(new Integer[]{R.drawable.alfill_5, R.drawable.alfill_5_arti});
	}

	@Override
	public int getJumlahSub() {
		return 5;
	}

	@Override
	public int getPeriod() {
		return 29000;
	}

}
