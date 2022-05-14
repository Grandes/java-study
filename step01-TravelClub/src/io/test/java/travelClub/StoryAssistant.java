package io.test.java.travelClub;

import io.test.java.travelClub.entity.TravelClub;
import io.test.java.travelClub.ui.menu.ClubMenu;
import io.test.java.travelClub.util.DateUtil;

/**
 * @author kwon-yongho
 */
public class StoryAssistant {

    private void startStory() {
        ClubMenu clubMenu = new ClubMenu();
        clubMenu.show();
    }

    public static void main(String[] args) {
        StoryAssistant assistant = new StoryAssistant();
        assistant.startStory();
    }
}
