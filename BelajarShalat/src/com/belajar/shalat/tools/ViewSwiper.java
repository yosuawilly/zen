package com.belajar.shalat.tools;

import java.util.ArrayList;
import java.util.List;
import com.belajar.shalat.R;
import com.belajar.shalat.util.Constant;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class ViewSwiper extends Fragment implements OnClickListener, OnCompletionListener{
	
	Context context;
	ViewGroup viewLayout;
	ViewClickListener<Object> viewListener;
	int pageNumber;
	public final String POCKET_PAGE = "page";
	public final String STEP_LIST = "steplist";
	public final String TYPE_SHALAT = "typeshalat";
	List<String> stepShalat;
	String typeShalat;
	
	VideoView videoView;
	Uri uriVideo;
	boolean pause = false;
	//int currentPositionPlay = 0;
	
	Button btnPlayPause, btnStop;
	
	public ViewSwiper(Context context, ViewClickListener<Object> viewListener) {
		this.context = context;
		this.viewListener = viewListener;
	}
	
	public ViewSwiper create(int pageNumber, List<String> stepShalat, String typeShalat){
		Bundle data = new Bundle();
		data.putInt(POCKET_PAGE, pageNumber);
		data.putStringArrayList(STEP_LIST, (ArrayList<String>)stepShalat);
		data.putString(TYPE_SHALAT, typeShalat);
		ViewSwiper swiper = new ViewSwiper(context, viewListener);
		swiper.setArguments(data);
		return swiper;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.pageNumber = getArguments().getInt(POCKET_PAGE);
		this.stepShalat = getArguments().getStringArrayList(STEP_LIST);
		this.typeShalat = getArguments().getString(TYPE_SHALAT);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
		viewLayout = (ViewGroup) inflater.inflate(R.layout.tutor_layout, container, false);
		
		btnPlayPause = (Button) viewLayout.findViewById(R.id.play_pause_button);
		btnStop = (Button) viewLayout.findViewById(R.id.stop_button);
		videoView = (VideoView) viewLayout.findViewById(R.id.video_view);
//		uriVideo = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.take);
		uriVideo = getUriVideo(stepShalat.get(pageNumber));
		videoView.setOnCompletionListener(this);
		
		TextView titleView = (TextView) viewLayout.findViewById(R.id.titleView);
		
		titleView.setText(stepShalat.get(pageNumber));
		
		btnPlayPause.setOnClickListener(this);
		btnStop.setOnClickListener(this);
		return viewLayout;
	}
	
	public Uri getUriVideo(String step){
		Uri uri = null;
		if(step.contains("Niat Shalat Subuh")){
			uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.niat_subuh);
		} else if(step.contains("Niat Shalat Dzuhur")){
			uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.niat_duhur);
		} else if(step.contains("Niat Shalat Ashar")){
			uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.niat_ashar);
		} else if(step.contains("Niat Shalat Maghrib")){
			uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.niat_maghrib);
		} else if(step.contains("Niat Shalat Isya")){
			uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.niat_isya);
		}
		else if(step.contains("Takbiratul Ihram")){
			uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.takbirotulikhrom);
		} else if(step.contains("Iftitah")){
			uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.doa_iftitah);
		} else if(step.contains("Al Fatihah")){
			uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.alfatihah);
		} else if(step.contains("Surat")){
			if(typeShalat.equalsIgnoreCase(Constant.SUBUH)){
				if(pageNumber==4){
					uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.surat_al_maa_uun);
				} else uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.surat_al_kautsar);
			} else if(typeShalat.equalsIgnoreCase(Constant.DZUHUR)){
				if(pageNumber==4){
					uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.surat_al_kaafirun);
				} else uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.surat_an_nasr);
			} else if(typeShalat.equalsIgnoreCase(Constant.ASHAR)){
				if(pageNumber==4){
					uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.surat_al_massad);
				} else uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.surat_qarisy);
			} else if(typeShalat.equalsIgnoreCase(Constant.MAGHRIB)){
				if(pageNumber==4){
					uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.surat_al_humaza);
				} else uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.surat_al_ikhlas);
			} else if(typeShalat.equalsIgnoreCase(Constant.ISYA)){
				if(pageNumber==4){
					uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.surat_al_fill);
				} else uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.surat_at_takaathur);
			}
//			uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.surat_al_massad);
		} else if(step.contains("Ruku")){
			uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.ruku);
		} else if(step.contains("I'tidal")){
			uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.itidal);
		} else if(step.equals("Qunut")){
			uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.qunut);
		} else if(step.equals("Sujud")){
			uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.sujud);
		} else if(step.contains("Duduk Antara Dua Sujud")){
			uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.duduk_antara_sujud);
		} else if(step.equals("Sujud2")){
			uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.sujud2);
		} else if(step.contains("Berdiri Setelah Sujud")){
			uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.berdiri_setelah_sujud);
		} else if(step.equals("Tahiyat Awal")){
			uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.tahiyat_awal);
		} else if(step.equals("Tahiyat Akhir")){
			uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.tahiyat_akhir);
		} else if(step.contains("Berdiri Setelah Tahiyat")){
			uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.berdiri_setelah_tahiyat);
		} else if(step.equals("Salam")){
			uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.salam);
		}
		else {
			uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.doa);
		}
		return uri;
	}
	
	public void stopVideo(){
		if(videoView.isPlaying()){
			videoView.stopPlayback();
			videoView.setVideoURI(uriVideo);
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.play_pause_button:
			if(pause) {
				videoView.start();
				pause = false;
			}
			//videoView.setMediaController(new MediaController(context));
			else if(!videoView.isPlaying()){
				videoView.setVideoURI(uriVideo);
				videoView.start();
			}else {
				videoView.pause();
				pause = true;
			}
//			viewListener.onViewClick("Play", stepShalat.get(pageNumber));
			break;
		case R.id.stop_button:
			if(videoView.isPlaying()){
				videoView.stopPlayback();
				videoView.setVideoURI(uriVideo);
//				videoView.suspend();
				//videoView.seekTo(0);
			}
//			viewListener.onViewClick("Stop", stepShalat.get(pageNumber));
			break;
		default:
			break;
		}
	}

	@Override
	public void onCompletion(MediaPlayer arg0) {
//		Toast.makeText(context, "finish", Toast.LENGTH_LONG).show();
	}

}
