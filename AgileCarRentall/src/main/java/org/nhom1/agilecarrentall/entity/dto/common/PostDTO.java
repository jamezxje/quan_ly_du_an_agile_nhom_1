package org.nhom1.agilecarrentall.entity.dto.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.nhom1.agilecarrentall.entity.type.PostStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private Integer postId;
    private String postTitle;
    private String postSlug;
    private String postContent;
    private PostStatus postStatus;
    private String postFeaturedImageUrl = "";
    private String author;
    private LocalDateTime updatedAt;
}
