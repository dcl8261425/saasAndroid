package com.herotculb.qunhaichat.weixin.getvip;

import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.VIPSetDto;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class WeixinGetVipXinxiHandler extends Handler {
	Activity context;
	ViewGroup view;
	LoadingDialog dialog;
	
	public WeixinGetVipXinxiHandler(Activity context, LoadingDialog dialog) {
		super();
		this.context = context;
		this.dialog = dialog;
	}

	@Override
	public void handleMessage(android.os.Message msg) {
		super.handleMessage(msg);
		Map<String, Object> map = (Map<String, Object>) msg.obj;
		boolean b=(Boolean) map.get("success");
		dialog.hide();
		dialog.dismiss();
		if(b){
			TextView name = (TextView)
					context.findViewById(R.id.weixin_class_name);
			TextView marks = (TextView)
					context.findViewById(R.id.weixin_class_marks);
			final VIPSetDto dto = (VIPSetDto)map.get("data");
			name.setText(dto.getName());
			marks.setText(dto.getMarks());
//			Intent i = new Intent(context, VipDiscountWindowActivity.class);  
//	        Bundle b2 = new Bundle();
//	        i.putExtras(b2);
//	        context.setResult(context.RESULT_OK, i);  
//	        context.finish();
		}else{
			new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
            .setTitleText("出错了！")
            .setContentText((String)map.get("info"))
            .show();
		}
	}
}
