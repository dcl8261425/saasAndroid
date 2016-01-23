package com.herotculb.qunhaichat.group;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

/**
 * 获得成员数据
 * @author Administrator
 *
 */
public class GetGroupCompanyUserThread extends Thread {
	private Activity context;
	private String nowpage;
	private String countNum;
	private String name;
	private Handler handler;
	
	public GetGroupCompanyUserThread(Activity context, String nowpage,
			String countNum, String name, Handler handler) {
		super();
		this.context = context;
		this.nowpage = nowpage;
		this.countNum = countNum;
		this.name = name;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		BootstrapEditText groupText = null;
		BootstrapEditText idText = null;
		String groupName = null;
		String groupId = null;
		if(context.findViewById(R.id.user_company_group_gname)!=null){
			groupText = (BootstrapEditText)context.findViewById(R.id.user_company_group_gname);
			groupName = groupText.getText().toString();
			idText = (BootstrapEditText)context.findViewById(R.id.user_company_group_id);
			groupId = idText.getText().toString();
		}else if(context.findViewById(R.id.permission_company_group_gname)!=null){
			groupText = (BootstrapEditText)context.findViewById(R.id.permission_company_group_gname);
			groupName = groupText.getText().toString();
			idText = (BootstrapEditText)context.findViewById(R.id.permission_company_group_id);
			groupId = idText.getText().toString();
		}else if(context.findViewById(R.id.permission_insert_company_group_id)!=null){
			groupText = (BootstrapEditText)context.findViewById(R.id.permission_insert_company_group_gname);
			groupName = groupText.getText().toString();
			idText = (BootstrapEditText)context.findViewById(R.id.permission_insert_company_group_id);
			groupId = idText.getText().toString();
		}else if(context.findViewById(R.id.get_all_group_sub_id)!=null){
			groupText = (BootstrapEditText)context.findViewById(R.id.get_all_group_sub_name);
			groupName = groupText.getText().toString();
			idText = (BootstrapEditText)context.findViewById(R.id.get_all_group_sub_id);
			groupId = idText.getText().toString();
		}
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.getGroupConpanyUser(nowpage, countNum, groupId, groupName, name);
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg);  
	}
	
}
