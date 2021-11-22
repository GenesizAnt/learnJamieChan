package learnJamieChan;

import java.util.LinkedList;

public class JavaProject {
    public static void main(String[] args) {

        String mem;

        MembershipManagement mm = new MembershipManagement();
        FileHandler fn = new FileHandler();

        LinkedList<Member> members = fn.readFile();
        int choice = mm.getChoice();

        while (choice != -1) {
            switch (choice) {
                case 1:
                    mem = mm.addMembers(members);
                    fn.appendFile(mem);
                    break;
                case 2:
                    mm.removeMember(members);
                    fn.overWriteFile(members);
                    break;
                case 3:
                    mm.printMemberInfo(members);
                    break;
                default:
                    System.out.println("Not found. Pleas enter again 1-3");
            }
            choice = mm.getChoice();
        }

        System.out.println("Programme end");

    }
}
