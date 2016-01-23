package com.herotculb.qunhaichat.homeactiviti.goods.outgoods;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.google.zxing.WriterException;
import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.dto.OrdersItemDto;
import com.herotculb.qunhaichat.homeactiviti.goods.ingoods.InGoods;
import com.herotculb.qunhaichat.homeactiviti.goods.orderquery.QueryOrderWindow;
import com.herotculb.qunhaichat.homeactiviti.util.window.goodselect.ErWeiMaQueryGoodsWindow;
import com.herotculb.qunhaichat.homeactiviti.util.window.goodselect.QueryGoodsWindow;
import com.herotculb.qunhaichat.print.PrintUtil;
import com.herotculb.qunhaichat.widget.LoadingDialog;
import com.zxing.encoding.EncodingHandler;

public class OutGoods {
	public HomeActivity home;
	public LinearLayout linearLayout;
	public OutGoods(HomeActivity home, LinearLayout linearLayout) {
		this.home = home;
		this.linearLayout = linearLayout;
		//仓库信息
		LinearLayout gridLayout = (LinearLayout) home.inflater.inflate(
				R.layout.good_outgoods, null)
				.findViewById(R.id.good_outgoods_main);
		linearLayout.removeAllViews();
		linearLayout.addView(gridLayout);
		
		BootstrapButton query=(BootstrapButton)OutGoods.this.home.findViewById(R.id.good_outgoods_main_query);
		BootstrapButton erweima=(BootstrapButton)OutGoods.this.home.findViewById(R.id.good_outgoods_main_erweima);
		BootstrapButton save=(BootstrapButton)OutGoods.this.home.findViewById(R.id.good_outgoods_main_save);
		BootstrapButton ruke=(BootstrapButton)OutGoods.this.home.findViewById(R.id.good_outgoods_main_ruku);
		BootstrapButton print=(BootstrapButton)OutGoods.this.home.findViewById(R.id.good_outgoods_main_print);
		BootstrapButton neworder=(BootstrapButton)OutGoods.this.home.findViewById(R.id.good_outgoods_main_newOrder);
		BootstrapButton queryOrder=(BootstrapButton)OutGoods.this.home.findViewById(R.id.good_outgoods_main_query_order);
		queryOrder.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(OutGoods.this.home, QueryOrderWindow.class);  
				Bundle b = new Bundle();  
				b.putString("class", "com.herotculb.qunhaichat.HomeActivity");
				b.putString("type", "OutOrderQuery");
				b.putString("querytype", "OutOrderQuery");
                i.putExtras(b);  
                OutGoods.this.home.startActivityForResult(i, 0);  
                OutGoods.this.home.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
		neworder.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				newOrder();
			}
		});
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if(OutGoods.this.home.isruku){
					 new SweetAlertDialog(OutGoods.this.home, SweetAlertDialog.ERROR_TYPE)
					 .setTitleText("失败")
		             .setContentText("此订单已经入过库不可修改")
		             .setConfirmText("确定")
		             .showCancelButton(false)
		             .setCancelClickListener(null)
		             .setConfirmClickListener(null).show();
					 return ;
				}
				TextView idtext=(TextView) OutGoods.this.home.findViewById(R.id.orderId);
				String id=idtext.getText().toString();
				if(id.trim().equals("")){
					id="0";
				}
				// TODO Auto-generated method stub
				StringBuffer jsonbuff=new StringBuffer();
				jsonbuff.append("[");
				for(int i=0;i<OutGoods.this.home.goodstabledtoList.size();i++){
					if(i!=0){
						jsonbuff.append(",");
					}
					OrdersItemDto ord=OutGoods.this.home.goodstabledtoList.get(i);
					jsonbuff.append("{");
					jsonbuff.append("'name':").append("'").append(ord.getGoodsName()).append("',");
					jsonbuff.append("'type':").append("'").append(ord.getGoodsType()).append("',");
					jsonbuff.append("'price':").append("'").append(ord.getPrice()).append("',");
					jsonbuff.append("'inprice':").append("'").append(ord.getPrice()).append("',");
					jsonbuff.append("'score':").append("'").append(ord.getScore()).append("',");
					jsonbuff.append("'spell':").append("'").append(ord.getSpell()).append("',");
					jsonbuff.append("'model':").append("'").append(ord.getGoodsModel()).append("',");
					jsonbuff.append("'goodRource':").append("'").append(ord.getGoodsSourceName()).append("',");
					jsonbuff.append("'storeHouse':").append("'").append(ord.getGoodsToStorehouseId()).append("',");
					jsonbuff.append("'marks':").append("'").append(ord.getMarks()).append("',");
					jsonbuff.append("'num':").append("'").append(ord.getGoodsNum()).append("',");
					jsonbuff.append("'countPrice':").append("'").append(ord.getCountPrice()).append("'");
					jsonbuff.append("}");
				}
				jsonbuff.append("]");
				LoadingDialog dialog = new LoadingDialog(OutGoods.this.home, "正在获取数据");
				dialog.show();
				SubmitOrderHandler handler=new SubmitOrderHandler(OutGoods.this.home,dialog,true);
				SubmitOrderThread thread=new SubmitOrderThread(OutGoods.this.home,handler,jsonbuff.toString(),true,id);
				thread.start();
			}
		});
		ruke.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(OutGoods.this.home.isruku){
					 new SweetAlertDialog(OutGoods.this.home, SweetAlertDialog.ERROR_TYPE)
					 .setTitleText("失败")
		             .setContentText("此订单已经入过库不可修改")
		             .setConfirmText("确定")
		             .showCancelButton(false)
		             .setCancelClickListener(null)
		             .setConfirmClickListener(null).show();
					 return ;
				}
				TextView idtext=(TextView) OutGoods.this.home.findViewById(R.id.orderId);
				String id=idtext.getText().toString();
				if(id.trim().equals("")){
					id="0";
				}
				// TODO Auto-generated method stub
				StringBuffer jsonbuff=new StringBuffer();
				jsonbuff.append("[");
				for(int i=0;i<OutGoods.this.home.goodstabledtoList.size();i++){
					if(i!=0){
						jsonbuff.append(",");
					}
					OrdersItemDto ord=OutGoods.this.home.goodstabledtoList.get(i);
					jsonbuff.append("{");
					jsonbuff.append("'name':").append("'").append(ord.getGoodsName()).append("',");
					jsonbuff.append("'type':").append("'").append(ord.getGoodsType()).append("',");
					jsonbuff.append("'price':").append("'").append(ord.getPrice()).append("',");
					jsonbuff.append("'inprice':").append("'").append(ord.getPrice()).append("',");
					jsonbuff.append("'score':").append("'").append(ord.getScore()).append("',");
					jsonbuff.append("'spell':").append("'").append(ord.getSpell()).append("',");
					jsonbuff.append("'model':").append("'").append(ord.getGoodsModel()).append("',");
					jsonbuff.append("'goodRource':").append("'").append(ord.getGoodsSourceName()).append("',");
					jsonbuff.append("'storeHouse':").append("'").append(ord.getGoodsToStorehouseId()).append("',");
					jsonbuff.append("'marks':").append("'").append(ord.getMarks()).append("',");
					jsonbuff.append("'num':").append("'").append(ord.getGoodsNum()).append("',");
					jsonbuff.append("'countPrice':").append("'").append(ord.getCountPrice()).append("'");
					jsonbuff.append("}");
				}
				jsonbuff.append("]");
				LoadingDialog dialog = new LoadingDialog(OutGoods.this.home, "正在获取数据");
				dialog.show();
				SubmitOrderHandler handler=new SubmitOrderHandler(OutGoods.this.home,dialog,false);
				SubmitOrderThread thread=new SubmitOrderThread(OutGoods.this.home,handler,jsonbuff.toString(),false,id);
				thread.start();
			}
		});
		print.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				PrintUtil print=PrintUtil.getPrintUtil(OutGoods.this.home);
				if(!print.isLink()){
					print.linkPrint(null);
				}
				print.printText("\n\n");
				;
				TextView scoreNum=(TextView) OutGoods.this.home.findViewById(R.id.good_ingoods_scoreNum);
	     		String num=scoreNum.getText().toString();
	     		TextView scoreStr=(TextView) OutGoods.this.home.findViewById(R.id.good_ingoods_scoreStr);
				if(scoreStr.getText().toString().trim().equals("")){
					 new SweetAlertDialog(OutGoods.this.home, SweetAlertDialog.SUCCESS_TYPE)
					 .setTitleText("成功")
		             .setContentText("请入库订单之后才可以打印销售订单")
		             .setConfirmText("确定")
		             .showCancelButton(false)
		             .setCancelClickListener(null)
		             .setConfirmClickListener(null).show();
					 return ;
				}
				print.printText("品名          数量  单价  总价\n");
				for(int i=0;i<OutGoods.this.home.goodstabledtoList.size();i++){
					OrdersItemDto ord=OutGoods.this.home.goodstabledtoList.get(i);
					print.printText(ord.getGoodsName()+"  "+ord.getGoodsNum()+"  "+ord.getPrice()+"  "+ord.getCountPrice()+"\n");
				}
				TextView conpricettext=(TextView) OutGoods.this.home.findViewById(R.id.good_ingoods_zongjia);
				print.printText(num+"\n");
				print.printText(conpricettext.getText().toString()+"\n");
				print.printText("积分序列号:"+scoreStr.getText().toString()+"\n");
				print.printText("请链接本店wifi下载本店会员app进行积分兑换。\n");
				print.printText("\n\n\n\n\n\n\n\n\n\n");
				
			}
		});
		query.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(OutGoods.this.home.isruku){
					newOrder();
				}
				// TODO Auto-generated method stub
				Intent i = new Intent(OutGoods.this.home, QueryGoodsWindow.class);  
				Bundle b = new Bundle();  
				b.putString("class", "com.herotculb.qunhaichat.HomeActivity");
				b.putString("type", "OutOrderQuery");
                i.putExtras(b);  
                OutGoods.this.home.startActivityForResult(i, 0);  
                OutGoods.this.home.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
		erweima.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(OutGoods.this.home.isruku){
					newOrder();
				}
				// TODO Auto-generated method stub
				Intent i = new Intent(OutGoods.this.home, ErWeiMaQueryGoodsWindow.class);  
				Bundle b = new Bundle();  
				b.putString("class", "com.herotculb.qunhaichat.HomeActivity");
				b.putString("type", "OutOrderQuery");
                i.putExtras(b);  
                OutGoods.this.home.startActivityForResult(i, 0);  
                OutGoods.this.home.overridePendingTransition(R.anim.modal_in, R.anim.modal_out);
			}
		});
	}
	public void newOrder(){
		TextView conpricettext=(TextView) OutGoods.this.home.findViewById(R.id.good_ingoods_zongjia);
		TextView scoreStr=(TextView) OutGoods.this.home.findViewById(R.id.good_ingoods_scoreStr);
		conpricettext.setText("");
		scoreStr.setText("");
			TextView scoreNum=(TextView) OutGoods.this.home.findViewById(R.id.good_ingoods_scoreNum);
 			scoreNum.setText("");
 			TextView idtext=(TextView) OutGoods.this.home.findViewById(R.id.orderId);
 			idtext.setText("0");
 			OutGoods.this.home.isruku=false;
				TableLayout datascroll=(TableLayout)OutGoods.this.home.findViewById(R.id.good_outgoods_data_list);
 			if(OutGoods.this.home.goodstabledtoList!=null){
 				OutGoods.this.home.goodstabledtoList.clear();

 				OutGoods.this.home.showOrderList(datascroll, OutGoods.this.home.goodstabledtoList, OutGoods.this.home);
 			}
			ScrollView scroll=(ScrollView)OutGoods.this.home.findViewById(R.id.good_outgoods_list);
			
			TableRow manager=(TableRow)OutGoods.this.home.findViewById(R.id.good_order_manager);
		 	manager.setVisibility(View.GONE);
		 	datascroll.setVisibility(View.VISIBLE);
		 	scroll.setVisibility(View.GONE);
		 	BootstrapButton save=(BootstrapButton)OutGoods.this.home.findViewById(R.id.good_outgoods_main_save);
			BootstrapButton ruke=(BootstrapButton)OutGoods.this.home.findViewById(R.id.good_outgoods_main_ruku);
			save.setVisibility(View.VISIBLE);
			ruke.setVisibility(View.VISIBLE);
	}
}
