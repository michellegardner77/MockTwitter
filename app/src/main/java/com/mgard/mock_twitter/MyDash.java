package com.mgard.mock_twitter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.mgard.mock_twitter.models.Post;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by mgard on 4/23/2017.
 */


// Will be like a homepage for user
public class MyDash extends AppCompatActivity {

    private ArrayList<Post> postArrayList = new ArrayList<>();

    ListAdapter postsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_dash_activity);

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
        ListView postsListView = (ListView) findViewById(R.id.my_dash_list);
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
        ListView list = (ListView) findViewById(R.id.my_dash_list);
        list.setAdapter(adapter);
    }

}
