package io.test.java.travelClub.service;

import io.test.java.travelClub.entity.TravelClub;

/**
 * @author kwon-yongho
 */
public interface ClubService {

    void register(TravelClub travelClub);
    TravelClub [] findAll();
    TravelClub [] findByName(String clubName);
    TravelClub findById(String clubId);

    void modify(TravelClub modifyClub);
    void remove(String clubId);
}
