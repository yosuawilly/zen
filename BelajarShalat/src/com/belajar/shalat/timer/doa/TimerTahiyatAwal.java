package com.belajar.shalat.timer.doa;

import com.belajar.shalat.R;
import com.belajar.shalat.timer.TimerListener;
import com.belajar.shalat.timer.TimerTextDoa;

public class TimerTahiyatAwal extends TimerTextDoa{

	public TimerTahiyatAwal(TimerListener listener) {
		super(listener);
	}

	@Override
	public void buildSurat() {
		surat.add(new Integer[]{R.drawable.tahiyat_awal_1, R.drawable.tahiyat_awal_1_arti});
		surat.add(new Integer[]{R.drawable.tahiyat_awal_2, R.drawable.tahiyat_awal_2_arti});
		surat.add(new Integer[]{R.drawable.tahiyat_awal_3, R.drawable.tahiyat_awal_3_arti});
		surat.add(new Integer[]{R.drawable.tahiyat_awal_4, R.drawable.tahiyat_awal_4_arti});
		surat.add(new Integer[]{R.drawable.tahiyat_awal_5, R.drawable.tahiyat_awal_5_arti});
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
