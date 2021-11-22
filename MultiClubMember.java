package learnJamieChan;

public class MultiClubMember extends Member {

    private int memberShipPoints;

    public MultiClubMember(char memberType, int memberID, String name, double fees, int memberShipPoints) {
        super(memberType, memberID, name, fees);
        this.memberShipPoints = memberShipPoints;
    }


    public int getMemberShipPoints() {
        return memberShipPoints;
    }

    public void setMemberShipPoints(int memberShipPoints) {
        this.memberShipPoints = memberShipPoints;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + getMemberShipPoints();
    }
}
