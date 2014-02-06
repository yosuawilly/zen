package com.belajar.shalat.timer.surat;

import com.belajar.shalat.R;
import com.belajar.shalat.timer.TimerListener;
import com.belajar.shalat.timer.TimerTextDoa;

public class TimerAlIkhlas extends TimerTextDoa{

	public TimerAlIkhlas(TimerListener listener) {
		super(listener);
	}

	@Override
	public void buildSurat() {
		surat.add(new Integer[]{R.drawable.ikhlas_0, R.drawable.ikhlas_0_arti});
		surat.add(new Integer[]{R.drawable.ikhlas_1, R.drawable.ikhlas_1_arti});
		surat.add(new Integer[]{R.drawable.ikhlas_2, R.drawable.ikhlas_2_arti});
		surat.add(new Integer[]{R.drawable.ikhlas_3, R.drawable.ikhlas_3_arti});
	}

	@Override
	public int getJumlahSub() {
		return 4;
	}

	@Override
	public int getPeriod() {
		return 13000;
	}

}
