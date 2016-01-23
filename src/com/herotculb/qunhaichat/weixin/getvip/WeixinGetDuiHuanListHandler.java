package com.herotculb.qunhaichat.weixin.getvip;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.ScoreDuihuanDto;
import com.herotculb.qunhaichat.weixin.getvip.adopter.WeixinGetDuiHuanAdapter;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class WeixinGetDuiHuanListHandler extends Handler {
	Activity context;
	ListView view;
	LoadingDialog dialog;
	int layout;
	View viewp;
	String name = "";	
	private TextView textView;
	private Spinner spinner;
	private ArrayAdapter<String> adapter;
	
	public WeixinGetDuiHuanListHandler(Activity context, ListView view,
			LoadingDialog dialog,int layout) {
		this.context = context;
		this.view = view;
		this.dialog = dialog;
		this.layout = layout;
	}

	@Override
	public void handleMessage(android.os.Message msg) {
		super.handleMessage(msg);
		Map<String, Object> map = (Map<String, Object>)msg.obj;
		boolean b=(Boolean) map.get("success");
		dialog.hide();
		if(b){
			List<ScoreDuihuanDto> weiXinList = (List<ScoreDuihuanDto>)map.get("data");
			WeixinGetDuiHuanAdapter adapter = new WeixinGetDuiHuanAdapter(context, weiXinList,layout);
			view.setAdapter(adapter);
			HomeActivity.setListViewHeightBasedOnChildren(view);
		}else{
			new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
            .setTitleText("出错了！")
            .setContentText((String)map.get("info"))
            .show();
		}
	}
	
}
