package com.derekmorrison.saveclassess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private String mUserName = "Dilbert";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button saveButton = (Button) findViewById(R.id.save_button);
        final EditText commentText = (EditText) findViewById(R.id.commentText);

        // get the user name from the phone
        // mUserName = ...

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ensure that there is a comment to get
                if (null != commentText.getText()) {

                    String comment = commentText.getText().toString();

                    if (comment.length() > 0) {
                        Comment newComment = new Comment(comment, mUserName);
                        SaveClass_IntentService.saveCommentToRemote(getApplicationContext(), newComment);
                    }
                }
            }
        });
    }
}
