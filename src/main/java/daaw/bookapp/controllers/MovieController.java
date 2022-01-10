package daaw.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import daaw.bookapp.controllers.exception.MovieNotFoundException;
import daaw.bookapp.persistence.model.Movie;
import daaw.bookapp.persistence.repo.MovieRepository;

@RestController
@RequestMapping("/peliculas")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    // Listar todas las películas disponibles. La respuestase da en formato JSON.
    @GetMapping
    public Iterable<Movie> findAll() {
        return movieRepository.findAll();
    }

    // Mostrar los datos de la película con identificador “id”. La respuesta se da en formato JSON.
    @GetMapping("/{id}")
    public Movie findOne(@PathVariable String id) {
        return movieRepository.findById(id)
                .orElseThrow(MovieNotFoundException::new);
    }

    //Mostrar los datos de la película con título “titulo”. La respuesta se da en formato JSON.
    @GetMapping("/titulo/{title}")
    public List<Movie> findByTitle(@PathVariable String title) {
        return movieRepository.findByTitle(title);
    }

    //Listar películas donde participa el actor “actor”. La respuesta se da en formato JSON.
    @GetMapping("/actor/{author}")
    public List<Movie> findByAuthor(@PathVariable String author) {
        return movieRepository.findByTitle(author);
    }

    //Se crea una película nueva en el servidor.
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        try {
            Movie _movie = movieRepository
                    .save(movie);
            return new ResponseEntity<>(_movie, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Se elimina la película con identificador “id”.
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteMovie(@PathVariable("id") String id) {
        try {
            movieRepository.deleteById(id);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
      }

      //Funcion añadida para la comprobacion de la CI del proyecto
     /*  @GetMapping("/test")
      public String homePage() {
          return "home";
      } */

}