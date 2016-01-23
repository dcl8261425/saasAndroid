package com.herotculb.qunhaichat.print;

import java.util.Vector;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.gprinterio.GpCom.ERROR_CODE;
import com.gprinterio.GpDevice;
import com.gprinterio.PrinterRecieveListener;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.homeactiviti.goods.ingoods.PriceAndNumListener;
import com.herotculb.qunhaichat.widget.LoadingDialog;
import com.printer.EscCommand;

public class PrintUtil implements PrinterRecieveListener{
	private GpDevice mDevice ;
	 private Activity home;
	 private static PrintUtil printUtil;
	 private PrintUtil(Activity home){
		 this.home=home;
		 this.mDevice= new GpDevice();
	 }
	 public static PrintUtil getPrintUtil(Activity home){
		 if(printUtil==null){
			 printUtil=new PrintUtil(home);
		 }
		return printUtil;
		 
	 }
	 public void linkPrint(String address){
		 if(address==null){
			 SharedPreferences preferences = home.getSharedPreferences("usermessage", Activity.MODE_PRIVATE);
			    address = preferences.getString("linkPrintAddress", "");
		 }
		 SharedPreferences mySharedPreferences= home.getSharedPreferences("usermessage", 
					Activity.MODE_PRIVATE); 
			SharedPreferences.Editor editor = mySharedPreferences.edit(); 
			editor.putString("linkPrintAddress", address); 
			editor.commit();
		 if(mDevice==null){
			 mDevice= new GpDevice();
		 }
		 mDevice.registerCallback(this);
		 LoadingDialog dialog = new LoadingDialog(home, "正在链接打印机");
		 dialog.show();
		 mDevice.openBluetoothPort(home, address);//"98:D3:31:70:2B:0E"
		 PrintHandler handler=new PrintHandler(home,dialog);
		 PrintThread thread=new PrintThread(handler, mDevice);
		 thread.start();
	 }
	 public void close(){
		 if(mDevice.isDeviceOpen()){
			 mDevice.closePort();
		 }
	 }
	 public boolean isLink(){
		 if(mDevice==null){
			 return false;
		 }
		 return mDevice.isDeviceOpen();
	 }
	 public void printText(String text){
		 EscCommand esc = new EscCommand();
			esc.addTurnEmphasizedModeOnOrOff(EscCommand.ENABLE.ON);// 加粗模式有效
			esc.addText(text);// 打印文字
			Vector<Byte> Command = new Vector<Byte>(4096, 1024);
			Command = esc.getCommand();// 获得编辑的命令数据
			mDevice.sendDataImmediately(Command);// 发送命令
	 }
	 public void printImage(Bitmap b){
		 EscCommand esc = new EscCommand();
			
			esc.addRastBitImage(b);
			Vector<Byte> Command = new Vector<Byte>(4096, 1024);
			Command = esc.getCommand();
			Vector<Byte> data = new Vector<Byte>(Command.size());
			for (int k = 0; k < Command.size(); k++) {
				if (data.size() >= 1024) {
					mDevice.sendDataImmediately(data);
					data.clear();
				}
				data.add(Command.get(k));
			}
			mDevice.sendDataImmediately(data);
	 }
	 public void printOneMa(String b){
		 EscCommand esc = new EscCommand();
		 esc.addText("UPCA :\n");
			esc.addUPCA(b);
			esc.addText("UPCE :\n");
			esc.addUPCE(b);
			esc.addText("EAN13 :\n");
			esc.addEAN13(b);
			esc.addText("EAN8 :\n");
			esc.addEAN8(b);
			esc.addText("CODE39 :\n");
			esc.addCODE39(b);
			esc.addText("ITF :\n");
			esc.addITF(b);
			esc.addText("CODABAR :\n");
			esc.addCODABAR(b);
			esc.addText("CODE93 :\n");
			esc.addCODE93(b);
			esc.addText("CODE128 :\n");
			esc.addCODE128(b);
			Vector<Byte> Command = new Vector<Byte>(4096, 1024);
			Command = esc.getCommand();
			mDevice.sendDataImmediately(Command);
	 }
		@Override
		public ERROR_CODE ReceiveData(Vector<Byte> receiveBuffer) {
			// TODO Auto-generated method stub
			
			Log.e("", "receiveBuffer" + receiveBuffer.toString());
			return null;
		}

}
