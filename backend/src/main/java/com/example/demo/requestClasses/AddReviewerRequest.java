package com.example.demo.requestClasses;

import java.util.List;

public class AddReviewerRequest {
    Long paperId;
    String username;
    List<Long> userIds;

    public Long getPaperId(){
        return this.paperId;
    }
    public String getUsername(){
        return this.username;
    }
    public List<Long> getUserIds(){
        return this.userIds;
    }
    
    public void setPaperId(Long paperId){
        this.paperId=paperId;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public void setUserIds(List<Long> userIds){
        this.userIds=userIds;
    }
}
