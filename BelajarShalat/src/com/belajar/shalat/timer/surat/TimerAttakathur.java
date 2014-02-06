package com.belajar.shalat.timer.surat;

import com.belajar.shalat.R;
import com.belajar.shalat.timer.TimerListener;
import com.belajar.shalat.timer.TimerTextDoa;

public class TimerAttakathur extends TimerTextDoa{

	public TimerAttakathur(TimerListener listener) {
		super(listener);
	}

	@Override
	public void buildSurat() {
		surat.add(new Integer[]{R.drawable.attakatsur_1, R.drawable.attakatsur_1_arti});
		surat.add(new Integer[]{R.drawable.attakatsur_2, R.drawable.attakatsur_2_arti});
		surat.add(new Integer[]{R.drawable.attakatsur_3, R.drawable.attakatsur_3_arti});
		surat.add(new Integer[]{R.drawable.attakatsur_4, R.drawable.attakatsur_4_arti});
		surat.add(new Integer[]{R.drawable.attakatsur_5, R.drawable.attakatsur_5_arti});
		surat.add(new Integer[]{R.drawable.attakatsur_6, R.drawable.attakatsur_6_arti});
		surat.add(new Integer[]{R.drawable.attakatsur_7, R.drawable.attakatsur_7_arti});
		surat.add(new Integer[]{R.drawable.attakatsur_8, R.drawable.attakatsur_8_arti});
	}

	@Override
	public int getJumlahSub() {
		return 8;
	}

	@Override
	public int getPeriod() {
		return 38000;
	}

}
