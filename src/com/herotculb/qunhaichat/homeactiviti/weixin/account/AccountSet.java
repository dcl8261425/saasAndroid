package com.herotculb.qunhaichat.homeactiviti.weixin.account;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.weixin.accountset.AccountSetHandler;
import com.herotculb.qunhaichat.weixin.accountset.AccountSetThread;
import com.herotculb.qunhaichat.weixin.accountset.AccountSetUpdateHandler;
import com.herotculb.qunhaichat.weixin.accountset.AccountSetUpdateThread;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class AccountSet {
	public HomeActivity home;
	public LinearLayout linearLayout;
	public AccountSet(HomeActivity home,LinearLayout linearLayout){
		this.home=home;
		this.linearLayout=linearLayout;
		LinearLayout gridLayout = (LinearLayout) home.inflater.inflate(
				R.layout.weixin_accountset_layout, null)
				.findViewById(R.id.weixin_accountset_layout_main);
		linearLayout.removeAllViews();
		linearLayout.addView(gridLayout);
		BootstrapButton enter=(BootstrapButton) home.findViewById(R.id.weixin_accountset_layout_enter);
		LoadingDialog dialog = new LoadingDialog(AccountSet.this.home, "正在获取数据");
		dialog.show();
		AccountSetHandler handler=new AccountSetHandler(AccountSet.this.home, dialog);
		AccountSetThread thread=new AccountSetThread(AccountSet.this.home, handler);
		thread.start();
		enter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				BootstrapEditText appid=(BootstrapEditText) AccountSet.this.home.findViewById(R.id.weixin_accountset_layout_appid);
				BootstrapEditText appSecret=(BootstrapEditText) AccountSet.this.home.findViewById(R.id.weixin_accountset_layout_AppSecret);
				BootstrapEditText tokens=(BootstrapEditText) AccountSet.this.home.findViewById(R.id.weixin_accountset_layout_tokens);
				LoadingDialog dialog = new LoadingDialog(AccountSet.this.home, "正在获取数据");
				dialog.show();
				AccountSetUpdateHandler handler=new AccountSetUpdateHandler(AccountSet.this.home, dialog);
				AccountSetUpdateThread thread=new AccountSetUpdateThread(AccountSet.this.home,handler,appid.getText().toString(),appSecret.getText().toString(),tokens.getText().toString());
				thread.start();
			}
		});
	}
}
