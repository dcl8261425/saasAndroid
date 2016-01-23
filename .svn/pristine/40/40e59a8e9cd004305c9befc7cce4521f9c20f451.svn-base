package com.herotculb.qunhaichat.employee.meeting;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TableLayout;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.ConpanyUserMeetingDto;
import com.herotculb.qunhaichat.dto.MeetingDto;
import com.herotculb.qunhaichat.goods.source.window.GoodsAddSourceWindow;

public class GetMeetingSetInfoAdapter extends BaseAdapter {
	private Activity  context;
	private List<MeetingDto> list;
	
	public GetMeetingSetInfoAdapter(Activity context, List<MeetingDto> list) {
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
		final MeetingDto dto = (MeetingDto) getItem(position);
		LayoutInflater inflater = LayoutInflater.from(context);
		TableLayout gridLayout = (TableLayout) inflater.inflate(
				R.layout.employee_get_meeting_set_info_list, null);
		if(gridLayout.findViewById(R.id.employee_manager_user_truename)!=null){
			TextView name  = (TextView) gridLayout.findViewById(R.id.employee_manager_user_truename);
			TextView managerDate = (TextView) gridLayout.findViewById(R.id.employee_manager_date);
			TextView content = (TextView) gridLayout.findViewById(R.id.employee_update_content);
			BootstrapButton update =(BootstrapButton) gridLayout.findViewById(R.id.employee_customer_update);
			name.setText("修改人："+dto.getManagerUserTrueName());
			String sdateStr = "";
			if(dto.getManagerDate()!=null && !dto.getManagerDate().equals("")
					&& dto.getManagerDate().toString()!="null"){
				Date date = new Date();
				Long sdate = Long.parseLong(dto.getManagerDate().toString());
				date.setTime(sdate);
				SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd");
				sdateStr = time.format(date);
			}
			managerDate.setText("修改日期："+sdateStr);
			String iptext = "指定";
			if(!dto.isIPTest()){
				iptext = "未指定";
			}
			content.setText("修改内容：上班-"+dto.getStartDate()+" 下班-"+
					dto.getEndDate()+" 是否指定网络-"+iptext);
			update.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 修改
					Intent i = new Intent(context, GoodsAddSourceWindow.class);  
					Bundle b = new Bundle();
					b.putString("id", String.valueOf(dto.getId()));
	                i.putExtras(b);  
	                context.startActivity(i);
	                context.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
				}
			});
		}
		return gridLayout;
	}

}
