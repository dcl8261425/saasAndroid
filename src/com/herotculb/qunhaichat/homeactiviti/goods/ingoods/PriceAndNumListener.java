package com.herotculb.qunhaichat.homeactiviti.goods.ingoods;

import android.text.Editable;
import android.text.TextWatcher;

import com.beardedhen.androidbootstrap.BootstrapEditText;

public class PriceAndNumListener implements TextWatcher {
     BootstrapEditText priceView, numView, countprice;
     public PriceAndNumListener(BootstrapEditText priceView,BootstrapEditText numView,BootstrapEditText countprice){
    	 this.priceView=priceView;
    	 this.numView=numView;
    	 this.countprice=countprice;
     }
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub
		String price=priceView.getText().toString();
		String num=numView.getText().toString();
		String cprice=countprice.getText().toString();
		double priceDb;
		double numDb;
		double cpriceDb;
		boolean isSuccess=true;
		try{
			priceDb=Double.parseDouble(price);
		}catch(Exception ex){
			priceDb=0;
			priceView.setText(priceDb+"");
		}
		try{
			numDb=Double.parseDouble(num);
		}catch(Exception ex){
			numDb=0;
			numView.setText(numDb+"");
		}
		try{
			cpriceDb=Double.parseDouble(cprice);
		}catch(Exception ex){
			cpriceDb=0;
			countprice.setText(cpriceDb+"");
		}
		countprice.setText((priceDb*numDb)+"");
	}

}
