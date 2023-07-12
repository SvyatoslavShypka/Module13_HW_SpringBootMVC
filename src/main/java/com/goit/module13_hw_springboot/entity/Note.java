package com.goit.module13_hw_springboot.entity;

import lombok.Data;

@Data
//@Component
public class Note {

    private Long id;
    private String title;
    private String content;

    public Note() {
    }

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
