package com.herotculb.qunhaichat.activity.register;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TimePicker;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.crm.CreateChanceWindow;
import com.herotculb.qunhaichat.crm.querychance.window.CustomerLevelWindow;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.widget.LoadingDialog;
/**
 * 查看行业的window
 * @author lkx
 *
 */
public class GetHangyeWindow extends Activity {
	private XListView list;
	private BootstrapButton enter;
	int layout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_get_hangye_window);		
		LoadingDialog dialog = new LoadingDialog(GetHangyeWindow.this, "正在获取数据");
		dialog.show();
		Bundle b = getIntent().getExtras();
		list=(XListView) findViewById(R.id.get_hangye_list);
		layout = R.layout.activity_get_hangye_list;
		list.setPullLoadEnable(true);
		GetHangyeHandler handler = 
				new GetHangyeHandler(GetHangyeWindow.this, list, dialog);
		GetHangyeThread thread = 
				new GetHangyeThread(GetHangyeWindow.this, handler);
		thread.start();
		BootstrapButton cancle=(BootstrapButton) GetHangyeWindow.this.findViewById(R.id.get_hangye_name_cancle);
		cancle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 取消查询
				GetHangyeWindow.this.finish();
			}
		});
	}
}
