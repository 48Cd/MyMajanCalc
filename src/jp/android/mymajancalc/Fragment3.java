package jp.android.mymajancalc;

import android.app.Activity;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment3 extends Fragment {
	private static final String ARG_SECTION_NUMBER = "section_number";

	 public static Fragment3 newInstance(int sectionNumber) {
		 Fragment3 fragment = new Fragment3();
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
		
		View v = inflater.inflate(R.layout.fragment3, container, false);
		
        SharedPreferences spf = PreferenceManager.getDefaultSharedPreferences(getActivity());
		
        // ƒŠƒXƒg
        TextView tvListValue1 = (TextView)v.findViewById(R.id.list_rate_value);
        String listValue1 = spf.getString("list_rate_preference", "0");
        tvListValue1.setText(listValue1);

        TextView tvListValue2 = (TextView)v.findViewById(R.id.list_return_value);
        String listValue2 = spf.getString("list_return_preference", "0");
        tvListValue2.setText(listValue2);

        TextView tvListValue3 = (TextView)v.findViewById(R.id.list_bonus_value);
        String listValue3 = spf.getString("list_bonus_preference", "0");
        tvListValue3.setText(listValue3);
        
        TextView tvSwitchValue = (TextView)v.findViewById(R.id.switch_changePT_value);
        boolean switchValue = spf.getBoolean("switch_changePT_preference", false);
        tvSwitchValue.setText(String.valueOf(switchValue));
		
		return v;
		
		
	}
	 @Override
	 public void onAttach(Activity activity) {
	 super.onAttach(activity);
	 ((MainActivity) activity).onSectionAttached( getArguments().getInt(ARG_SECTION_NUMBER));
	 }
	 
}
