package dev.omar.movies.controllers;

import dev.omar.movies.documents.Review;
import dev.omar.movies.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String,String> payload) {
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("imdbId"), payload.get("body")), HttpStatus.CREATED);
    }

}
