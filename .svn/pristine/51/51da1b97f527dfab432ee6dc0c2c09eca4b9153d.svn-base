package com.herotculb.qunhaichat.employee.performance;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TableLayout;
import android.widget.TextView;

import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.PerformanceDto;

public class GetPerformanceAdapter extends BaseAdapter {
	private Activity  context;
	private List<PerformanceDto> list;
	
	public GetPerformanceAdapter(Activity context, List<PerformanceDto> list) {
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
		final PerformanceDto dto = (PerformanceDto) getItem(position);
		LayoutInflater inflater = LayoutInflater.from(context);
		TableLayout gridLayout = (TableLayout) inflater.inflate(
				R.layout.employee_performance_list, null);
		if(gridLayout.findViewById(R.id.employee_user_truename)!=null){
			TextView name  = (TextView) gridLayout.findViewById(R.id.employee_user_truename);
			TextView myChance = (TextView) gridLayout.findViewById(R.id.employee_my_create_chance);
			TextView chanceNum = (TextView) gridLayout.findViewById(R.id.employee_to_chance_num);
			TextView buyNum = (TextView) gridLayout.findViewById(R.id.employee_my_create_chance_buy_num);
			TextView countPrice = (TextView) gridLayout.findViewById(R.id.employee_my_create_chance_buy_count_price);
			TextView chanceBuyNum = (TextView) gridLayout.findViewById(R.id.employee_to_chance_buy_num);
			TextView chanceCount = (TextView) gridLayout.findViewById(R.id.employee_to_chance_buy_count_price);
			TextView num = (TextView) gridLayout.findViewById(R.id.employee_meeting_num);
			TextView leave = (TextView) gridLayout.findViewById(R.id.employee_meeting_leave);
			TextView numOut = (TextView) gridLayout.findViewById(R.id.employee_meeting_num_out);
			TextView lastNum = (TextView) gridLayout.findViewById(R.id.employee_meeting_last_num);
			TextView outNum = (TextView) gridLayout.findViewById(R.id.employee_meeting_out_num);
			name.setText("姓名："+dto.getUserTrueName());
			myChance.setText("创建机会数:"+dto.getMyCreateChanceNum());
			chanceNum.setText("被指派机会数:"+dto.getToChanceNum());
			buyNum.setText("创建机会成交数:"+dto.getMyCreateChanceBuyNum());
			countPrice.setText("创建机会成交金额:"+dto.getMyCreateChanceBuyCountPrice());
			chanceBuyNum.setText("指派机会成交数:"+dto.getToChanceBuyNum());
			chanceCount.setText("指派机会成交金额:"+dto.getToChanceBuyCountPrice());
			num.setText("签到次数:"+dto.getMeetingNum());
			leave.setText("签退次数:"+dto.getMeetingLeave());
			numOut.setText("外出："+dto.getMeetingNumOut());
			lastNum.setText("迟到："+dto.getMeetingLastNum());
			outNum.setText("早退："+dto.getMeetingOutNum());
		}
		return gridLayout;
	}

}
