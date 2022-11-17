package gdsc.blog.service;

import gdsc.blog.domain.Post;
import gdsc.blog.dto.post.WritePostReq;
import gdsc.blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional  //롤백역할
    public Post save(WritePostReq writePostReq){
        Post post = Post.builder()
                .title(writePostReq.getTitle())
                .content(writePostReq.getContent()).build();
        return postRepository.save(post);
    }


    @Transactional(readOnly = true)
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Post findById(Long id) {
        return postRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("해당 id는 존재하지 않음")
                );
        return post;
    }

    @Transactional
    public Post updateById(Long id, WritePostReq writePostReq){
        return postRepository
                .findById(id).orElseThrow(
                        () -> new RuntimeException("해당 id는 존재하지 않음")
                );
        post.setTitle(writePostReq.getTitle());
        post.setContent(writePostReq.getContent());

    }

    @Transactional
    public String deletebyId(Long id){
        try{
            postRepository.deleteById(id);
        }
        catch(Exception e){
            throw new RuntimeException("해당 id는 존재하지 않음");
        }
        return "ok";
    }
}
