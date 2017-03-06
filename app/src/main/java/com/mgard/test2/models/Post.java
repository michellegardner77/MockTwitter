package com.mgard.test2.models;

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
