package com.example.service;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PopupView extends LinearLayout {
	private TextView tv,tl;
	private Button btn_dismiss;
	private Button btn_open;
	private WindowManager wm; 

	public PopupView(Context context, String str, WindowManager wmr) {
		super(context);
		wm = wmr;
		this.setOrientation(1);
		this.setBackgroundResource(R.color.nav_drawer_background);
		this.setPadding(10, 10, 10, 10);
		
		tl = new TextView(context);
		tl.setText("Carethy");
		tl.setTextSize(36);
		tl.setTextColor(getResources().getColor(R.color.actionbar_background));
		tl.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);
		tl.setGravity(Gravity.LEFT);
		this.addView(tl);
		
		View sp = new View(context);
		sp.setBackgroundResource(R.color.actionbar_background);
		sp.setLayoutParams(new LinearLayout.LayoutParams(-1, 5));
		this.addView(sp);
		
		tv = new TextView(context);
		tv.setText(str);
		tv.setTextSize(18);
		tv.setTextColor(getResources().getColor(R.color.actionbar_background));
		tv.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);
		tv.setPadding(10, 10, 10, 10);
		this.addView(tv);

		LinearLayout lly = new LinearLayout(context);
		lly.setOrientation(0);
		
		btn_dismiss = new Button(context);
		btn_dismiss.setText("Dismiss");
		btn_dismiss.setOnClickListener(new OnClickListener(){
	        @Override 
	        public void onClick(View v)  {
	        	removePopup();
	        }
		});
		btn_dismiss.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, (float) 1.0));
		btn_dismiss.getBackground().setColorFilter(getResources().getColor(R.color.button), PorterDuff.Mode.MULTIPLY);
		lly.addView(btn_dismiss);
		
		btn_open = new Button(context);
		btn_open.setText("Open");
		btn_open.setOnClickListener(new OnClickListener(){
	        @Override 
	        public void onClick(View v)  {
	        	removePopup();
	        	Intent intent = new Intent(v.getContext(), MainActivity.class);
	        	intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        	v.getContext().startActivity(intent);
	        }
		});
		btn_open.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, (float) 1.0));
		btn_open.getBackground().setColorFilter(getResources().getColor(R.color.button), PorterDuff.Mode.MULTIPLY);
		
		lly.addView(btn_open);
		
		this.addView(lly);

	}

	public void removePopup() {
		wm.removeView(this);
	}
}
