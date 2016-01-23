package com.herotculb.qunhaichat.employee.interactive.adapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TableLayout;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.ConpanyZoneRetDto;
import com.herotculb.qunhaichat.dto.ConpanyZoneZan;
import com.herotculb.qunhaichat.dto.KongJianDto;
import com.herotculb.qunhaichat.employee.interactive.ZanHandler;
import com.herotculb.qunhaichat.employee.interactive.ZanThread;
import com.herotculb.qunhaichat.employee.interactive.window.EmployeeInteractiveResendWindow;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class GetHuDongKongJianAdapter extends BaseAdapter {
	private Activity  context;
	private List<KongJianDto> list;
	TableLayout ret;
	BootstrapButton resend,zan,delete,setTop;
	TextView retContent,createUser,retDate,zanCount;
	
	public GetHuDongKongJianAdapter(Activity context, List<KongJianDto> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO 自动生成的方法存根
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO 自动生成的方法存根
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO 自动生成的方法存根
		final KongJianDto dto = (KongJianDto) getItem(position);
		LayoutInflater inflater = LayoutInflater.from(context);
		TableLayout gridLayout = (TableLayout) inflater.inflate(
				R.layout.employee_interactive_list, null);
		if(gridLayout.findViewById(R.id.employee_interactive_title)!=null){
			TextView title  = (TextView) gridLayout.findViewById(R.id.employee_interactive_title);
			TextView content = (TextView) gridLayout.findViewById(R.id.employee_interactive_content);
			TextView createDate = (TextView) gridLayout.findViewById(R.id.employee_interactive_create_date);
			TextView createUsername = (TextView) gridLayout.findViewById(R.id.employee_interactive_create_username);
			BootstrapButton vote = (BootstrapButton)gridLayout.findViewById(R.id.employee_interactive_vote);
			BootstrapButton recall = (BootstrapButton)gridLayout.findViewById(R.id.employee_interactive_recall);
			BootstrapButton image = (BootstrapButton)gridLayout.findViewById(R.id.employee_interactive_image);
			BootstrapButton video = (BootstrapButton)gridLayout.findViewById(R.id.employee_interactive_video);
			BootstrapButton file = (BootstrapButton)gridLayout.findViewById(R.id.employee_interactive_file);
			
			zan = (BootstrapButton)gridLayout.findViewById(R.id.employee_interactive_zan);
			delete = (BootstrapButton)gridLayout.findViewById(R.id.employee_interactive_delete);
			setTop = (BootstrapButton)gridLayout.findViewById(R.id.employee_interactive_set_top);
			
			ret = (TableLayout)gridLayout.findViewById(R.id.employee_ret);
			resend = (BootstrapButton)gridLayout.findViewById(R.id.employee_interactive_resend);
			retContent = (TextView)gridLayout.findViewById(R.id.employee_ret_content);
			createUser = (TextView)gridLayout.findViewById(R.id.employee_ret_create_user);
			retDate = (TextView)gridLayout.findViewById(R.id.employee_ret_create_date);
			zanCount = (TextView)gridLayout.findViewById(R.id.employee_interactive_zancount);
			
//			List<Object> zoneZan = dto.getZanList();
//			for(int i=0;i<zoneZan.size();i++){
//				ConpanyZoneZan zZan = (ConpanyZoneZan)zoneZan.get(i);
				zanCount.setText(dto.getZan()+"");
//			}
			
			title.setText("标题："+dto.getTitle());
			String cdateStr = "";
			if(dto.getCreateDate()!=null && !dto.getCreateDate().equals("")
					&& dto.getCreateDate().toString()!="null"){
				Date date = new Date();
				Long cdate = Long.parseLong(dto.getCreateDate().toString());
				date.setTime(cdate);
				SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				cdateStr = time.format(date);
			}
			content.setText("内容："+dto.getContent());
			createDate.setText("发布时间："+cdateStr);
			createUsername.setText("发布人："+dto.getCreateUserName());
			
			zan.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 点赞
					LoadingDialog dialog = new LoadingDialog(context, "正在保存数据！");
					dialog.show();
					ZanHandler handler = new ZanHandler(context, dialog);
					ZanThread thread = new ZanThread(context, dto.getId()+"", handler);
					thread.start();
				}
			});
			
			delete.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 删除
					
				}
			});
			
			setTop.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 设置置顶
					
				}
			});
			
			if(dto.getToupiaoItemList() != null){
				vote.setVisibility(View.VISIBLE);
			}else{
				vote.setVisibility(View.GONE);
			}
			if(dto.getImageList() != null){
				image.setVisibility(View.VISIBLE);
			}else{
				image.setVisibility(View.GONE);
			}
			if(dto.getVidioList() != null){
				video.setVisibility(View.VISIBLE);
			}else{
				video.setVisibility(View.GONE);
			}
			Log.e("file--", ""+(dto.getFileList() == null)+"--"+(dto.getFileList().size()));
			if(dto.getFileList() != null){
				file.setVisibility(View.VISIBLE);
			}else{
				file.setVisibility(View.GONE);
			}
			vote.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 投票
					
				}
			});
			recall.setId((int)dto.getId());
			recall.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 回复
					if(ret.getVisibility() == View.GONE){
						ret.setVisibility(View.VISIBLE);
						List<ConpanyZoneRetDto> retList = dto.getRetList();
						for(int i=0;i<retList.size();i++){
							retContent.setText(retList.get(i).getContent());
							if(retList.get(i).getCreateDate()!=null && !retList.get(i).getCreateDate().equals("")
									&& retList.get(i).getCreateDate().toString()!="null"){
								Date date = new Date();
								Long cdate = Long.parseLong(retList.get(i).getCreateDate().toString());
								date.setTime(cdate);
								SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								String cdateStr = time.format(date);
								retDate.setText(cdateStr);
							}
							createUser.setText(retList.get(i).getCreateUserName());
						}
						resend.setOnClickListener(new OnClickListener() {
							
							@Override
							public void onClick(View arg0) {
								// TODO 我要发言
								Intent i = new Intent(context, EmployeeInteractiveResendWindow.class);
								Bundle b = new Bundle();
								i.putExtras(b);
								context.startActivityForResult(i, 0);
								context.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
							}
						});
					}else{
						ret.setVisibility(View.GONE);
					}
				}
			});
			image.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 图片
					
				}
			});
			video.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 视频
					
				}
			});
			file.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 文件
					
				}
			});
		}
		return gridLayout;
	}

}
