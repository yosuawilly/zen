package com.belajar.shalat.activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;
import com.belajar.shalat.R;
import com.belajar.shalat.activity.base.BaseMainActivity;
import com.belajar.shalat.timer.TimerListener;
import com.belajar.shalat.timer.TimerSubTitle;
import com.belajar.shalat.timer.doa.TimerIftitah;
import com.belajar.shalat.timer.doa.TimerIktidal;
import com.belajar.shalat.timer.doa.TimerNiatAshar;
import com.belajar.shalat.timer.doa.TimerNiatIsya;
import com.belajar.shalat.timer.doa.TimerNiatMaghrib;
import com.belajar.shalat.timer.doa.TimerNiatSubuh;
import com.belajar.shalat.timer.doa.TimerNiatZuhur;
import com.belajar.shalat.timer.doa.TimerQunut;
import com.belajar.shalat.timer.doa.TimerRukuk;
import com.belajar.shalat.timer.doa.TimerSujud;
import com.belajar.shalat.timer.doa.TimerSujud2;
import com.belajar.shalat.timer.doa.TimerTahiyatAkhir;
import com.belajar.shalat.timer.doa.TimerTahiyatAwal;
import com.belajar.shalat.timer.doa.TimerTakbir;
import com.belajar.shalat.timer.surat.TimerAlFill;
import com.belajar.shalat.timer.surat.TimerAlHumaza;
import com.belajar.shalat.timer.surat.TimerAlIkhlas;
import com.belajar.shalat.timer.surat.TimerAlKafirun;
import com.belajar.shalat.timer.surat.TimerAlKautsar;
import com.belajar.shalat.timer.surat.TimerAlMaauun;
import com.belajar.shalat.timer.surat.TimerAlMassadd;
import com.belajar.shalat.timer.surat.TimerAlfatehah;
import com.belajar.shalat.timer.surat.TimerAnnass;
import com.belajar.shalat.timer.surat.TimerAttakathur;
import com.belajar.shalat.timer.surat.TimerQarisy;
import com.belajar.shalat.util.Constant;

public class FullVideoActivity extends BaseMainActivity implements OnCompletionListener, TimerListener{
	VideoView videoView;
	Button btnPlayPause, btnStop;
	String typeShalat;
	List<String> stepShalat;
//	Uri uriVideo;
	boolean pause = false;
	int currentId = 0;
	boolean useQunut = true;
	
	public TimerSubTitle timerSubTitle;
	public ImageView imageTextTop, imageTextBottom;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void initDesignComponents() {
		super.initDesignComponents();
		View v = viewInflater.inflate(R.layout.full_video_layout, null);
		mainBody.addView(v);
		nextButton.setVisibility(Button.GONE);
		subTitle.setText("Full Video");
		
		typeShalat = getIntent().getStringExtra("type");
		useQunut = getIntent().getBooleanExtra("useQunut", true);
		txtTitle.setText(Constant.getTitle(typeShalat));
		
		stepShalat = new ArrayList<String>();
		if(typeShalat.equals(Constant.SUBUH)){
			if(useQunut)
			stepShalat.addAll(Arrays.asList(getResources().getStringArray(R.array.sholat_subuh)));
			else 
			stepShalat.addAll(Arrays.asList(getResources().getStringArray(R.array.sholat_subuh_tanpa_qunut)));
		} else if(typeShalat.equals(Constant.DZUHUR)){
			stepShalat.addAll(Arrays.asList(getResources().getStringArray(R.array.sholat_dzuhur)));
		} else if(typeShalat.equals(Constant.ASHAR)){
			stepShalat.addAll(Arrays.asList(getResources().getStringArray(R.array.sholat_ashar)));
		} else if(typeShalat.equals(Constant.MAGHRIB)){
			stepShalat.addAll(Arrays.asList(getResources().getStringArray(R.array.sholat_maghrib)));
		} else if(typeShalat.equals(Constant.ISYA)){
			stepShalat.addAll(Arrays.asList(getResources().getStringArray(R.array.sholat_isya)));
		}
		
		videoView = (VideoView) findViewById(R.id.video_view);
		btnPlayPause = (Button) findViewById(R.id.play_pause_button);
		btnStop = (Button) findViewById(R.id.stop_button);
		
		imageTextTop = (ImageView) findViewById(R.id.image_text_top);
		imageTextBottom = (ImageView) findViewById(R.id.image_text_bottom);
		
//		uriVideo = Uri.parse("android.resource://com.belajar.shalat/raw/niat_subuh");
		videoView.setOnCompletionListener(this);
	}
	
	@Override
	public void configureFunctionComponents() {
		super.configureFunctionComponents();
		btnPlayPause.setOnClickListener(this);
		btnStop.setOnClickListener(this);
	}
	
