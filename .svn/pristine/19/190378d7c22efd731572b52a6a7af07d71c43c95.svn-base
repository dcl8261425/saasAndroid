package com.herotculb.qunhaichat.messageinfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.SmsManager;
import android.widget.Toast;

import com.herotculb.qunhaichat.dto.LinkManListDto;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

/**
 * 会员管理的 Thread 与主程序的通讯
 * @author Administrator
 *
 */
public class MessageSendAllThread extends Thread {
	private Context context;
	private Handler handler;
	private String message;
	
	public static int STUTA_GET_VIP_LIST=1;//开始获取新的一组vip信息
	public static int STUTA_SEND_VIP_ITEM_START=2;//开始向单个会员发送
	public static int STUTA_SEND_VIP_ITEM_FAIL=3;//发送失败
	public static int STUTA_SEND_VIP_ITEM_SUCCESS=4;//发送成功
	public static int STUTA_SEND_VIP_ALL_END=5;//全部发送完毕
	
	String type;
	
	public MessageSendAllThread(Context context, Handler handler,String message) {
		super();
		this.context = context;
		this.handler = handler;
		this.message = message;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		//这里是为了告诉handler 我开始获取数据了
		Map<String,Object> map1=new HashMap<String,Object>();
		map1.put("type",STUTA_GET_VIP_LIST);
		Message sendmsg = Message.obtain();  
		sendmsg.obj = map1;   //利用Message.obj把子线程的handle传递给主线程。  
		handler.sendMessage(sendmsg); 
				
		List<Map<String, Object>> list=qnpAPi.getVip("1", "10", "");
		Map<String,Object> map=list.iterator().next();
		//取出总页数
		int pagenum = (Integer)map.get("pagenum");
		for(int i=2;i<=pagenum;i++){
			List<LinkManListDto> linkList = (List<LinkManListDto>)map.get("data");
			for(int j=0;j<linkList.size();j++){
				LinkManListDto dto = linkList.get(j);
				//开始向单个会员发送
				map1.put("type",STUTA_SEND_VIP_ITEM_START);
				map1.put("dto",dto);
				sendmsg = Message.obtain();  
				sendmsg.obj = map1;   //利用Message.obj把子线程的handle传递给主线程。  
				handler.sendMessage(sendmsg); 
				
			}
			
			//这里的nowpage换成  i
			//这里是为了告诉handler 我开始获取数据了
			map1.put("type",STUTA_GET_VIP_LIST);
			sendmsg = Message.obtain();  
			sendmsg.obj = map1;   //利用Message.obj把子线程的handle传递给主线程。  
			handler.sendMessage(sendmsg); 
			
			List<Map<String, Object>> list1=qnpAPi.getVip(String.valueOf(i), "10", "");
			map=list1.iterator().next();
		}
		//全部循环完成后就发送
			map1.put("type",STUTA_SEND_VIP_ALL_END);
			sendmsg = Message.obtain();  
			sendmsg.obj = map1;   //利用Message.obj把子线程的handle传递给主线程。  
			handler.sendMessage(sendmsg);
		
	}
	
	/** 
     * 直接调用短信接口发短信 
     * @param phoneNumber 
     * @param message 
     */  
	public void sendSMS(String phoneNumber,String message){  

		//处理返回的发送状态   
		String SENT_SMS_ACTION = "SENT_SMS_ACTION";  
		Intent sentIntent = new Intent(SENT_SMS_ACTION);  
		PendingIntent sentPI = PendingIntent.getBroadcast(context, 0, sentIntent,  
		        0);  
		// register the Broadcast Receivers  
		context.registerReceiver(new BroadcastReceiver() {  
		    @Override  
		    public void onReceive(Context _context, Intent _intent) {  
		        switch (getResultCode()) {  
		        case Activity.RESULT_OK:  
		            Toast.makeText(context,  
		        "短信发送成功", Toast.LENGTH_SHORT)  
		        .show();  
		        break;  
		        case SmsManager.RESULT_ERROR_GENERIC_FAILURE:  
		        break;  
		        case SmsManager.RESULT_ERROR_RADIO_OFF:  
		        break;  
		        case SmsManager.RESULT_ERROR_NULL_PDU:  
		        break;  
		        }  
		    }  
		}, new IntentFilter(SENT_SMS_ACTION)); 
		
		//处理返回的接收状态   
		String DELIVERED_SMS_ACTION = "DELIVERED_SMS_ACTION";  
		// create the deilverIntent parameter  
		Intent deliverIntent = new Intent(DELIVERED_SMS_ACTION);  
		PendingIntent deliverPI = PendingIntent.getBroadcast(context, 0,  
		       deliverIntent, 0);  
		context.registerReceiver(new BroadcastReceiver() {  
		   @Override  
		   public void onReceive(Context _context, Intent _intent) {  
		       Toast.makeText(context,  
		  "收信人已经成功接收", Toast.LENGTH_SHORT)  
		  .show();  
		   }  
		}, new IntentFilter(DELIVERED_SMS_ACTION));
		
        //获取短信管理器   
        android.telephony.SmsManager smsManager = android.telephony.SmsManager.getDefault();  
        //拆分短信内容（手机短信长度限制）    
        List<String> divideContents = smsManager.divideMessage(message);   
        for (String text : divideContents) {    
            smsManager.sendTextMessage(phoneNumber, null, text, sentPI, deliverPI);    
        }  
    }
	
}
