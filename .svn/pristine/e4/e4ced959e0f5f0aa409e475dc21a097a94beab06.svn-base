package com.herotculb.qunhaichat.employee.meeting;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TimePicker;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.crm.CreateChanceWindow;
import com.herotculb.qunhaichat.crm.querychance.window.CustomerLevelWindow;
import com.herotculb.qunhaichat.view.listview.updown.XListView;
import com.herotculb.qunhaichat.widget.LoadingDialog;
/**
 * 查看联系人的window
 * @author lkx
 *
 */
public class GetMeetingSetInfoWindow extends Activity implements OnTouchListener {
	private XListView list;
	private BootstrapButton enter;
	private String chanceId;
	BootstrapEditText start;
	BootstrapEditText end;
	int layout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏头
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.employee_get_meeting_set_info_window);		
		LoadingDialog dialog = new LoadingDialog(GetMeetingSetInfoWindow.this, "正在获取数据");
		dialog.show();
		Bundle b = getIntent().getExtras();
		chanceId = b.getString("chanceId");
		list=(XListView) findViewById(R.id.employee_get_meeting_set_info_list);
		layout = R.layout.employee_get_meeting_set_info_list;
		list.setPullLoadEnable(true);
		GetMeetingSetInfoHandler handler = 
				new GetMeetingSetInfoHandler(GetMeetingSetInfoWindow.this, list, dialog);
		GetMeetingSetInfoThread thread = 
				new GetMeetingSetInfoThread(GetMeetingSetInfoWindow.this,handler);
		thread.start();
		BootstrapButton cancle=(BootstrapButton) GetMeetingSetInfoWindow.this.findViewById(R.id.employee_get_meeting_set_info_cancle);
		cancle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 取消查询
				GetMeetingSetInfoWindow.this.finish();
			}
		});
		start = (BootstrapEditText)GetMeetingSetInfoWindow.this.findViewById(R.id.meeting_set_info_start_date);
		end = (BootstrapEditText)GetMeetingSetInfoWindow.this.findViewById(R.id.meeting_set_info_end_date);
		// TODO 上班时间选择
		start.setOnTouchListener(GetMeetingSetInfoWindow.this);
		// TODO 下班时间选择
		end.setOnTouchListener(GetMeetingSetInfoWindow.this);
		BootstrapButton ipbtn=(BootstrapButton) GetMeetingSetInfoWindow.this.findViewById(R.id.meeting_set_info_iptest_btn);
		ipbtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 指定网络
				Intent i = new Intent(GetMeetingSetInfoWindow.this,EmployeeIpWindow.class);
				Bundle b = new Bundle();
				i.putExtras(b);
				GetMeetingSetInfoWindow.this.startActivityForResult(i, 0);
				GetMeetingSetInfoWindow.this.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
		enter =(BootstrapButton) GetMeetingSetInfoWindow.this.findViewById(R.id.employee_get_meeting_set_info_enter);
		enter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 保存
				LoadingDialog dialog = new 
						LoadingDialog(GetMeetingSetInfoWindow.this, "正在保存数据");
				dialog.show();
				GetMeetingSetHandler handler = 
						new GetMeetingSetHandler(GetMeetingSetInfoWindow.this, dialog);
				GetMeetingSetThread thread = 
						new GetMeetingSetThread(GetMeetingSetInfoWindow.this, handler);
				thread.start();
			}
		});
	}
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO 时间选择方法
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			View view = View.inflate(this, R.layout.employee_time_window, null);
			final TimePicker timePicker = (android.widget.TimePicker) view.findViewById(R.id.time_picker); 
            builder.setView(view); 
			
            Calendar cal = Calendar.getInstance(); 
            cal.setTimeInMillis(System.currentTimeMillis());
            timePicker.setIs24HourView(true); 
            timePicker.setCurrentHour(cal.get(Calendar.HOUR_OF_DAY)); 
            timePicker.setCurrentMinute(Calendar.MINUTE);
            
            if(v.getId() == R.id.meeting_set_info_start_date){
            	final int inType = start.getInputType(); 
                start.setInputType(InputType.TYPE_NULL); 
                start.onTouchEvent(event); 
                start.setInputType(inType); 
                start.setSelection(start.getText().length());
                builder.setTitle("选取上班时间"); 
                builder.setPositiveButton("确  定", new DialogInterface.OnClickListener() { 
   
                    @Override 
                    public void onClick(DialogInterface dialog, int which) { 
   
                        StringBuffer sb = new StringBuffer(); 
                        sb.append(timePicker.getCurrentHour()) 
                        .append(":").append(timePicker.getCurrentMinute()); 
   
                        start.setText(sb); 
                        end.requestFocus();   
                        dialog.cancel(); 
                    } 
                });
            }else if(v.getId() == R.id.meeting_set_info_end_date){
            	final int inType = end.getInputType(); 
            	end.setInputType(InputType.TYPE_NULL); 
            	end.onTouchEvent(event); 
            	end.setInputType(inType); 
            	end.setSelection(end.getText().length());
                builder.setTitle("选取下班时间"); 
                builder.setPositiveButton("确  定", new DialogInterface.OnClickListener() { 
                	   
                    @Override 
                    public void onClick(DialogInterface dialog, int which) { 
   
                        StringBuffer sb = new StringBuffer(); 
                        sb.append(timePicker.getCurrentHour()) 
                        .append(":").append(timePicker.getCurrentMinute()); 
   
                        end.setText(sb); 
                        dialog.cancel(); 
                    } 
                });
            }
            Dialog dialog = builder.create(); 
            dialog.show();
		}
		return false;
	}
	
	//弹出框返回的内容在这里接受
	 protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
	        super.onActivityResult(requestCode, resultCode, data);
	      //取出字符串  
	        if(data==null){
	        	return ;
	        }
	        Bundle bundle = data.getExtras();	        
	        if(bundle==null){
	        	return ;
	        }
	        String type=(String) bundle.get("type");
	        BootstrapEditText ip= (BootstrapEditText)
	        		GetMeetingSetInfoWindow.this.findViewById(R.id.meeting_set_info_ip);
	        BootstrapEditText iptest= (BootstrapEditText)
	        		GetMeetingSetInfoWindow.this.findViewById(R.id.meeting_set_info_iptest);
	        if(type.equals("employee_ip1")){
	        	ip.setText(bundle.getString("ip1"));
	        	iptest.setText(bundle.getString("ip1Str"));
	        }
	        if(type.equals("employee_ip2")){
	        	ip.setText(bundle.getString("ip2"));
	        	iptest.setText(bundle.getString("ip2Str"));
	        }
	 }
}
