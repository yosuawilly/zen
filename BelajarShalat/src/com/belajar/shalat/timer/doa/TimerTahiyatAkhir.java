package com.belajar.shalat.timer.doa;

import com.belajar.shalat.R;
import com.belajar.shalat.timer.TimerListener;
import com.belajar.shalat.timer.TimerTextDoa;

public class TimerTahiyatAkhir extends TimerTextDoa{

	public TimerTahiyatAkhir(TimerListener listener) {
		super(listener);
	}

	@Override
	public void buildSurat() {
		surat.add(new Integer[]{R.drawable.tahiyat_akhir1, R.drawable.arti_tahiyat_akhir_1});
		surat.add(new Integer[]{R.drawable.tahiyat_akhir2, R.drawable.arti_tahiyat_akhir_2});
		surat.add(new Integer[]{R.drawable.tahiyat_akhir3, R.drawable.arti_tahiyat_akhir_3});
		surat.add(new Integer[]{R.drawable.tahiyat_akhir4, R.drawable.arti_tahiyat_akhir_4});
		surat.add(new Integer[]{R.drawable.tahiyat_akhir5, R.drawable.arti_tahiyat_akhir_5});
		surat.add(new Integer[]{R.drawable.tahiyat_akhir6, R.drawable.arti_tahiyat_akhir_6});
		surat.add(new Integer[]{R.drawable.tahiyat_akhir7, R.drawable.arti_tahiyat_akhir_7});
		surat.add(new Integer[]{R.drawable.tahiyat_akhir8, R.drawable.arti_tahiyat_akhir_8});
		surat.add(new Integer[]{R.drawable.tahiyat_akhir9, R.drawable.arti_tahiyat_akhir_9});
	}

	@Override
	public int getJumlahSub() {
		return 9;
	}

	@Override
	public int getPeriod() {
		return 48000;
	}

}
