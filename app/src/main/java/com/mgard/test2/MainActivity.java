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
import android.widget.EditText;
import android.widget.ListView;

import com.mgard.test2.models.Post;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    // Data Source ; a blank array list
    private ArrayList<Post> postArrayList = new ArrayList<>();


    // Adapter (I hope)
//        // app context, layout that contains a TextView for each string in the array, the string array
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, postArrayList);
//
//        ListView listView = (ListView) findViewById(R.id.list);
//        listView.setAdapter(adapter);
//    }

    public final static String EXTRA_MESSAGE = "com.mgard.test2.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*
        mListView = (ListView) findViewById(R.id.recipe_list_view);

        // 1
        final ArrayList<Recipe> recipeList = Recipe.getRecipesFromFile("recipes.json", this);


        // 2
        String[] listItems = new String[recipeList.size()];

        // 3
        for(int i = 0; i < recipeList.size(); i++){
            Recipe recipe = recipeList.get(i);
            listItems[i] = recipe.title;
        }

        // 4
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems);
        mListView.setAdapter(adapter);
        */


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
            Intent aboutIntent = new Intent (this, MainActivity.class);
            startActivity(aboutIntent);
        }

        if (id == R.id.list){
            Intent aboutIntent = new Intent(this, ListViewLoader.class);
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
    // Will send the message to a new activity (new page)
    public void sendPost(View view) {

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String enteredPostText = editText.getText().toString();

        Post newPost = new Post(enteredPostText, "User1", new Date());

        postArrayList.add(newPost);

        for (Post post: postArrayList) {
            System.out.println(post.getPostText());
        }


        intent.putExtra(EXTRA_MESSAGE, enteredPostText);
        startActivity(intent);

    }

}