	public void stopVideo(){
		if(videoView.isPlaying()){
			videoView.stopPlayback();
			currentId = 0;
			videoView.setVideoURI(getUriVideo(stepShalat.get(currentId)));
		}
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.backButton:
			super.onClick(v);
		case R.id.stop_button:
			stopVideo();
			if(timerSubTitle!=null) timerSubTitle.stop();
			break;
		case R.id.play_pause_button:
			if(pause) {
				videoView.start();
				if(timerSubTitle!=null) timerSubTitle.resume();
				pause = false;
			}
			else if(!videoView.isPlaying()){
				videoView.setVideoURI(getUriVideo(stepShalat.get(currentId)));
				videoView.start();
				if(timerSubTitle!=null) timerSubTitle.start();
			}else {
				videoView.pause();
				if(timerSubTitle!=null) timerSubTitle.pause();
				pause = true;
			}
			break;
		default:
			break;
		}
	}

	@Override
	public void onCompletion(MediaPlayer arg0) {
		currentId++;
		if(currentId==stepShalat.size()){
			currentId=0;
			return;
		}
		videoView.setVideoURI(getUriVideo(stepShalat.get(currentId)));
		if(timerSubTitle!=null) timerSubTitle.start();
		videoView.start();
	}
	
	public Uri getUriVideo(String step){
		Uri uri = null;
		if(step.contains("Niat Shalat Subuh")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.niat_subuh);
			timerSubTitle = new TimerNiatSubuh(this);
		} else if(step.contains("Niat Shalat Dzuhur")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.niat_duhur);
			timerSubTitle = new TimerNiatZuhur(this);
		} else if(step.contains("Niat Shalat Ashar")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.niat_ashar);
			timerSubTitle = new TimerNiatAshar(this);
		} else if(step.contains("Niat Shalat Maghrib")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.niat_maghrib);
			timerSubTitle = new TimerNiatMaghrib(this);
		} else if(step.contains("Niat Shalat Isya")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.niat_isya);
			timerSubTitle = new TimerNiatIsya(this);
		}
		else if(step.contains("Takbiratul Ihram")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.takbirotulikhrom);
			timerSubTitle = new TimerTakbir(this);
		} else if(step.contains("Iftitah")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.doa_iftitah);
			timerSubTitle = new TimerIftitah(this);
		} else if(step.contains("Al Fatihah")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.alfatihah);
			timerSubTitle = new TimerAlfatehah(this);
		} else if(step.contains("Surat")){
			uri = getRandomSuratUri();
			
		} else if(step.contains("Ruku")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.ruku);
			timerSubTitle = new TimerRukuk(this);
		} else if(step.contains("I'tidal")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.itidal);
			timerSubTitle = new TimerIktidal(this);
		} else if(step.equals("Qunut")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.qunut);
			timerSubTitle = new TimerQunut(this);
		} else if(step.equals("Sujud")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.sujud);
			timerSubTitle = new TimerSujud(this);
		} else if(step.contains("Duduk Antara Dua Sujud")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.duduk_antara_sujud);
			timerSubTitle = new TimerSujud2(this);
		} else if(step.equals("Sujud2")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.sujud2);
			timerSubTitle = new TimerSujud(this);
		} else if(step.contains("Berdiri Setelah Sujud")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.berdiri_setelah_sujud);
		} else if(step.equals("Tahiyat Awal")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.tahiyat_awal);
			timerSubTitle = new TimerTahiyatAwal(this);
		} else if(step.equals("Tahiyat Akhir")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.tahiyat_akhir);
			timerSubTitle = new TimerTahiyatAkhir(this);
		} else if(step.contains("Berdiri Setelah Tahiyat")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.berdiri_setelah_tahiyat);
		} else if(step.equals("Salam")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.salam);
		}
		else {
			uri = Uri.parse(Constant.BASE_PATH+R.raw.doa);
		}
		return uri;
	}
	
	private Uri getRandomSuratUri(){
		int min = 0, max = Constant.BACAAN_SURAT.length - 1;
		int randomIdx = new Random().nextInt((max - min) + 1) + min;
		Uri uri = Uri.parse(Constant.BASE_PATH + Constant.BACAAN_SURAT[randomIdx]);
		
		switch (Constant.BACAAN_SURAT[randomIdx]) {
		case R.raw.surat_an_nasr:
			timerSubTitle = new TimerAnnass(this);
			break;
		case R.raw.surat_al_ikhlas:
			timerSubTitle = new TimerAlIkhlas(this);
			break;
		case R.raw.surat_al_fill:
			timerSubTitle = new TimerAlFill(this);
			break;
		case R.raw.surat_al_humaza:
			timerSubTitle = new TimerAlHumaza(this);
			break;
		case R.raw.surat_al_kaafirun:
			timerSubTitle = new TimerAlKafirun(this);
			break;
		case R.raw.surat_al_kautsar:
			timerSubTitle = new TimerAlKautsar(this);
			break;
		case R.raw.surat_al_maa_uun:
			timerSubTitle = new TimerAlMaauun(this);
			break;
		case R.raw.surat_al_massad:
			timerSubTitle = new TimerAlMassadd(this);
			break;
		case R.raw.surat_at_takaathur:
			timerSubTitle = new TimerAttakathur(this);
			break;
		case R.raw.surat_qarisy:
			timerSubTitle = new TimerQarisy(this);
			break;
		default:
			break;
		}
		
		return uri;
	}

	@Override
	public void updateText(final int idImageTop, final int idImageBottom) {
        this.runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				imageTextTop.setImageResource(idImageTop);
				imageTextBottom.setImageResource(idImageBottom);
			}
		});
	}

}
