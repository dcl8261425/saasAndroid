package com.herotculb.qunhaichat.weixin.getvip.adopter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.db.DBManager;
import com.herotculb.qunhaichat.db.Person;
import com.herotculb.qunhaichat.dto.LinkManListDto;
import com.herotculb.qunhaichat.messageinfo.window.MessageShowWindow;
import com.herotculb.qunhaichat.weixin.getvip.window.VipAddScoreWindowActivity;
import com.herotculb.qunhaichat.weixin.getvip.window.VipDiscountWindowActivity;
import com.herotculb.qunhaichat.weixin.getvip.window.VipJianMoneyWindowActivity;
import com.herotculb.qunhaichat.weixin.getvip.window.VipJianScoreWindowActivity;
import com.herotculb.qunhaichat.weixin.getvip.window.VipUpdateWindowActivity;

public class WeixinGetVipAdapter extends BaseAdapter{
	private Activity  context;
	private List<LinkManListDto> list;
	int layout;
	String marks;
	
	StringBuffer phonesb;
	StringBuffer linksb;
	StringBuffer wphonesb;
	TextView link;
	private DBManager mgr;
	private ListView listView;
	
	public WeixinGetVipAdapter(Activity context, List<LinkManListDto> list,int layout,String marks) {
		super();
		this.context = context;
		this.list = list;
		this.layout = layout;
		this.marks = marks;
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
		final LinkManListDto dto = (LinkManListDto) getItem(position);
		LayoutInflater inflater = LayoutInflater.from(context);
		TableLayout gridLayout = (TableLayout) inflater.inflate(
				layout, null);
		
		if(gridLayout.findViewById(R.id.chanceListName) != null){
			TextView text  = (TextView) gridLayout.findViewById(R.id.chanceListName);
			TextView text1 = (TextView) gridLayout.findViewById(R.id.linkManName);
			TextView text2 = (TextView) gridLayout.findViewById(R.id.vip_linkManPhone);
			TextView text3 = (TextView) gridLayout.findViewById(R.id.vip_linkManScore);
			TextView text4 = (TextView) gridLayout.findViewById(R.id.vip_money);
			BootstrapButton addMoney =(BootstrapButton) gridLayout.findViewById(R.id.weixin_vip_add_money);
			BootstrapButton jianMoney =(BootstrapButton) gridLayout.findViewById(R.id.weixin_vip_jian_money);
			BootstrapButton addScore =(BootstrapButton) gridLayout.findViewById(R.id.weixin_vip_add_score);
			BootstrapButton jianScore =(BootstrapButton) gridLayout.findViewById(R.id.weixin_vip_jian_score);
			BootstrapButton discount =(BootstrapButton) gridLayout.findViewById(R.id.weixin_vip_discount);
			addMoney.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 自动生成的方法存根
					Intent i = new Intent(context, VipUpdateWindowActivity.class);  
					Bundle b = new Bundle(); 
					b.putString("id", String.valueOf(dto.getId()));
					b.putString("money", String.valueOf(dto.getMoney()));
					i.putExtras(b);  
					context.startActivityForResult(i,0);
					context.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
				}
			});
			jianMoney.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 自动生成的方法存根
					Intent i = new Intent(context, VipJianMoneyWindowActivity.class);  
					Bundle b = new Bundle(); 
					b.putString("id", String.valueOf(dto.getId()));
					b.putString("money", String.valueOf(dto.getMoney()));
					i.putExtras(b);  
					context.startActivityForResult(i,0);
					context.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
				}
			});
			addScore.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 自动生成的方法存根
					Intent i = new Intent(context, VipAddScoreWindowActivity.class);  
					Bundle b = new Bundle(); 
					b.putString("id", String.valueOf(dto.getId()));
					b.putString("score", String.valueOf(dto.getLinkManScore()));
					i.putExtras(b);  
					context.startActivityForResult(i,0);
					context.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
				}
			});
			jianScore.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 自动生成的方法存根
					Intent i = new Intent(context, VipJianScoreWindowActivity.class);  
					Bundle b = new Bundle(); 
					
					b.putString("id", String.valueOf(dto.getId()));
					b.putString("score", String.valueOf(dto.getLinkManScore()));
					i.putExtras(b);  
					context.startActivityForResult(i,0);
					context.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
				}
			});
			discount.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 自动生成的方法存根
					Intent i = new Intent(context, VipDiscountWindowActivity.class);  
					Bundle b = new Bundle(); 
					b.putString("id", String.valueOf(dto.getId()));
					i.putExtras(b);  
					context.startActivityForResult(i,0);
					context.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
				}
			});
			text.setText("客户名称："+dto.getChanceListName());
			text1.setText("会员名称："+dto.getLinkManName());
			text2.setText("联系人电话："+dto.getLinkManPhone());
			text3.setText("积分："+dto.getLinkManScore());
			text4.setText("余额："+dto.getMoney());
		}else{
			//初始化DBManager  
	        mgr = new DBManager(context);
			BootstrapButton all =(BootstrapButton)context.findViewById(R.id.message_game_vip_all);
			all.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 发送全部
					Intent inetent = new Intent(context, MessageShowWindow.class);  
					Bundle bundle = new Bundle();
					bundle.putString("type", "1");
					bundle.putString("marks", marks);
					inetent.putExtras(bundle);  
					context.startActivityForResult(inetent,0);
					context.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
				}
			});
			wphonesb = new StringBuffer(); //未选择
			for(int i = 0;i<list.size();i++){
				LinkManListDto dto1 = list.get(i);
				wphonesb.append(dto1.getLinkManPhone()+"|");
			}
			
			BootstrapButton check =(BootstrapButton)context.findViewById(R.id.message_game_vip_send_check);
			BootstrapButton no =(BootstrapButton)context.findViewById(R.id.message_game_vip_send_no);
			link  = (TextView) gridLayout.findViewById(R.id.message_linkManName);
			CheckBox text1 = (CheckBox) gridLayout.findViewById(R.id.message_vip_linkManPhone);
			link.setText("会员名称："+dto.getLinkManName());
			text1.setText(dto.getLinkManPhone());
			phonesb = new StringBuffer();
			linksb = new StringBuffer();
			text1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO 选中时，处理
					switch (buttonView.getId()) {
					case R.id.message_vip_linkManPhone:
						if(isChecked == true){
							phonesb.append(buttonView.getText().toString().trim()+"|");
							linksb.append(dto.getLinkManName()+"|");
//							Toast.makeText(context,"当前选中了"+
//									phonesb.toString(),Toast.LENGTH_LONG).show();
							ArrayList<Person> persons = new ArrayList<Person>();
							Person person = new Person(dto.getLinkManName(), buttonView.getText().toString().trim());
							persons.add(person);
							mgr.add(persons);
						}
						break;

					default:
						break;
					}
				}
			});
			check.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 发送选中
					if(phonesb.length() > 0){
						String phoneStr = phonesb.toString().substring(0, phonesb.toString().length() - 1);
						String phone[] = phoneStr.split("\\|");
						for(int i=0;i<phone.length;i++){
//							Log.e("phone--", phone[i]+""+marks);
							
//							SendMessageThread thread = new SendMessageThread(context, phone[i], marks);
//							thread.start();
						}
						
						query();
						mgr.closeDB();
					}
