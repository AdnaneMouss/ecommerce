package com.example.demo.service;

import com.example.demo.modele.Panier;
import com.example.demo.modele.Rating;
import com.example.demo.repository.PanierRepository;
import com.example.demo.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    public RatingService(){}
    public RatingService(RatingRepository rp){
        this.rp=rp;
    }
    @Autowired
    private RatingRepository rp;

    public int getAvg(int id){
        Integer avgRating = rp.findAverageRatingByProduitId(id);
        return (avgRating != null) ? avgRating : 0; // or any other default value
    }

    public List<Rating> getAllRatingsById(int id) {
        return ratingRepository.findByProduitId(id);
    }
}



