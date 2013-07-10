package net.example.usecontentprovider;

import net.example.usecontentprovider.R;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
    private static final Uri CONTENT_URI = Uri.parse("content://com.example.contentprovider.Provider");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        final TextView textview1 = (TextView) findViewById(R.id.textview1);
        final String[] columnQuery = new String[] { "_id" };
        Cursor whereCursor = managedQuery(CONTENT_URI, columnQuery, null, null, null);
        whereCursor.moveToFirst();

        textview1.setText("count:" + whereCursor.getCount());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
