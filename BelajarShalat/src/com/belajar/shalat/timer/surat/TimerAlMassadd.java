package com.belajar.shalat.timer.surat;

import com.belajar.shalat.R;
import com.belajar.shalat.timer.TimerListener;
import com.belajar.shalat.timer.TimerTextDoa;

public class TimerAlMassadd extends TimerTextDoa{

	public TimerAlMassadd(TimerListener listener) {
		super(listener);
	}

	@Override
	public void buildSurat() {
		surat.add(new Integer[]{R.drawable.almasad_1, R.drawable.almasad_1_arti});
		surat.add(new Integer[]{R.drawable.almasad_2, R.drawable.almasad_2_arti});
		surat.add(new Integer[]{R.drawable.almasad_3, R.drawable.almasad_3_arti});
		surat.add(new Integer[]{R.drawable.almasad_4, R.drawable.almasad_4_arti});
		surat.add(new Integer[]{R.drawable.almasad_5, R.drawable.almasad_5_arti});
	}

	@Override
	public int getJumlahSub() {
		return 5;
	}

	@Override
	public int getPeriod() {
		return 25000;
	}

}
