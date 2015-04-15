package jp.android.mymajancalc;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment1 extends Fragment {
	private static final String ARG_SECTION_NUMBER = "section_number";

	 public static Fragment1 newInstance(int sectionNumber) {
		 Fragment1 fragment = new Fragment1();
		 Bundle args = new Bundle();
		  
		 args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		 fragment.setArguments(args);
		 return fragment;
		 }
	 
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
	 super.onCreate(savedInstanceState);
	 }
	 
	 
	@Override
	public View onCreateView(
		LayoutInflater inflater, 
		ViewGroup container, 
		Bundle savedInstanceState) {
		
		View v = inflater.inflate(R.layout.fragment1, container, false);
		calc(v);

		return v;
	}
	
	private void calc(View v) {
			//TextViewのIDを取得		
			int[] textviewids = {
					R.id.TextView15,R.id.TextView25,R.id.TextView35,R.id.TextView45,R.id.TextView55,R.id.TextView65, //各GAMEのCHECK列 0-5
					R.id.TextView71,R.id.TextView72,R.id.TextView73,R.id.TextView74,//PT_SUM行 6-9
					R.id.TextView81,R.id.TextView82,R.id.TextView83,R.id.TextView84,//CHARGE行 10-13
					R.id.TextView91,R.id.TextView92,R.id.TextView93,R.id.TextView94,//PT_SUM行 14-17
					};

				    final TextView[] textviews = new TextView[textviewids.length];

				    for (int i = 0; i < textviewids.length; i++) {
				        textviews[i] = (TextView)v.findViewById(textviewids[i]);
				    }
				    
			//EditTextのIDを取得
			int[] edittextids = {
					R.id.EditText11,R.id.EditText12,R.id.EditText13,R.id.EditText14, //GAME1列 0-3
					R.id.EditText21,R.id.EditText22,R.id.EditText23,R.id.EditText24, //GAME2列 4-7
					R.id.EditText31,R.id.EditText32,R.id.EditText33,R.id.EditText34, //GAME3列 8-11
					R.id.EditText41,R.id.EditText42,R.id.EditText43,R.id.EditText44, //GAME4列 12-15
					R.id.EditText51,R.id.EditText52,R.id.EditText53,R.id.EditText54, //GAME5列 16-19
					R.id.EditText61,R.id.EditText62,R.id.EditText63,R.id.EditText64, //GAME6列 20-23
					R.id.EditText85, //CHARGE 24
			};

				final EditText[] edittexts = new EditText[edittextids.length];

			for (int i = 0; i < edittextids.length; i++) {
				edittexts[i] = (EditText) v.findViewById(edittextids[i]);
			}
			// Onkeyリスナー定義
			View.OnKeyListener calckl = new View.OnKeyListener() {

			  @Override
			  public boolean onKey(View v, int keyCode, KeyEvent event) {

			    // EnterKeyが押されたかを判定
			    if (event.getAction() == KeyEvent.ACTION_DOWN&&keyCode == KeyEvent.KEYCODE_ENTER)
			    {
			    	SharedPreferences spf = PreferenceManager.getDefaultSharedPreferences(getActivity());
					
			    	int pt11,pt12,pt13,pt14,pt21,pt22,pt23,pt24,pt31,pt32,pt33,pt34,
					pt41,pt42,pt43,pt44,pt51,pt52,pt53,pt54,pt61,pt62,pt63,pt64,Charge = 0;
					
					int rate = 0;
					
					rate = Integer.parseInt(spf.getString("list_rate_preference", "0"));
					
					pt11 = Integer.parseInt(edittexts[0].getText().toString());
					pt12 = Integer.parseInt(edittexts[1].getText().toString());
					pt13 = Integer.parseInt(edittexts[2].getText().toString());
					pt14 = Integer.parseInt(edittexts[3].getText().toString());
					pt21 = Integer.parseInt(edittexts[4].getText().toString());
					pt22 = Integer.parseInt(edittexts[5].getText().toString());
					pt23 = Integer.parseInt(edittexts[6].getText().toString());
					pt24 = Integer.parseInt(edittexts[7].getText().toString());
					pt31 = Integer.parseInt(edittexts[8].getText().toString());
					pt32 = Integer.parseInt(edittexts[9].getText().toString());
					pt33 = Integer.parseInt(edittexts[10].getText().toString());
					pt34 = Integer.parseInt(edittexts[11].getText().toString());
					pt41 = Integer.parseInt(edittexts[12].getText().toString());
					pt42 = Integer.parseInt(edittexts[13].getText().toString());
					pt43 = Integer.parseInt(edittexts[14].getText().toString());
					pt44 = Integer.parseInt(edittexts[15].getText().toString());
					pt51 = Integer.parseInt(edittexts[16].getText().toString());
					pt52 = Integer.parseInt(edittexts[17].getText().toString());
					pt53 = Integer.parseInt(edittexts[18].getText().toString());
					pt54 = Integer.parseInt(edittexts[19].getText().toString());
					pt61 = Integer.parseInt(edittexts[20].getText().toString());
					pt62 = Integer.parseInt(edittexts[21].getText().toString());
					pt63 = Integer.parseInt(edittexts[22].getText().toString());
					pt64 = Integer.parseInt(edittexts[23].getText().toString());
					Charge   = Integer.parseInt(edittexts[24].getText().toString());

			      // CHARGEの計算
			    	int p_Charge = Charge/4;
			    	textviews[10].setText(Integer.toString(p_Charge));
			    	textviews[11].setText(Integer.toString(p_Charge));
			    	textviews[12].setText(Integer.toString(p_Charge));
			    	textviews[13].setText(Integer.toString(p_Charge));
		    	
			    	//GAME行の計算1と判定
			    	int pt1 = pt11+pt12+pt13+pt14; 
			    	if (pt1 == 0) {
			    		textviews[0].setBackgroundColor(Color.GREEN);
			    		textviews[0].setText("OK!");		    			    		
			    	}else {
			    		textviews[0].setBackgroundColor(Color.RED);
			    		textviews[0].setText(Integer.toString(pt1));
			    	};
			    	//GAME行の計算2と判定
			    	int pt2 = pt21+pt22+pt23+pt24;
			    	if (pt2 == 0) {
			    		textviews[1].setBackgroundColor(Color.GREEN);
			    		textviews[1].setText("OK!");		    			    		
			    	}else {
			    		textviews[1].setBackgroundColor(Color.RED);
			    		textviews[1].setText(Integer.toString(pt2));
			    	};
			    	//GAME行の計算3
			    	int pt3 = pt31+pt32+pt33+pt34; 
			    	if (pt3 == 0) {
			    		textviews[2].setBackgroundColor(Color.GREEN);
			    		textviews[2].setText("OK!");		    			    		
			    	}else {
			    		textviews[2].setBackgroundColor(Color.RED);
			    		textviews[2].setText(Integer.toString(pt3));
			    	};
			    	//GAME行の計算4
			    	int pt4 = pt41+pt42+pt43+pt44; 
			    	if (pt4 == 0) {
			    		textviews[3].setBackgroundColor(Color.GREEN);
			    		textviews[3].setText("OK!");		    			    		
			    	}else {
			    		textviews[3].setBackgroundColor(Color.RED);
			    		textviews[3].setText(Integer.toString(pt4));
			    	};
			    	//GAME行の計算5
			    	int pt5 = pt51+pt52+pt53+pt54; 
			    	if (pt5 == 0) {
			    		textviews[4].setBackgroundColor(Color.GREEN);
			    		textviews[4].setText("OK!");		    			    		
			    	}else {
			    		textviews[4].setBackgroundColor(Color.RED);
			    		textviews[4].setText(Integer.toString(pt5));
			    	};
			    	//GAME行の計算6
			    	int pt6 = pt61+pt62+pt63+pt64; 
			    	if (pt6 == 0) {
			    		textviews[5].setBackgroundColor(Color.GREEN);
			    		textviews[5].setText("OK!");		    			    		
			    	}else {
			    		textviews[5].setBackgroundColor(Color.RED);
			    		textviews[5].setText(Integer.toString(pt6));
			    	};
			    	
			    	//NAME1プレイヤーのPT_SUM	    	
			    	int ptsum1 = pt11+pt21+pt31+pt41+pt51+pt61;
			    	textviews[6].setText(Integer.toString(ptsum1));
			    	//NAME2プレイヤーのPT_SUM	    	
			    	int ptsum2 = pt12+pt22+pt32+pt42+pt52+pt62;
			    	textviews[7].setText(Integer.toString(ptsum2));
			    	//NAME3プレイヤーのPT_SUM	    	
			    	int ptsum3 = pt13+pt23+pt33+pt43+pt53+pt63;
			    	textviews[8].setText(Integer.toString(ptsum3));
			    	//NAME4プレイヤーのPT_SUM	    	
			    	int ptsum4 = pt14+pt24+pt34+pt44+pt54+pt64;
			    	textviews[9].setText(Integer.toString(ptsum4));

			    	//NAME1プレイヤーのresult	    	
			    	int result1 = (ptsum1 * (rate * 10)) - p_Charge;
			    	textviews[14].setText(Integer.toString(result1));
			    	//NAME2プレイヤーのresult	    	
			    	int result2 = (ptsum2 * (rate * 10)) - p_Charge;
			    	textviews[15].setText(Integer.toString(result2));
			    	//NAME3プレイヤーのresult	    	
			    	int result3 = (ptsum3 * (rate * 10)) - p_Charge;
			    	textviews[16].setText(Integer.toString(result3));
			    	//NAME4プレイヤーのresult	    	
			    	int result4 = (ptsum4 * (rate * 10)) - p_Charge;
			    	textviews[17].setText(Integer.toString(result4));
			    	
			      return true;
			    }
			    return false;
			  }
			};
			
			edittexts[24].setOnKeyListener(calckl);
			edittexts[3].setOnKeyListener(calckl);
		
	}

	@Override
	 public void onAttach(Activity activity) {
	 super.onAttach(activity);
	 ((MainActivity) activity).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));
	 }

}
