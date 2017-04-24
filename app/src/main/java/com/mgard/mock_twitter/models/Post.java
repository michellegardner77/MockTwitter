package com.mgard.mock_twitter.models;

import java.util.Date;

/**
 * Created by mgard on 3/5/2017.
 */

public class Post {
    private String postText;

    private String submitter;

    private Date submitDate;

    public Post (String postText, String submitter, Date submitDate){
        this.postText = postText;
        this.submitter =  submitter;
        this.submitDate = submitDate;
    }

    public Post (String postText, String submitter){
        this.postText = postText;
        this.submitter =  submitter;
        this.submitDate = new Date();
    }


    public String getPostText() {
        return postText;
    }

    public String getSubmitter() {
        return submitter;
    }

    public Date getSubmitDate() {
        return submitDate;
    }
}
