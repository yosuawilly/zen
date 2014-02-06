package com.belajar.shalat.timer.doa;

import com.belajar.shalat.R;
import com.belajar.shalat.timer.TimerListener;
import com.belajar.shalat.timer.TimerTextDoa;

public class TimerQunut extends TimerTextDoa{

	public TimerQunut(TimerListener listener) {
		super(listener);
	}

	@Override
	public void buildSurat() {
		surat.add(new Integer[]{R.drawable.qunut_1, R.drawable.arti_qunut1});
		surat.add(new Integer[]{R.drawable.qunut_2, R.drawable.arti_qunut2});
		surat.add(new Integer[]{R.drawable.qunut_3, R.drawable.arti_qunut3});
		surat.add(new Integer[]{R.drawable.qunut_4, R.drawable.arti_qunut4});
		surat.add(new Integer[]{R.drawable.qunut_5, R.drawable.arti_qunut5});
		surat.add(new Integer[]{R.drawable.qunut_6, R.drawable.arti_qunut6});
		surat.add(new Integer[]{R.drawable.qunut_7, R.drawable.arti_qunut7});
		surat.add(new Integer[]{R.drawable.qunut_8, R.drawable.arti_qunut8});
		surat.add(new Integer[]{R.drawable.qunut_9, R.drawable.arti_qunut9});
		surat.add(new Integer[]{R.drawable.qunut_10, R.drawable.arti_qunut10});
		surat.add(new Integer[]{R.drawable.qunut_11, R.drawable.arti_qunut11});
	}

	@Override
	public int getJumlahSub() {
		return 11;
	}

	@Override
	public int getPeriod() {
		return 43000;
	}

}
