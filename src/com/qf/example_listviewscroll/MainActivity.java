package com.qf.example_listviewscroll;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private ListView lv;
	private int page =0;
	private List<String> datas;
	private ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}
	private void init() {
		lv = (ListView) findViewById(R.id.lv);
		datas = new ArrayList<String >();
		getDatas();
		ImageView imgv = new ImageView(getApplicationContext());
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		imgv.setLayoutParams(params);
		lv.addHeaderView(imgv);
		adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, datas);
		lv.setAdapter(adapter);
	}
	private void getDatas() {
		// TODO Auto-generated method stub
		for(int i =page*30;i<(page+1)*30;i++){
			datas.add("  item  "+i);
		}
		page++;
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if(keyCode== KeyEvent.KEYCODE_MENU){
			getDatas();
			//lv.setAdapter(adapter);
			adapter.notifyDataSetChanged();
		}
		return super.onKeyDown(keyCode, event);
	}
}