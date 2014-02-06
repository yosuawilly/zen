package com.belajar.shalat.timer.doa;

import com.belajar.shalat.R;
import com.belajar.shalat.timer.TimerListener;
import com.belajar.shalat.timer.TimerTextDoa;

public class TimerTakbir extends TimerTextDoa{

	public TimerTakbir(TimerListener listener) {
		super(listener);
	}

	@Override
	public void buildSurat() {
		surat.add(new Integer[]{R.drawable.takbir_iktidal, R.drawable.takbir_iktidal_arti});
	}

	@Override
	public int getJumlahSub() {
		return 1;
	}

	@Override
	public int getPeriod() {
		return 4000;
	}

}
