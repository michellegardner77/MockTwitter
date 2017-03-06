package com.mgard.test2;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;


/* Tutorial for List View, but with Contacts as the example.
 I want to use List View to see posts.
 */


public class ListViewLoader extends ListActivity
        implements LoaderManager.LoaderCallbacks<Cursor> {

        //this is the Adapter being used to display the list's data
        SimpleCursorAdapter mAdapter;

        // These are the Contacts rows that we will retrieve
        // Granted for my projects I want to use LIST View for posting statuses, not contacts
        static final String[] PROJECTION = new String[] {ContactsContract.Data._ID, ContactsContract.Data.DISPLAY_NAME};

        // This is the select criteria
        static final String SELECTION = "((" + ContactsContract.Data.DISPLAY_NAME + "  NOTNULL) AND (" + ContactsContract.Data.DISPLAY_NAME + " != '' ))";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        // Create a progress bar to display while the list laods
        ProgressBar progressBar = new ProgressBar(this);
        progressBar.setLayoutParams(new ActionBar.LayoutParams(android.app.ActionBar.LayoutParams.WRAP_CONTENT, android.app.ActionBar.LayoutParams.WRAP_CONTENT, Gravity.CENTER));
        progressBar.setIndeterminate(true);
        getListView().setEmptyView(progressBar);

        // Must add the progress bar to the root of the layout
        ViewGroup root = (ViewGroup) findViewById(android.R.id.content);
        root.addView(progressBar);

        // For the cursor adapter, specify which columns go into which views
        String[] fromColumns = {ContactsContract.Data.DISPLAY_NAME};
        int[] toViews = {android.R.id.text1}; // the TextView in simple_list_item1

        // Create an empty adapter we will use to display the load data
        // we pass null for the cursor, then update it in onLoadFinished()
        mAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, null, fromColumns, toViews, 0);

        setListAdapter(mAdapter);

        // Prepare the loader. Either re-connect with an existing one, or start a new one
        getLoaderManager().initLoader(0, null, this);

    }

    // Called when a new Loader needs to be created
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        // Now create and return a cursorLoader that will take care of creating a Cursor for the dta being displayed
        return new CursorLoader(this, ContactsContract.Data.CONTENT_URI, PROJECTION, SELECTION, null, null);

    }

    // Called when a previously created loader has finished loading
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        // Swap the new cursor in. (the framework will take care of closing the old cursor once we return)
        mAdapter.swapCursor(data);

    }

    // Called when a previously created loader is reset, making the data unavailable
    public void onLoaderReset(Loader<Cursor> loader) {
        // This is called when the last Cursor provided to onLoadFinished()
        // above is about to be closed. We need to make sure we are no
        // longer using it.
        mAdapter.swapCursor(null);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // Do something when a list item is clicked
    }
}
