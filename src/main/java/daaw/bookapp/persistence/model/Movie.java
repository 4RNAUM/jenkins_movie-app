package daaw.bookapp.persistence.model;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("movies")
public class Movie {

        @Id
        private String id;
        private String title;
        private String[] actors;
        private String genre;
        private int year;
        
        public Movie(String title, String[] actors, String genre, int year) {
            super();
            this.title = title;
            this.actors = actors;
            this.genre = genre;
            this.year = year;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String[] getActors() {
            return actors;
        }

        public void setActors(String[] actors) {
            this.actors = actors;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        @Override
        public String toString() {
            return "Movie [actors=" + Arrays.toString(actors) + ", genre=" + genre + ", id=" + id + ", title=" + title
                    + ", year=" + year + "]";
        }

       
                
}