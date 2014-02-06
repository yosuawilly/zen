package com.belajar.shalat.timer.doa;

import com.belajar.shalat.R;
import com.belajar.shalat.timer.TimerListener;
import com.belajar.shalat.timer.TimerTextDoa;

public class TimerSujud2 extends TimerTextDoa{

	public TimerSujud2(TimerListener listener) {
		super(listener);
	}

	@Override
	public void buildSurat() {
		surat.add(new Integer[]{R.drawable.duduk_antara2_sujud_1, R.drawable.duduk_antara2_sujud_1_arti});
		surat.add(new Integer[]{R.drawable.duduk_antara2_sujud_2, R.drawable.duduk_antara2_sujud_2_arti});
	}

	@Override
	public int getJumlahSub() {
		return 2;
	}

	@Override
	public int getPeriod() {
		return 12000;
	}

}
