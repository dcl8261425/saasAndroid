package com.herotculb.qunhaichat.weixin.getvip;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.LinkManListDto;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.weixin.getvip.adopter.WeixinGetVipAdapter;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class WeixinGetVipHandler extends Handler {
	Activity context;
	XListView view;
	LoadingDialog dialog;
	int layout;
	String marks;
	View viewp;
		
	public WeixinGetVipHandler(Activity context, XListView view,
			LoadingDialog dialog,int layout,String marks) {
		super();
		this.context = context;
		this.view = view;
		this.dialog = dialog;
		this.layout = layout;
		this.marks = marks;
	}

	@Override
	public void handleMessage(android.os.Message msg) {
		super.handleMessage(msg);
		Map<String, Object> map = (Map<String, Object>)msg.obj;
		boolean b=(Boolean) map.get("success");
		dialog.hide();
		dialog.dismiss();
		view.stopRefresh();
		view.stopLoadMore();
		view.setRefreshTime("刚刚");
		BootstrapEditText nowpage= null;
		if(context.findViewById(R.id.weixin_game_vip_nowpage) != null){
			nowpage=(BootstrapEditText) context.findViewById(R.id.weixin_game_vip_nowpage);
		}else{
			nowpage=(BootstrapEditText) context.findViewById(R.id.message_game_vip_nowpage);
		}
		if(b){
			List<LinkManListDto> weiXinList = (List<LinkManListDto>) map.get("data");
			WeixinGetVipAdapter adapter = new WeixinGetVipAdapter(context, weiXinList,layout,marks);
			view.setAdapter(adapter);
			int nowpagenum= 0;
			if(nowpage.getText().toString().equals("")){
				nowpagenum= 1;
			}else{
				nowpagenum=Integer.parseInt(nowpage.getText().toString());
			}
			 int pagenum=Integer.parseInt(map.get("pagenum").toString())+1;
			 if(nowpagenum>=pagenum){
				
				 nowpage.setText(String.valueOf(pagenum));
			 }
		}else{
			new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
            .setTitleText("出错了！")
            .setContentText((String)map.get("info"))
            .show();
		}
	}
	
}
