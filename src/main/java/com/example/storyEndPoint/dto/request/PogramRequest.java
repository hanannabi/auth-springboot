package com.example.storyEndPoint.dto.request;

public class PogramRequest {
    private String name;

    public PogramRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
