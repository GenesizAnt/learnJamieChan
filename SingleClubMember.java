package learnJamieChan;

public class SingleClubMember extends Member {

    private int club;

    public int getClub() {
        return club;
    }

    public void setClub(int club) {
        this.club = club;
    }

    public SingleClubMember(char pMemberType, int pMemberID, String pName, double pFees, int pClub) {
        super(pMemberType, pMemberID, pName, pFees);
        this.club = getClub();
    }

    @Override
    public String toString() {
        return super.toString() + ", " + getClub();
    }
}
