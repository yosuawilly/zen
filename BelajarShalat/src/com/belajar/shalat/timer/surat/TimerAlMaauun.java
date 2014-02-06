package com.belajar.shalat.timer.surat;

import com.belajar.shalat.R;
import com.belajar.shalat.timer.TimerListener;
import com.belajar.shalat.timer.TimerTextDoa;

public class TimerAlMaauun extends TimerTextDoa{

	public TimerAlMaauun(TimerListener listener) {
		super(listener);
	}

	@Override
	public void buildSurat() {
		surat.add(new Integer[]{R.drawable.almaun_1, R.drawable.almaun_1_arti});
		surat.add(new Integer[]{R.drawable.almaun_2, R.drawable.almaun_2_arti});
		surat.add(new Integer[]{R.drawable.almaun_3, R.drawable.almaun_3_arti});
		surat.add(new Integer[]{R.drawable.almaun_4, R.drawable.almaun_4_arti});
		surat.add(new Integer[]{R.drawable.almaun_5, R.drawable.almaun_5_arti});
		surat.add(new Integer[]{R.drawable.almaun_6, R.drawable.almaun_6_arti});
		surat.add(new Integer[]{R.drawable.almaun_7, R.drawable.almaun_7_arti});
	}

	@Override
	public int getJumlahSub() {
		return 7;
	}

	@Override
	public int getPeriod() {
		return 31000;
	}

}
