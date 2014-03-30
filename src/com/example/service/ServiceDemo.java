package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class ServiceDemo extends Service {
	private static final String TAG = "Test";
	private PopupWindow pw;

	@Override
	public void onCreate() {
		Log.i(TAG, "Service onCreate--->");
		super.onCreate();
		pw = new PopupWindow(getApplicationContext());
		try {
			Thread.sleep(3000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void onStart(Intent intent, int startId) {
		Log.i(TAG, "Service onStart--->");
		// super.onStart(intent, startId);
		pw.showPopup("This is your recommendation! This is your recommendation! This is your recommendation! This is your recommendation! This is your recommendation! ");

	}

	@Override
	public void onDestroy() {
		Log.i(TAG, "Service onDestroy--->");
		// super.onDestroy();
		pw.removePopup();
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

}
