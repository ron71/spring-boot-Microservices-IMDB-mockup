package com.cozinfinitybehind.ratingdataservice.resources;

import com.cozinfinitybehind.ratingdataservice.models.Rating;
import com.cozinfinitybehind.ratingdataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController()
@RequestMapping("/ratingsdata")
public class RatingsDataResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId, 4);
    }


    @RequestMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId){
        return new UserRating(Arrays.asList(
                new Rating("101", 3),
                new Rating("102", 4),
                new Rating("103", 5)
        ));
    }
}
