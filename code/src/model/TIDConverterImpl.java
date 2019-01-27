package model;

/**
 * Class representing the implementation of a TIDConverter
 */
public class TIDConverterImpl implements TIDConverter {
    private int TID;
    private int SID;
    private int G7TID;

    /**
     * Constructor for when only the G7TID is provided by the user.
     *
     * @param G7TID The desired Generation 7 TID
     */
    public TIDConverterImpl(int G7TID) {
        this.TID = 0;
        this.SID = 0;
        this.G7TID = G7TID;
    }

    /**
     * Constructor for when the G7TID and TID is provided by the user.
     *
     * @param G7TID the desired Generation 7 TID
     * @param TID   the desired TID
     */
    public TIDConverterImpl(int G7TID, int TID) {
        this.TID = TID;
        this.SID = 0;
        this.G7TID = G7TID;
    }


    @Override
    public String findSID() {
        boolean found = false;
        for (int i = 0; i < 65536; i++) {
            if (G7TID == ((i * 65536) + TID) % 1000000) {
                SID = i;
                found = true;
                break;
            }
        }
        if (found) {
            return String.format("SID: %d", SID);
        } else {
            return "Valid TID and SID not found.";
        }
    }

    @Override
    public String findTIDSID() {
        boolean found = false;
        for (int i = 0; i < 65536; i++) {
            for (int j = 0; j < 65536; j++) {
                if (G7TID == ((i * 65536) + j) % 1000000) {
                    SID = i;
                    TID = j;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        if (found) {
            return String.format("TID: %d \nSID: %d", TID, SID);
        } else {
            return "Valid TID and SID not found.";
        }

    }

    @Override
    public int getTID() {
        return TID;
    }

    @Override
    public int getSID() {
        return SID;
    }

}
