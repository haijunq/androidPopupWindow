package com.example.service;

import android.content.Context;
import android.os.Vibrator;
import android.view.WindowManager;

public class PopupWindow {
	private Context context;
	private WindowManager wm;
	private PopupView pv;

	public PopupWindow(Context context) {
		this.context = context;
	}

	public void showPopup(String str) {
		wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		WindowManager.LayoutParams params = new WindowManager.LayoutParams();
		params.type = WindowManager.LayoutParams.TYPE_PHONE;
		params.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON|
	            WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD|
	            WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED|
	            WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON|
	            WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH|
				WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
		params.width = WindowManager.LayoutParams.WRAP_CONTENT;
		params.height = WindowManager.LayoutParams.WRAP_CONTENT;
		
		pv = new PopupView(context, str, wm);

		wm.addView(pv, params); 
		
		//vibrate 500 ms
		Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
		v.vibrate(500);
	}

	public void removePopup() {
		if (wm != null && pv != null) {
			wm.removeView(pv);
		}
	}
}
