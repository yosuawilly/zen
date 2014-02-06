package com.belajar.shalat.timer;

import java.util.ArrayList;
import java.util.List;

import android.os.CountDownTimer;

public abstract class TimerTextDoa implements TimerSubTitle {
	
	protected boolean isTimerRunning = false;
	protected int jumlahSub;
	protected long delay, period;
	protected TimerListener listener;
	protected List<Integer[]> surat;
	protected int idx = 0;
	protected CountDownTimer downTimer;
	
	public TimerTextDoa(TimerListener listener) {
		this.listener = listener;
		this.jumlahSub = getJumlahSub();
		this.period = getPeriod();
		this.delay = this.period / jumlahSub;
		this.surat = new ArrayList<Integer[]>();
		
		buildSurat();
	}
	
	@Override
	public void start() {
		downTimer = new CountDownTimer(period, delay) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				if(idx==TimerTextDoa.this.jumlahSub) {
					TimerTextDoa.this.stop();
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
		
		//Show first text
		Integer[]idxSurat = surat.get(idx);
		listener.updateText(idxSurat[0], idxSurat[1]);
		idx++;
		
		isTimerRunning = true;
	}
	@Override
	public void stop() {
		downTimer.cancel();
		idx = 0;
        isTimerRunning = false;
	}
	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isTimerRunning() {
		return isTimerRunning;
	}
	public abstract int getJumlahSub();
	public abstract int getPeriod();

}
