package com.example.demoProject.model.pojo;

import java.util.List;

import lombok.Data;

@Data
public class Post {
    private int id;
    private String title;
    private String body;
    private int userId;
    private List<String> tags;
    private int reactions;
}
