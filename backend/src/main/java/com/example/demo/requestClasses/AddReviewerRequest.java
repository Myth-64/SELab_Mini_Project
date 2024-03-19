package com.example.demo.requestClasses;

import java.util.List;

public class AddReviewerRequest {
    Long paperId;
    List<Long> userIds;

    public Long getPaperId(){
        return this.paperId;
    }
    public List<Long> getUserIds(){
        return this.userIds;
    }

    public void setPaperId(Long paperId){
        this.paperId=paperId;
    }
    public void setUserIds(List<Long> userIds){
        this.userIds=userIds;
    }
}
