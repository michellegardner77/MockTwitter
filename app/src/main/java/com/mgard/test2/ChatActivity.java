/* Michelle Gardner
   Fund. of Software Engineering
    Spring Semester 2017
 */


package com.mgard.test2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.mgard.test2.models.Post;

import java.util.ArrayList;
import java.util.Date;

public class ChatActivity extends AppCompatActivity {

    // Data Source ; a blank array list
    private ArrayList<Post> postArrayList = new ArrayList<>();

    ListAdapter postsAdapter;

// 4/9 Changed name of Activity to ChatActivity, use to be MainActivity
    // when open the app, first thing user see is Log in screen


    // 3/17
    // Array of options --> ArrayAdapter --> ListView
    // List view: {views: posts.xml}

    public final static String EXTRA_MESSAGE = "com.mgard.test2.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateListView();

        getText();


        // Dumby posts
        for(int i=0; i<5; i++){
            Post newPost = new Post("Post " + i, "User" + i, new Date());
            postArrayList.add(newPost);
        }


        // create an array list of Strings
        //String[] posts = {"post1", "post2", "post3"};

        postsAdapter = new PostsAdapter(this, postArrayList);
        ListView postsListView = (ListView) findViewById(R.id.posts_list_view);
        postsListView.setAdapter(postsAdapter);



    }

    private void getText() {
    }

    private void populateListView() {

        // Create List of items
        String[] myPosts = {};

        // Build Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,               // Context for the activity
                R.layout.posts,    // layout to use
                myPosts);          // items to be displayed
        // Configure list view
        ListView list = (ListView) findViewById(R.id.posts_list_view);
        list.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // inflate the menu; this adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Method handles menu item button clicks
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.action_about) {
            Intent aboutIntent = new Intent(this, AboutActivity.class);
            startActivity(aboutIntent);
        }

        // 3/5 3:55pm
        if (id == R.id.edit_message) {
            Intent aboutIntent = new Intent (this, ChatActivity.class);
            startActivity(aboutIntent);
        }

        return super.onOptionsItemSelected(item);
    }

    // Method called when activity is un-paused
    // This is called when user hits the Back Button or other button to this pause activity
    @Override
    protected void onStart() {
        super.onStart();
        EditText editText = (EditText) findViewById(R.id.edit_message);
        editText.setText("");
    }




    // Called when the user clicks the Send button
    // Will send the message to a new activity (new page) <-- Does not anymore 3/19
    public void sendPost(View view) {
        //Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String enteredPostText = editText.getText().toString();

        // adds post to posts array list and list view if the user entered in text
        if (!enteredPostText.isEmpty()) {
            Post newPost = new Post(enteredPostText, "User1", new Date());

            postArrayList.add(newPost);

            // casts postsAdapter that is an ArrayAdapter to one of its parent class BaseAdapter
            // calls notifyDataSetChanged to tell the adapter the data has changed
            // this will update the UI to reflect the change data
            ((BaseAdapter) postsAdapter).notifyDataSetChanged();

            //intent.putExtra(EXTRA_MESSAGE, enteredPostText);
            //startActivity(intent);

            // clear the text box after user enters in data
            editText.setText("");
        }

    }

}
