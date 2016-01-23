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
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.ConpanyUserMeetingDto;
import com.herotculb.qunhaichat.widget.LoadingDialog;

public class GetCustomerMeetingInfoAdapter extends BaseAdapter {
	private Activity  context;
	private List<ConpanyUserMeetingDto> list;
	
	BootstrapButton stuteUpd;
	BootstrapButton stuteEnt;
	BootstrapButton stuteSelect;
	BootstrapButton marksUpd;
	BootstrapButton marksEnt;
	
	BootstrapEditText stute;
	BootstrapEditText stuteMarks;
	
	public GetCustomerMeetingInfoAdapter(Activity context, List<ConpanyUserMeetingDto> list) {
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
		final ConpanyUserMeetingDto dto = (ConpanyUserMeetingDto) getItem(position);
		LayoutInflater inflater = LayoutInflater.from(context);
		TableLayout gridLayout = (TableLayout) inflater.inflate(
				R.layout.employee_meeting_list, null);
		if(gridLayout.findViewById(R.id.employee_company_user_truename)!=null){
			TextView name  = (TextView) gridLayout.findViewById(R.id.employee_company_user_truename);
			TextView startDate = (TextView) gridLayout.findViewById(R.id.employee_start_date);
			TextView endDate = (TextView) gridLayout.findViewById(R.id.employee_end_date);
			stute = (BootstrapEditText) gridLayout.findViewById(R.id.employee_stute);
			stuteMarks = (BootstrapEditText) gridLayout.findViewById(R.id.employee_stute_marks);
			stuteUpd =(BootstrapButton) gridLayout.findViewById(R.id.employee_stute_update);
			stuteEnt =(BootstrapButton) gridLayout.findViewById(R.id.employee_stute_enter);
			stuteSelect =(BootstrapButton) gridLayout.findViewById(R.id.employee_stute_select);
			marksUpd =(BootstrapButton) gridLayout.findViewById(R.id.employee_stute_marks_update);
			marksEnt =(BootstrapButton) gridLayout.findViewById(R.id.employee_stute_marks_enter);
			name.setText("姓名："+dto.getConpanyUsertrueName());
			String sdateStr = "未签到";
			if(dto.getStartDate()!=null && !dto.getStartDate().equals("")
					&& dto.getStartDate().toString()!="null"){
				Date date = new Date();
				Long sdate = Long.parseLong(dto.getStartDate().toString());
				date.setTime(sdate);
				SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				sdateStr = time.format(date);
			}
			startDate.setText("签到时间："+sdateStr);
			String edateStr = "未签到";
			if(dto.getEndDate()!=null && !dto.getEndDate().equals("")
					&& dto.getEndDate().toString() != "null"){
				Date date = new Date();
				Long sdate = Long.parseLong(dto.getEndDate().toString());
				date.setTime(sdate);
				SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				edateStr = time.format(date);
			}
			endDate.setText("签退时间："+edateStr);
			String stuteText = "未签到";
			if(dto.getStute()==1){
				stuteText = "迟到";
			}
			else if(dto.getStute()==2){
				stuteText = "早退";
			}
			else if(dto.getStute()==3){
				stuteText = "迟到加早退";
			}
			else if(dto.getStute()==4){
				stuteText = "外出";
			}
			else if(dto.getStute()==5){
				stuteText = "正常签到";
			}
			stute.setId(Integer.parseInt(String.valueOf(dto.getId())));
			stuteMarks.setId(Integer.parseInt(String.valueOf(dto.getId())));
			stute.setText("状态："+stuteText);
			stuteMarks.setText("备注："+dto.getStuteMarks());
			stuteUpd.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 状态修改
					stute.setEnabled(true);
					stuteUpd.setVisibility(View.GONE);
					stuteEnt.setVisibility(View.VISIBLE);
				}
			});
			stuteEnt.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 状态确定
					LoadingDialog dialog = new 
							LoadingDialog(context, "正在保存数据");
					dialog.show();
					GetUpdateMeetingInfoHandler handler = 
							new GetUpdateMeetingInfoHandler(context, dialog);
					GetUpdateMeetingInfoThread thread = 
							new GetUpdateMeetingInfoThread(context, "stute",
									dto.getStute()+"", dto.getId()+"", handler);
					thread.start();
				}
			});
			stuteSelect.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 选择签到状态
					Intent i = new Intent(context,EmployeChangeStuteWindow.class);
					Bundle b = new Bundle();
					i.putExtras(b);
					context.startActivityForResult(i, 0);
					context.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
				}
			});
			marksUpd.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 备注修改
					stuteMarks.setEnabled(true);
					marksUpd.setVisibility(View.GONE);
					marksEnt.setVisibility(View.VISIBLE);
				}
			});
			marksEnt.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 备注确定
					LoadingDialog dialog = new 
							LoadingDialog(context, "正在保存数据");
					dialog.show();
					BootstrapEditText stuteMarks = (BootstrapEditText) context.findViewById(R.id.employee_stute_marks);
					GetUpdateMeetingInfoHandler handler = 
							new GetUpdateMeetingInfoHandler(context, dialog);
					GetUpdateMeetingInfoThread thread = 
							new GetUpdateMeetingInfoThread(context, "marks",
									stuteMarks.getText().toString(), dto.getId()+"", handler);
					thread.start();
				}
			});
		}
		return gridLayout;
	}

}
