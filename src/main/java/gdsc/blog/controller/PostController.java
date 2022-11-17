package gdsc.blog.controller;

import gdsc.blog.domain.Post;
import gdsc.blog.dto.post.WritePostReq;
import gdsc.blog.service.PostService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/post")
@RestController
public class PostController {
    private final PostService postService;

    @ApiOperation(value = "게시글 등록", notes = "게시글을 등록합니다.")
    @PostMapping("")    //원래는 url 이 들어간다.
    public ResponseEntity<Post> save(@RequestBody WritePostReq writePostReq){
        Post post = postService.save(writePostReq);

        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }
}
