package giovannilongo.U5S2L2160124.services;

import giovannilongo.U5S2L2160124.entities.Blogger;
import giovannilongo.U5S2L2160124.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class BloggerService {
    private List<Blogger> bloggers = new ArrayList<>();

    public List<Blogger> getBlogger() {
        return this.bloggers;
    }

    public Blogger save(Blogger body) {
        Random rndm = new Random();
        body.setId(rndm.nextInt(1, 2000));
        this.bloggers.add(body);
        return body;
    }

    public Blogger findById(int id) {
        Blogger found = null;
        for (Blogger blogger : this.bloggers) {
            if (blogger.getId() == id) {
                found = blogger;
            }
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;
    }

    public void findByIdAndDelete(int id) {
        Iterator<Blogger> iterator = this.bloggers.iterator();
        while (iterator.hasNext()) {
            Blogger current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }
    }

    public Blogger findByIdAndUpdate(int id, Blogger body) {
        Blogger found = null;
        for (Blogger blogger : this.bloggers) {
            if (blogger.getId() == id) {
                found = blogger;
                found.setId(id);
                found.setNome(body.getNome());
                found.setCognome(body.getCognome());
                found.setEmail(body.getEmail());
                found.setDataDiNascita(body.getDataDiNascita());
                found.setAvatar(body.getAvatar());
            }
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;
    }
}
