package com.herotculb.qunhaichat.activity;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.widget.Button;

import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.widget.LoadingDialog;
import com.herotculb.qunhaichat.widget.TipsToast;

public class SignInHandler extends Handler{
	Activity content;
	LoadingDialog dialog;
	Button mLoginBtn;
    TipsToast tipsToast;
	public SignInHandler(Activity content,LoadingDialog dialog,TipsToast tipsToast){
		this.dialog=dialog;
		this.content=content;
	}
	@Override
	public void handleMessage(android.os.Message msg) {
		super.handleMessage(msg);
		List<Map<String,Object>> list=(List<Map<String, Object>>) msg.obj;
		Map<String,Object> map=list.iterator().next();
		boolean b=(Boolean) map.get("success");
		String info=(String) map.get("info");
		dialog.hide();
		dialog.dismiss();
		showTips(R.drawable.tips_warning, info);
		Button mLoginBtn=(Button) content.findViewById(R.id.login_login_btn);
		mLoginBtn.setEnabled(true);
	};
	/**
	 * 自定义toast
	 * 
	 * @param iconResId
	 *            图片
	 * @param msgResId
	 *            提示文字
	 */
	private void showTips(int iconResId, String tips) {
		if (tipsToast != null) {
			if (Build.VERSION.SDK_INT < Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
				tipsToast.cancel();
			}
		} else {
			tipsToast = TipsToast.makeText(content.getApplication().getBaseContext(),
					tips, TipsToast.LENGTH_SHORT);
		}
		tipsToast.show();
		tipsToast.setIcon(iconResId);
		tipsToast.setText(tips);
	}
}
