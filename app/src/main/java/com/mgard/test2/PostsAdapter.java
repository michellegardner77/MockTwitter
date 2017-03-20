package com.mgard.test2;

import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mgard.test2.models.Post;

import java.util.ArrayList;


/**
 * Created by mgard on 3/19/2017.
 */

public class PostsAdapter extends ArrayAdapter<Post> {

    // "context" is background information
    public PostsAdapter(Context context, ArrayList<Post> posts){
        super(context, R.layout.posts_custom_row, posts); // for each individual row, use post custom row
    }

    @Override
    public View getView(int position, View ConvertView, ViewGroup parent){
        LayoutInflater postsInflater = LayoutInflater.from(getContext());
        View postView = postsInflater.inflate(R.layout.posts_custom_row, parent, false); // will see the USER ID & TEXT as one big row

        //now need reference to string / array
        Post singlePostObject = getItem(position);

        String postText = "";
        String postSubmitter = "";
        String postSubmittedDate = "";

        // if not null, it'll get the necessary items
        if (singlePostObject != null) {
            postText = singlePostObject.getPostText();
            postSubmitter = singlePostObject.getSubmitter();
            postSubmittedDate = singlePostObject.getSubmitDate().toString();
        }

        TextView submittedPostTextView = (TextView) postView.findViewById(R.id.submittedPost);
        TextView submitterInfoTextView = (TextView) postView.findViewById(R.id.submitterInfo);
        TextView postSubmittedDateTextView = (TextView) postView.findViewById(R.id.submittedDate);

        // shows text in appropriate fields
        postSubmittedDateTextView.setText(postSubmittedDate);
        submittedPostTextView.setText(postText);
        submitterInfoTextView.setText(postSubmitter);

        return postView;
    }

}
