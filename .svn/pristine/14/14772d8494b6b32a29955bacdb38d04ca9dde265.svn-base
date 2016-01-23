package com.herotculb.qunhaichat.weixin.approval;

import java.util.List;
import java.util.Map;

import android.os.Handler;
import android.view.View;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.dto.VipImageMessageDto;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.weixin.approval.adapter.GetImageAdapter;
import com.herotculb.qunhaichat.weixin.getvip.adopter.WeixinGetVipAdapter;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class GetImageHandler extends Handler {
	HomeActivity context;
	XListView view;
	LoadingDialog dialog;
	View viewp;
		
	public GetImageHandler(HomeActivity context, XListView view,
			LoadingDialog dialog) {
		super();
		this.context = context;
		this.view = view;
		this.dialog = dialog;
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
//		BootstrapEditText nowpage=(BootstrapEditText) context.findViewById(R.id.weixin_game_vip_nowpage);
		if(b){
			List<VipImageMessageDto> weiXinList = (List<VipImageMessageDto>) map.get("data");
			GetImageAdapter adapter = new GetImageAdapter(context, weiXinList);
			view.setAdapter(adapter);
//			 int nowpagenum=Integer.parseInt(nowpage.getText().toString());
//			 int pagenum=Integer.parseInt(map.get("pagenum").toString())+1;
//			 if(nowpagenum>=pagenum){
//				
//				 nowpage.setText(String.valueOf(pagenum));
//			 }
		}else{
			new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
            .setTitleText("出错了！")
            .setContentText((String)map.get("info"))
            .show();
		}
	}
	
}
