package dev.omar.movies.services;

import dev.omar.movies.documents.Movie;
import dev.omar.movies.documents.Review;
import dev.omar.movies.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public Review createReview(String imdbId, String body) {
        Review review = new Review(body);
        reviewRepository.insert(review);

        // Add review to the associated movie's reviewIds using imdbId
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }

}
