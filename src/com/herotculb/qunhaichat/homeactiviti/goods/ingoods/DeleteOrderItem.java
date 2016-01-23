package com.herotculb.qunhaichat.homeactiviti.goods.ingoods;

import java.util.List;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TableLayout;

import com.herotculb.qunhaichat.HomeActivity;
import com.herotculb.qunhaichat.dto.OrdersItemDto;

public class DeleteOrderItem implements OnClickListener {
	private int index;
	private HomeActivity act;
	private List<OrdersItemDto> list;
	private TableLayout toView;
	public DeleteOrderItem(TableLayout toView,List<OrdersItemDto> list,HomeActivity act,int index){
		this.index=index;
		this.act=act;
		this.list=list;
		this.toView=toView;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		list.remove(index);
		act.showOrderList(toView, list, act);
	}

}
