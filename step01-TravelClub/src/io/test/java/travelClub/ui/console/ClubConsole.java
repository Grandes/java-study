package io.test.java.travelClub.ui.console;

import io.test.java.travelClub.entity.TravelClub;
import io.test.java.travelClub.service.ClubService;
import io.test.java.travelClub.service.ServiceLogicLifeCycler;
import io.test.java.travelClub.util.ConsoleUtil;

import java.util.List;

/**
 * @author kwon-yongho
 */
public class ClubConsole {

    private ConsoleUtil consoleUtil;

    private ClubService clubService;

    public ClubConsole() {
        this.consoleUtil = new ConsoleUtil();
        // 이후 변경될 코드
        this.clubService = ServiceLogicLifeCycler.getUniqueInstance().getClubService();
    }

    public void register() {
        System.out.println("Register!!");

        while (true) {
            String clubName = consoleUtil.getValueOf("Club Name(0.Club Menu)");
            if(clubName.equals("0")) {
                return;
            }

            String intro = consoleUtil.getValueOf("Club Intro(0.Club Menu)");
            if(intro.equals("0")) {
                return;
            }

            TravelClub newClub = new TravelClub(clubName, intro);

            clubService.register(newClub);

            System.out.println("Registered club : " + newClub.toString());
        }
    }

    public void findAll() {
        System.out.println("Find All!!");

        List<TravelClub> foundClubs = clubService.findAll();
        if(foundClubs.isEmpty()) {
            System.out.println("Empty!!");
            return;
        }
        for(TravelClub club : foundClubs) {
            System.out.println(club.toString());
        }
    }

    public void findById() {
        System.out.println("Find By Id!!");

        TravelClub foundClub = null;

        while (true) {
            String clubId = consoleUtil.getValueOf("Club id to find(0.Club Menu)");
            if(clubId.equals("0")) {
                break;
            }

            foundClub = clubService.findById(clubId);

            if(foundClub != null) {
                System.out.println(foundClub.toString());
            } else {
                System.out.println("Can not find club, ID : " + clubId);
            }
        }
    }

    public void findByName() {
        System.out.println("Find By Name!!");

        List<TravelClub> foundClubs = null;

        while (true) {
            String clubName = consoleUtil.getValueOf("Club name to find(0.Club Menu)");
            if(clubName.equals("0")) {
                break;
            }

            foundClubs = clubService.findByName(clubName);

            if(foundClubs != null && !foundClubs.isEmpty()) {
                for (TravelClub club : foundClubs) {
                    System.out.println(club.toString());
                }
            } else {
                System.out.println("Can not find club, Name : " + clubName);
            }
        }
    }

    private TravelClub findOne() {
        System.out.println("findOne!!");

        TravelClub foundClub = null;

        while (true) {
            String clubId = consoleUtil.getValueOf("Club id to find(0.Club Menu)");
            if(clubId.equals("0")) {
                break;
            }

            foundClub = clubService.findById(clubId);

            if(foundClub != null) {
                break;
            } else {
                System.out.println("Can not find club, ID : " + clubId);
            }
        }
        return foundClub;
    }

    public void modify() {
        System.out.println("Modify!!");

        TravelClub targetClub = findOne();

        String newName = consoleUtil.getValueOf("New Club name(0.Club Menu, Enter. No Change.)");
        if (newName.equals("0")) {
            return;
        }
        if (!newName.isEmpty()) {
            targetClub.setClubName(newName);
        }
        String newIntro = consoleUtil.getValueOf("New Club intro(0.Club Menu, Enter. No Change.)");
        if (newIntro.equals("0")) {
            return;
        }
        if (!newIntro.isEmpty()) {
            targetClub.setIntro(newIntro);
        }

        clubService.modify(targetClub);

        System.out.println("Modify Club : " + targetClub.toString());
    }

    public void remove() {
        System.out.println("Remove!!");

        TravelClub targetClub = findOne();

        String confirmStr = consoleUtil.getValueOf("Remove this club?(Y:yes, N:no)");
        if(confirmStr.toLowerCase().equals("y") || confirmStr.toLowerCase().equals("yes")) {
            System.out.println("Removing a club --> " + targetClub.getClubName());
            clubService.remove(targetClub.getId());
        } else {
            System.out.println("Remove cancelled, your club is safe : " + targetClub.getClubName());
        }
    }
}
