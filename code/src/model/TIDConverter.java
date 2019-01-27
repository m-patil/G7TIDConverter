package model;

/**
 * Interface representing the Converter model.
 */
public interface TIDConverter {
    /**
     * Find the first valid SID for the given G7TID and TID combo. Because certain G7TID and TID
     * combos can be impossible, it can also return a string saying that the values are invalid.
     *
     * @return a String labelling the exact value for the SID
     */
    String findSID();

    /**
     * Find the first valid TID and SID value for the given G7TID. A combo will always be found,
     * however the invalid values output is merely there in the case of bogus G7TID input.
     *
     * @return a String labelling the exact values for the SID and TID
     */
    String findTIDSID();

    /**
     * Getter method for the TID to not allow external modification of TID but still be able to
     * access the value.
     *
     * @return the integer value of TID
     */
    int getTID();

    /**
     * Getter method for the SID to not allow external modification of SID but still be able to
     * access the value.
     *
     * @return the integer value of SID
     */
    int getSID();

}
