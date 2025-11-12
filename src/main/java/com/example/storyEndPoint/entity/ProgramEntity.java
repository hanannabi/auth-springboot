package com.example.storyEndPoint.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "program")
public class ProgramEntity {

    @Column(name = "page_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pageId;

    @Column(name = "name")
    private String name;

    public ProgramEntity(){}

    public ProgramEntity(String name) {
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
