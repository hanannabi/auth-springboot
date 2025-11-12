package com.example.storyEndPoint.dto.response;

public class ProgramResponse {
    private Long pageId;
    private String name;

    public ProgramResponse(Long pageId, String name) {
        this.pageId = pageId;
        this.name = name;
    }

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
