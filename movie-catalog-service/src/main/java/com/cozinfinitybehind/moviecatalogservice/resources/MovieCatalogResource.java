package com.cozinfinitybehind.moviecatalogservice.resources;

import com.cozinfinitybehind.moviecatalogservice.models.CatalogItem;
import com.cozinfinitybehind.moviecatalogservice.models.Movie;
import com.cozinfinitybehind.moviecatalogservice.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        RestTemplate restTemplate = new RestTemplate();

        //get all rated movieId

        List<Rating> ratings = Arrays.asList(new Rating("101", 5), new Rating("102", 3));

        //get movie detail for each Id
        return ratings.stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(), movie.getDesc(), rating.getRating());
            }).collect(Collectors.toList());

//        return Collections.singletonList(
//                new CatalogItem("Interstellar", "Space Time movie", 5)
////                new CatalogItem("The 100", "Survival Movie", 3),
////                new CatalogItem("Gangs of Wasseypur", "Gangster Movie", 4)
//        );
    }
}
