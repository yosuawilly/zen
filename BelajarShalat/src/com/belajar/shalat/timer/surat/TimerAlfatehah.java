package com.belajar.shalat.timer.surat;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.os.CountDownTimer;

import com.belajar.shalat.R;
import com.belajar.shalat.timer.TimerListener;
import com.belajar.shalat.timer.TimerSubTitle;

public class TimerAlfatehah implements TimerSubTitle{
	
	private boolean isTimerRunning = false;
	protected int jumlahSub = 7;
	private long delay, period;
	private TimerListener listener;
	private Timer timer;
	private List<Integer[]> surat;
	private int idx = 0;
	private CountDownTimer downTimer;
	
	public TimerAlfatehah(TimerListener listener) {
		this.listener = listener;
		this.period = 39000;
		this.delay = this.period / jumlahSub;
		this.surat = new ArrayList<Integer[]>();
		
		buildSurat();
	}

	@Override
	public void start() {
//		timer = new Timer(delay, period) {
//			
//			@Override
//			protected void onTick() {
//				if(idx==TimerAlfatehah.this.jumlahSub) {
//					TimerAlfatehah.this.stop();
//					return;
//				}
//				
//				Integer[]idxSurat = surat.get(idx);
//				listener.updateText(idxSurat[0], idxSurat[1]);
//				idx++;
//			}
//			
//			@Override
//			protected void onFinish() {
//				// TODO Auto-generated method stub
//				
//			}
//		};
		
		downTimer = new CountDownTimer(period, delay) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				if(idx==TimerAlfatehah.this.jumlahSub) {
					TimerAlfatehah.this.stop();
					return;
				}
				
				Integer[]idxSurat = surat.get(idx);
				listener.updateText(idxSurat[0], idxSurat[1]);
				idx++;
			}
			
			@Override
			public void onFinish() {
				listener.updateText(0, 0);
				idx = 0;
		        isTimerRunning = false;
			}
		}.start();
		
//		timer = new Timer();
//		timer.schedule(new TimerTask() {
//			
//			@Override
//			public void run() {
//				if(idx==TimerAlfatehah.this.jumlahSub) {
//					TimerAlfatehah.this.stop();
//					return;
//				}
//				
//				Integer[]idxSurat = surat.get(idx);
//				listener.updateText(idxSurat[0], idxSurat[1]);
//				idx++;
//			}
//		}, delay, period);
		
		//Show first text
		Integer[]idxSurat = surat.get(idx);
		listener.updateText(idxSurat[0], idxSurat[1]);
		idx++;
		
		isTimerRunning = true;
	}

	@Override
	public void stop() {
//		timer.cancel();
		downTimer.cancel();
		idx = 0;
        isTimerRunning = false;
	}
	
	@Override
	public boolean isTimerRunning() {
		return isTimerRunning;
	}

	@Override
	public void buildSurat() {
		surat.add(new Integer[]{R.drawable.alfatehah_0, R.drawable.alfatehah_0_arti});
		surat.add(new Integer[]{R.drawable.alfatehah_1, R.drawable.alfatehah_1_arti});
		surat.add(new Integer[]{R.drawable.alfatehah_2, R.drawable.alfatehah_2_arti});
		surat.add(new Integer[]{R.drawable.alfatehah_3, R.drawable.alfatehah_3_arti});
		surat.add(new Integer[]{R.drawable.alfatehah_4, R.drawable.alfatehah_4_arti});
		surat.add(new Integer[]{R.drawable.alfatehah_5, R.drawable.alfatehah_5_arti});
		surat.add(new Integer[]{R.drawable.alfatehah_6, R.drawable.alfatehah_6_arti});
	}

	@Override
	public void pause() {
//		timer.pause();
//		isTimerRunning = false;
	}

	@Override
	public void resume() {
//		timer.resume();
//		isTimerRunning = true;
	}

}
