package io.test.java.travelClub.service;

import io.test.java.travelClub.entity.TravelClub;

import java.util.List;

/**
 * @author kwon-yongho
 */
public interface ClubService {

    void register(TravelClub travelClub);
    List<TravelClub> findAll();
    List<TravelClub> findByName(String clubName);
    TravelClub findById(String clubId);

    void modify(TravelClub modifyClub);
    void remove(String clubId);
}
