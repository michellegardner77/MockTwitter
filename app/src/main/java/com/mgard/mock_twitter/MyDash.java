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

public class MyDash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_dash_activity);

    }
}
