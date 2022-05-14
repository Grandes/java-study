package io.test.java.travelClub.store;

import io.test.java.travelClub.entity.TravelClub;

import java.util.List;

/**
 * @author kwon-yongho
 */
public interface ClubStore {

    void create(TravelClub travelClub);
    TravelClub retrieve(String clubId);
    List<TravelClub> retrieveAllByName(String clubName);
    List<TravelClub> retrieveAll();

    void update(TravelClub updateClub);
    void delete(String clubId);
}
