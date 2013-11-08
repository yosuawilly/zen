package com.belajar.shalat.activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;
import com.belajar.shalat.R;
import com.belajar.shalat.activity.base.BaseMainActivity;
import com.belajar.shalat.util.Constant;

public class FullVideoActivity extends BaseMainActivity implements OnCompletionListener{
	VideoView videoView;
	Button btnPlayPause, btnStop;
	String typeShalat;
	List<String> stepShalat;
//	Uri uriVideo;
	boolean pause = false;
	int currentId = 0;
	
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
		txtTitle.setText(Constant.getTitle(typeShalat));
		
		stepShalat = new ArrayList<String>();
		if(typeShalat.equals(Constant.SUBUH)){
			stepShalat.addAll(Arrays.asList(getResources().getStringArray(R.array.sholat_subuh)));
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
			break;
		case R.id.play_pause_button:
			if(pause) {
				videoView.start();
				pause = false;
			}
			else if(!videoView.isPlaying()){
				videoView.setVideoURI(getUriVideo(stepShalat.get(currentId)));
				videoView.start();
			}else {
				videoView.pause();
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
		videoView.start();
	}
	
	public Uri getUriVideo(String step){
		Uri uri = null;
		if(step.contains("Niat Shalat Subuh")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.niat_subuh);
		} else if(step.contains("Niat Shalat Dzuhur")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.niat_duhur);
		} else if(step.contains("Niat Shalat Ashar")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.niat_ashar);
		} else if(step.contains("Niat Shalat Maghrib")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.niat_maghrib);
		} else if(step.contains("Niat Shalat Isya")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.niat_isya);
		}
		else if(step.contains("Takbiratul Ihram")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.takbirotulikhrom);
		} else if(step.contains("Iftitah")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.doa_iftitah);
		} else if(step.contains("Al Fatihah")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.alfatihah);
		} else if(step.contains("Surat")){
			if(typeShalat.equalsIgnoreCase(Constant.SUBUH)){
				if(currentId==4){
					uri = Uri.parse(Constant.BASE_PATH+R.raw.surat_al_maa_uun);
				} else uri = Uri.parse(Constant.BASE_PATH+R.raw.surat_al_kautsar);
			} else if(typeShalat.equalsIgnoreCase(Constant.DZUHUR)){
				if(currentId==4){
					uri = Uri.parse(Constant.BASE_PATH+R.raw.surat_al_kaafirun);
				} else uri = Uri.parse(Constant.BASE_PATH+R.raw.surat_an_nasr);
			} else if(typeShalat.equalsIgnoreCase(Constant.ASHAR)){
				if(currentId==4){
					uri = Uri.parse(Constant.BASE_PATH+R.raw.surat_al_massad);
				} else uri = Uri.parse(Constant.BASE_PATH+R.raw.surat_qarisy);
			} else if(typeShalat.equalsIgnoreCase(Constant.MAGHRIB)){
				if(currentId==4){
					uri = Uri.parse(Constant.BASE_PATH+R.raw.surat_al_humaza);
				} else uri = Uri.parse(Constant.BASE_PATH+R.raw.surat_al_ikhlas);
			} else if(typeShalat.equalsIgnoreCase(Constant.ISYA)){
				if(currentId==4){
					uri = Uri.parse(Constant.BASE_PATH+R.raw.surat_al_fill);
				} else uri = Uri.parse(Constant.BASE_PATH+R.raw.surat_at_takaathur);
			}
		} else if(step.contains("Ruku")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.ruku);
		} else if(step.contains("I'tidal")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.itidal);
		} else if(step.equals("Qunut")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.qunut);
		} else if(step.equals("Sujud")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.sujud);
		} else if(step.contains("Duduk Antara Dua Sujud")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.duduk_antara_sujud);
		} else if(step.equals("Sujud2")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.sujud2);
		} else if(step.contains("Berdiri Setelah Sujud")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.berdiri_setelah_sujud);
		} else if(step.equals("Tahiyat Awal")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.tahiyat_awal);
		} else if(step.equals("Tahiyat Akhir")){
			uri = Uri.parse(Constant.BASE_PATH+R.raw.tahiyat_akhir);
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

}
