package congnghetuts.com.quarkus.service;

import congnghetuts.com.quarkus.model.Post;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class PostService {

    @Transactional
    public void savePostToDB(Post post) {
       // post.persist();
    }
}
