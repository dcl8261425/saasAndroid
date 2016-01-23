package com.herotculb.qunhaichat.messageinfo;

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

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

public class SendMessageThread extends Thread {
	private Activity context;
	private String phoneNumber;
	private String message;
	
	public SendMessageThread(Activity context,String phoneNumber, String message) {
		super();
		this.context = context;
		this.phoneNumber = phoneNumber;
		this.message = message;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
		sendSMS(phoneNumber, message);
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
