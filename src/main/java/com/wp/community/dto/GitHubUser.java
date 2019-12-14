package com.wp.community.dto;

import lombok.Data;

@Data
public class GitHubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUurl;
}
