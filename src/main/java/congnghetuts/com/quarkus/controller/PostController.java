package congnghetuts.com.quarkus.controller;

import congnghetuts.com.quarkus.model.PersonVO;
import congnghetuts.com.quarkus.model.Post;
import congnghetuts.com.quarkus.service.PostService;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/post")
public class PostController {
    @Inject
    PostService postService;

    @POST
    public void create(Post post) {
         postService.savePostToDB(post);
    }

}
