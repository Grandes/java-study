package io.test.java.travelClub.entity;

import io.test.java.travelClub.util.DateUtil;

import java.util.UUID;

/**
 * @author kwon-yongho
 */
public class TravelClub {
    //Fields
    private static final int MINIMUM_NAME_LENGTH = 3;
    private static final int MINIMUM_INTRO_LENGTH = 5;

    private String id;
    private String clubName;
    private String intro;
    private String foundationDay;

    private TravelClub() {
        this.id = UUID.randomUUID().toString();
    }

    public TravelClub(String clubName, String intro) {
        this();
//        this.clubName = clubName;
        setClubName(clubName);
        setIntro(intro);
        this.foundationDay = DateUtil.today();
    }

    public void setClubName(String clubName) {
        if(clubName.length() < MINIMUM_NAME_LENGTH) {
            System.out.println("Club name should be longer then " + MINIMUM_NAME_LENGTH);
            return;
        }
        this.clubName = clubName;
    }

    public String getClubName() {
        return this.clubName;
    }

    public void setIntro(String intro) {
        if(intro.length() < MINIMUM_INTRO_LENGTH) {
            System.out.println("Club intro should be longer then " + MINIMUM_INTRO_LENGTH);
            return;
        }
        this.intro = intro;
    }

    public String getIntro() {
        return this.intro;
    }

    public String getId() {
        return this.id;
    }

    public String getFoundationDay() {
        return this.foundationDay;
    }

    public static TravelClub getSample() {
//        String clubName = "Sample Club";
//        String intro = "Sample Club Intro~";
//        TravelClub sampleClub = new TravelClub(clubName, intro);
//        return sampleClub;

        return new TravelClub("Sample Club", "Sample Club Intro~~");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TravelClub club ID : ").append(id);
        builder.append(", ClubName : ").append(clubName);
        builder.append(", Intro : ").append(intro);
        builder.append(", FoundationDay : ").append(foundationDay);

        return builder.toString();
    }

}
