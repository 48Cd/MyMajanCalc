package jp.android.mymajancalc;

import android.app.Activity;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ScrollView;
import android.widget.TextView;
import android.support.v4.widget.DrawerLayout;

public class MainActivity extends Activity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks {

	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;

	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */
	private CharSequence mTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getFragmentManager();
		 if(position == 0){
			 fragmentManager.beginTransaction()
			 .replace(R.id.container, Fragment1.newInstance(position + 1))
			 .commit();
			 }
			 else if(position == 1){
			 fragmentManager.beginTransaction()
			 .replace(R.id.container, Fragment2.newInstance(position + 1))
			 .commit();
			 }
			 else if(position == 2){
			 fragmentManager.beginTransaction()
			 .replace(R.id.container, Fragment3.newInstance(position + 1))
			 .commit();
			 }
	}

	public void onSectionAttached(int number) {
		switch (number) {
		case 1:
			mTitle = getString(R.string.title_section1);
			break;
		case 2:
			mTitle = getString(R.string.title_section2);
			break;
		case 3:
			mTitle = getString(R.string.title_section3);
			break;
		}
	}

	public void restoreActionBar() {
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.main, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this, Preferences.class);
            startActivityForResult(intent, 0);
		return true;
	}
	else if (id == R.id.action_note){
        TextView tv = new TextView(this);
        tv.setAutoLinkMask(Linkify.WEB_URLS);
        String str = this.getString(R.string.note);
        tv.setText(str);

        ScrollView sv = new ScrollView(this);
        sv.addView(tv);
		
		 AlertDialog.Builder alertDialog_note=new AlertDialog.Builder(this);
	        alertDialog_note.setTitle("note");      //タイトル設定

	        alertDialog_note.setView(sv);
	        alertDialog_note.setPositiveButton("OK", new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog, int which) {
	                // OKボタン押下時の処理
	                Log.d("alertDialog_note", "Positive which :" + which);
	            }		        // OK(肯定的な)ボタンの設定
	        });
	        alertDialog_note.show();
		}
		return super.onOptionsItemSelected(item);
	}
}
