package org.nhom1.agilecarrentall.service.dash;

import org.nhom1.agilecarrentall.entity.Member;
import org.nhom1.agilecarrentall.entity.Post;
import org.nhom1.agilecarrentall.entity.dto.common.PostDTO;
import org.nhom1.agilecarrentall.entity.dto.dashboard.request.PostFilterRequest;
import org.nhom1.agilecarrentall.entity.dto.dashboard.request.PostRequestDTO;
import org.nhom1.agilecarrentall.entity.dto.pagination.PaginationResponse;
import org.nhom1.agilecarrentall.entity.type.PostStatus;

import java.util.List;

public interface PostService {

    List<PostDTO> findLatestPublishedPosts(Integer limit, PostStatus postStatus);
    Post savePost(PostRequestDTO postRequestDTO, Member member);
    Post updatePost(PostRequestDTO postRequestDTO);
    PostDTO getPostItemResponseDTO(Integer postId, PostStatus postStatus);
    PostDTO getPostDTOByPostId(Integer postId);
    PostDTO getPublishPostDTOByPostSlug(String postSlug);
    PaginationResponse<List<PostDTO>> findPostsByFilter(PostFilterRequest request);
    void changeStatus(Integer postId, PostStatus postStatus);
    void deletePost(Integer postId);
}
