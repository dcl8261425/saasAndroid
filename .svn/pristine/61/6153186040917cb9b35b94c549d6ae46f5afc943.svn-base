package com.herotculb.qunhaichat.crm.querychance;

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
import com.herotculb.qunhaichat.crm.notes.AddNotesItemWindow;
import com.herotculb.qunhaichat.crm.notes.QueryNotesItemWindow;
import com.herotculb.qunhaichat.crm.notes.window.SelectedToMyChanceWindow;
import com.herotculb.qunhaichat.dto.NotesDto;
import com.herotculb.qunhaichat.util.DateUtil;

public class QueryNotesAdapter extends BaseAdapter {
	private Activity  context;
	private List<NotesDto> list;
	int layout;
	
	public QueryNotesAdapter(Activity context, List<NotesDto> list, int layout) {
		super();
		this.context = context;
		this.list = list;
		this.layout = layout;
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
		final NotesDto dto = (NotesDto) getItem(position);
		LayoutInflater inflater = LayoutInflater.from(context);
		TableLayout gridLayout = (TableLayout) inflater.inflate(
				layout, null);
		if(gridLayout.findViewById(R.id.crm_notes_name)!=null){
			TextView text  = (TextView) gridLayout.findViewById(R.id.crm_notes_name);
			TextView text1 = (TextView) gridLayout.findViewById(R.id.crm_notes_startdate);
			TextView text2 = (TextView) gridLayout.findViewById(R.id.crm_notes_enddate);
			TextView text3 = (TextView) gridLayout.findViewById(R.id.crm_notes_newdate);
			BootstrapButton add =(BootstrapButton) gridLayout.findViewById(R.id.crm_notes_add);
			BootstrapButton check =(BootstrapButton) gridLayout.findViewById(R.id.crm_notes_check);
			Date date = new Date();
			Date date1 = new Date();
			Date date2 = new Date();
			Long sdate = Long.parseLong(dto.getStartDate());
			Long edate = 0L;
			String endDate = "";
			if(!dto.getEndDate().equals("") && dto.getEndDate() != "null"){
				edate = Long.parseLong(dto.getEndDate());
				date1.setTime(edate);
				endDate = DateUtil.formatDateYYYY_MM_DD(date1);
			}
			Long udate = Long.parseLong(dto.getUpdateDate());
			date.setTime(sdate);
			date2.setTime(udate);
			String startDate = DateUtil.formatDateYYYY_MM_DD(date);
			String updateDate = DateUtil.formatDateYYYY_MM_DD(date2);
			text.setText("记录人："+dto.getNotesUserName());
			text1.setText("开始日期："+startDate);
			text2.setText("结束日期："+endDate);
			text3.setText("最新日期："+updateDate);
			add.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 添加开发记录
					Intent i = new Intent(context, AddNotesItemWindow.class);  
					Bundle b = new Bundle();
					b.putString("notesId", dto.getId()+"");
					b.putString("chanceId", dto.getChanceListId()+"");
					i.putExtras(b);  
					context.startActivityForResult(i, 0);
					context.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
				}
			});
			check.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 查看历史记录
					Intent i = new Intent(context, QueryNotesItemWindow.class);  
					Bundle b = new Bundle();
					b.putString("chanceId", dto.getChanceListId()+"");
					b.putString("notesId", dto.getId()+"");
					i.putExtras(b);  
					context.startActivityForResult(i, 0);
					context.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
				}
			});
		}else if(gridLayout.findViewById(R.id.crm_selected_notes_name)!=null){
			TextView text  = (TextView) gridLayout.findViewById(R.id.crm_selected_notes_name);
			TextView text1 = (TextView) gridLayout.findViewById(R.id.crm_selected_notes_startdate);
			TextView text2 = (TextView) gridLayout.findViewById(R.id.crm_selected_notes_enddate);
			TextView text3 = (TextView) gridLayout.findViewById(R.id.crm_selected_notes_newdate);
			BootstrapButton selected =(BootstrapButton) gridLayout.findViewById(R.id.crm_selected_notes);
			BootstrapButton check =(BootstrapButton) gridLayout.findViewById(R.id.crm_selected_notes_check);
			Date date = new Date();
			Date date1 = new Date();
			Date date2 = new Date();
			Long sdate = Long.parseLong(dto.getStartDate());
			Long edate = 0L;
			String endDate = "";
			if(!dto.getEndDate().equals("") && dto.getEndDate() != "null"){
				edate = Long.parseLong(dto.getEndDate());
				date1.setTime(edate);
				endDate = DateUtil.formatDateYYYY_MM_DD(date1);
			}
			Long udate = Long.parseLong(dto.getUpdateDate());
			date.setTime(sdate);
			date2.setTime(udate);
			String startDate = DateUtil.formatDateYYYY_MM_DD(date);
			String updateDate = DateUtil.formatDateYYYY_MM_DD(date2);
			text.setText("记录人："+dto.getNotesUserName());
			text1.setText("开始日期："+startDate);
			text2.setText("结束日期："+endDate);
			text3.setText("最新日期："+updateDate);
			selected.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 选中
					Intent i = new Intent(context, SelectedToMyChanceWindow.class);  
			        Bundle b2 = new Bundle();
			        b2.putString("type", "selected_notes");
			        b2.putString("notesName", dto.getNotesUserName());
			        b2.putString("notesId", dto.getId()+"");
			        i.putExtras(b2);
			        context.setResult(context.RESULT_OK, i);
			        context.finish();
			    }
			});
			check.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 查看历史记录
					Intent i = new Intent(context, QueryNotesItemWindow.class);  
					Bundle b = new Bundle();
					b.putString("chanceId", dto.getChanceListId()+"");
					b.putString("notesId", dto.getId()+"");
					i.putExtras(b);  
					context.startActivityForResult(i, 0);
					context.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
				}
			});
		}
		
		return gridLayout;
	}

}
