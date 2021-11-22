package learnJamieChan;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class MembershipManagement {

   /*Объект reader объявляется с ключевым словом final,
    потому что мы не будем присваивать ему новую ссылку
    позднее в коде. Также он объявляется с ключевым словом private, потому что он будет использоваться только
    в классе MembershipManagement.*/

    final private Scanner reader = new Scanner(System.in);

    private int getIntInput() {
        int choice = 0;
        while (choice == 0) {
            try {
                choice = reader.nextInt();
                if (choice == 0) throw new InputMismatchException();
                reader.nextLine();
            } catch(InputMismatchException e) {
            reader.nextLine();
            System.out.println("Pleas enter whole number");
            }
        }
        return choice;
    }

    private void printClubOptions() {
        System.out.println("1) Club Mercury\n2) Club Neptune\n3)Club Jupiter\n4)Multi Clubs");
    }

    public int getChoice() {
        int choice;
        System.out.print("WELCOME TO OZONE FITNESS CENTER\n");
        System.out.print("=================================\n");
        System.out.println("1) Add Member\n2) Remove Member\n3) Display Member Information\nPleas select an options (or Enter -1 to quit):");

        choice = getIntInput();

        return choice;
    }

    public String addMembers(LinkedList<Member> m) {
        String name;
        int club;
        String mem;
        double fees;
        int memberID;
        Member mbr;
        Calculator<Integer> cal;

        System.out.println("Please enter name member club ");
        name = reader.nextLine();

        printClubOptions();
        club = getIntInput();
        while (club < 1 || club > 4) {
            System.out.println("This invalid input. Pleas enter numbers 1 - 4");
            club = getIntInput();
        }

        if (m.size() > 0) {
            memberID = m.getLast().getMemberID() + 1;
        } else {
            memberID = 1;
        }

        if (club != 4) {
            cal = (n) -> {
                switch (n) {
                    case 1:
                        return 900;
                    case 2:
                        return 950;
                    case 3:
                        return 1000;
                    default:
                        return -1;
                }
            };
            fees = cal.calculateFees(club);
            mbr = new SingleClubMember('S', memberID, name, fees, club);
            m.add(mbr);
            mem = mbr.toString();
            System.out.println("STATUS: Single Club Member added");

        } else {

                cal = (n) -> {
                    switch (n) {
                        case 4:
                            return 1200;
                        default:
                            return -1;
                    }
                };
                fees = cal.calculateFees(club);
                mbr = new MultiClubMember('M', memberID, name, fees, 100);
                m.add(mbr);
                mem = mbr.toString();
                System.out.println("STATUS: Multi Club Member added");
            }

        return mem;
    }

    public void removeMember(LinkedList<Member> m) {
        int memberID;
        System.out.println("Pleas enter ID member whom your wish deleted");
        memberID = getIntInput();
        for (int i = 0; i < m.size(); i++) {
            if (m.get(i).getMemberID() == memberID) {
                m.remove(i);
                System.out.println("Member deleted");
                return;
            }
        }
        System.out.println("Member with this ID not found");
    }

    public void printMemberInfo(LinkedList<Member> m) {
        int memberID;
        System.out.println("Pleas enter name member whom your wish print info");
        memberID = getIntInput();
        for (int i = 0; i < m.size(); i++) {
            if (m.get(i).getMemberID() == memberID) {
                String[] memberInfo = m.get(i).toString().split(", ");
                System.out.println("Member Type = " + memberInfo[0]);
                System.out.println("Member ID = " + memberInfo[1]);
                System.out.println("Member Name = " + memberInfo[2]);
                System.out.println("Membership Fees = " + memberInfo[3]);
                if (memberInfo[4].equals("M")) {
                    System.out.println("Membership Points = " + memberInfo[4]);
                } else {
                    System.out.println("Club ID = " + memberInfo[4]);
                }
                return;
            }
        }
        System.out.println("Member with this ID not found");
    }

}


