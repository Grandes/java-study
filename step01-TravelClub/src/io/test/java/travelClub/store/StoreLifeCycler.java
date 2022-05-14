package io.test.java.travelClub.store;

import io.test.java.travelClub.store.logic.ClubMapStore;

/**
 * @author kwon-yongho
 */
public class StoreLifeCycler {
    private static StoreLifeCycler uniqueInstance;

    private ClubStore clubStore;

    private StoreLifeCycler() {
        this.clubStore = new ClubMapStore();
    }

    public static StoreLifeCycler getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new StoreLifeCycler();
        }
        return uniqueInstance;
    }

    public ClubStore requestClubStore() {
        return this.clubStore;
    }
}
