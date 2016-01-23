package com.herotculb.qunhaichat.widget;

import java.util.Calendar;
import java.util.Date;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.DatePicker;
import android.widget.EditText;

import com.herotculb.qunhaichat.R;
/**
 * @2014-12-09 10:58:24
 * @author lxg
 *
 */
public class EditTextWithDate extends EditText {
	 private final static String TAG = "EditTextWithDate"; 
	 private Drawable dateIcon;  
     private Context mContext; 
 	 private Calendar c;
 	 private int mYear;
 	 private int mMonth;
 	 private int mDay;
 	 private boolean datePickerEnabled=true;
 	 
	public EditTextWithDate(Context context) {
		super(context);
		mContext=context;
		init();
	}
	
	public EditTextWithDate(Context context,AttributeSet attrs) {
		super(context,attrs);
		mContext=context;
		init();
	}

	public EditTextWithDate(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mContext = context;
		init();
	}
	 private void init() {
		 dateIcon=mContext.getResources().getDrawable(R.drawable.date);  
		 dateIcon.setBounds(-11, 0, 70, 70);
		 setCompoundDrawables(null, null, dateIcon, null);
//		  setCompoundDrawablesWithIntrinsicBounds(null, null, dateIcon, null);
		    c = Calendar.getInstance();
			final Calendar cal =Calendar.getInstance(); 
			mYear = cal.get(Calendar.YEAR); // 获取当前年份
			mMonth = cal.get(Calendar.MONTH);// 获取当前月份 
			mDay = cal.get(Calendar.DAY_OF_MONTH);// 获取当前月份的日期号码 
			this.setText(mYear+"-"+mMonth+"-"+mDay);
			this.setEnabled(false);
	 }

	 @Override  
	 public boolean onTouchEvent(MotionEvent event) {  
	     if (dateIcon != null && event.getAction() == MotionEvent.ACTION_UP) {  
	           int eventX = (int) event.getRawX();  
	           int eventY = (int) event.getRawY();  
	            Log.e(TAG, "eventX = " + eventX + "; eventY = " + eventY);  
               Rect rect = new Rect();  
	           getGlobalVisibleRect(rect);  
	            rect.left = rect.right - 81;  
	           if(rect.contains(eventX, eventY)){
	        	   if(datePickerEnabled){
	        	   new DatePickerDialog(mContext, new DatePickerDialog.OnDateSetListener() {

						public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
							mYear = year;
							mMonth = monthOfYear;
							mDay = dayOfMonth;
							setText(new StringBuilder().append("").append(mYear).append("-").append(mMonth + 1).append("-").append(mDay).append(""));

						}

					}, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
	        	   }
	           }
	       }  
	       return super.onTouchEvent(event);  
	    }

	public boolean isDatePickerEnabled() {
		return datePickerEnabled;
	}

	public void setDatePickerEnabled(boolean datePickerEnabled) {
		this.datePickerEnabled = datePickerEnabled;
		if(!datePickerEnabled){
			setText("");
		}
	}  

}

