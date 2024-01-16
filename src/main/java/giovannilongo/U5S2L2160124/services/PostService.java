package giovannilongo.U5S2L2160124.services;

import giovannilongo.U5S2L2160124.entities.Post;
import giovannilongo.U5S2L2160124.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class PostService {
    private List<Post> post = new ArrayList<>();

    public List<Post> getPost() {
        return this.post;
    }

    public Post save(Post body) {
        Random rndm = new Random();
        body.setId(rndm.nextInt(1, 2000));
        this.post.add(body);
        return body;
    }

    public Post findById(int id) {
        Post found = null;
        for (Post post : this.post) {
            if (post.getId() == id) {
                found = post;
            }
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;
    }

    public void findByIdAndDelete(int id) {
        Iterator<Post> iterator = this.post.iterator();
        while (iterator.hasNext()) {
            Post current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }
    }

    public Post findByIdAndUpdate(int id, Post body) {
        Post found = null;
        for (Post post : this.post) {
            if (post.getId() == id) {
                found = post;
                found.setId(id);
                found.setCategoria(body.getCategoria());
                found.setTitolo(body.getTitolo());
                found.setCover(body.getCover());
                found.setContenuto(body.getContenuto());
                found.setTempoDiLettura(body.getTempoDiLettura());
            }
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;
    }
}
