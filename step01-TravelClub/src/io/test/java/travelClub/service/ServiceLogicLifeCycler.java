package io.test.java.travelClub.service;

import io.test.java.travelClub.service.logic.ClubServiceLogic;

/**
 * @author kwon-yongho
 */
public class ServiceLogicLifeCycler {

    private static ServiceLogicLifeCycler uniqueInstance;

    private ClubService clubService;

    private ServiceLogicLifeCycler() {
        this.clubService = new ClubServiceLogic();
    }

    public static ServiceLogicLifeCycler getUniqueInstance() {
        if(uniqueInstance == null) {
            uniqueInstance = new ServiceLogicLifeCycler();
        }
        return uniqueInstance;
    }

    public ClubService getClubService () {
        // 생성자가 한 번만 생성이 되는게 확정이 되었기 때문에 아래 코드를 주석하고 생성자에 new를 살린다.
//        if (clubService == null) {
//            clubService = new ClubServiceLogic();
//        }
        return this.clubService;
    }
}