//					Log.e("linksb--", linksb.toString());
//					Toast.makeText(context,"发送选中了"+
//							phonesb+"/"+getCount(),Toast.LENGTH_LONG).show();
				}
				
				public void query(){
					List<Person> persons = mgr.query();  
			        ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
			        for (Person person : persons) {  
			            HashMap<String, String> map = new HashMap<String, String>();  
			            map.put("name", person.name);  
			            map.put("phone", person.phone+"");  
			            list.add(map);
			            Log.e("name--", person.name);
			        }
				}
			});
			no.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO 发送未选
					Log.e("wphonesb--", wphonesb.toString());
					String wphoneStr = wphonesb.toString().substring(0, wphonesb.toString().length() - 1);
					String wphone[] = wphoneStr.split("\\|");
					String phoneStr = phonesb.toString();
					for(int i=0;i<wphone.length;i++){
						int index = wphone[i].indexOf(phoneStr);
//						Log.e("index--", index+"-"+wphone[i]+"-"+phoneStr);
						if(index > 0){
							Log.e("index--", index+"-"+wphone[i]);
						}
					}
//					Toast.makeText(context,"发送未选了"+
//							phonesb+"/"+getCount(),Toast.LENGTH_LONG).show();
				}
			});
			
		}
		
		return gridLayout;
	}
	
}
