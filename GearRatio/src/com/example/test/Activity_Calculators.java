package com.example.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Activity_Calculators extends Activity implements OnItemClickListener {
	
	ListView ls;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculators);
		
		
		
		String[] calcList= new String[] {"Crawl Ratio", "Tire Size Converter", 
				"R+P Gear Finder", "MPH Offset", "Engine RPM"};

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	              android.R.layout.simple_list_item_1, android.R.id.text1, calcList);
		ls = new ListView(this);
		ls=(ListView) findViewById(R.id.list_calcs);
		ls.setAdapter(adapter);
		ls.setOnItemClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
		// TODO Auto-generated method stub
		
		id = ls.getSelectedItemId();
		
        switch(position)
        {
        
        	 case 0:
        		 System.out.println("made it to case 0 crawl ratio");
                 Intent i1 = new Intent(Activity_Calculators.this, Activity_CrawlRatio.class);
                 startActivity(i1);
        		 
        		 //RING AND PINION CASE, ETC ETC
        		 //next let's do the crawl ratio which is simple. then we will move to storing data
        		 //for the calculators as in rig data to be saved (saved rigs) then we will do the 
        		 //mph offset, gear finder, engine rpm, etc
                 break;
             
             case 1:
                 Intent i2 = new Intent(Activity_Calculators.this, Activity_TireConverter.class);
                 startActivity(i2);
                 break;

             

             //And so on and so forth....
        }
		
	}

}
