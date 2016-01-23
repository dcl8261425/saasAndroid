package com.herotculb.qunhaichat.homeactiviti.messageinfo;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.homeactiviti.group.GroupManager;
import com.herotculb.qunhaichat.messageinfo.GetMessageSetHandler;
import com.herotculb.qunhaichat.messageinfo.GetMessageSetThread;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class MessageSetManager {
	public HomeActivity home;
	public LinearLayout linearLayout;
	
	public MessageSetManager(HomeActivity home, LinearLayout linearLayout) {
		this.home = home;
		this.linearLayout = linearLayout;
		
		//短信设置
		LinearLayout gridLayout = (LinearLayout) home.inflater.inflate(
				R.layout.message_get_message_set_layout, null)
				.findViewById(R.id.message_get_message_set_main);
		linearLayout.removeAllViews();
		linearLayout.addView(gridLayout);
		LoadingDialog dialog = new LoadingDialog(MessageSetManager.this.home, "正在获取数据");
		dialog.show();
		GetMessageSetHandler handler = new 
				GetMessageSetHandler(MessageSetManager.this.home, dialog,this);
		GetMessageSetThread thread = new 
				GetMessageSetThread(MessageSetManager.this.home, handler);
		thread.start();
		
	}
	
}
