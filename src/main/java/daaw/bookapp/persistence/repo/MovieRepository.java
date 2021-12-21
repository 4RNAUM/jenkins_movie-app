package daaw.bookapp.persistence.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import daaw.bookapp.persistence.model.Movie;

public interface MovieRepository extends MongoRepository<Movie, String> {
    
    @Query("{title:'?0'}")
    List<Movie> findByTitle(String title);

    @Query("{author:'?0'}")
    List<Movie> findByAuthor(String author);
}
