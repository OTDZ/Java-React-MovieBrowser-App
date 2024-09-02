package dev.omar.movies.services;

import dev.omar.movies.documents.Movie;
import dev.omar.movies.repositories.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(ObjectId id) {
        return movieRepository.findById(id);
    }

    public Optional<Movie> getMovieByImdbid(String imdbid) {
        return movieRepository.findMovieByImdbId(imdbid);
    }

}
