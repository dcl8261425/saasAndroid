package com.herotculb.qunhaichat.messageinfo.window;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.messageinfo.MessageSendAllHandler;
import com.herotculb.qunhaichat.messageinfo.MessageSendAllThread;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class MessageShowWindow extends Activity {
	private BootstrapButton cancle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.message_show_window);
		cancle =(BootstrapButton)findViewById(R.id.message_show_cancel);
//		
		Bundle b = getIntent().getExtras();
		String type = b.getString("type");
		String marks = b.getString("marks");
		
		TextView show = (TextView)findViewById(R.id.message_show);
		if(type.equals("1")){
			show.setText("正在初始化数据。。。");
		}
		
		MessageSendAllHandler vipHandler = new MessageSendAllHandler(
				MessageShowWindow.this);
		MessageSendAllThread vipThread = new MessageSendAllThread(
				MessageShowWindow.this, vipHandler,marks);
		vipThread.start();
				
		cancle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 取消
				MessageShowWindow.this.finish();
			}
		});
		
	}
	
}
