package controller;

import model.TIDConverter;

/**
 * Implementation for the Converter Controller.
 */
public class ConverterControllerImpl {

    private Readable rd;
    private Appendable output;

    /**
     * Constructor method that takes in a Readable rd, and an Appendable ap.
     *
     * @param rd - Input entered by the user.
     * @param ap - Output from the Converter
     * @throws IllegalArgumentException - if either of the parameters are null
     */
    public ConverterControllerImpl(Readable rd, Appendable ap) throws IllegalArgumentException {
        if (ap == null) {
            throw new IllegalArgumentException("Illegal value");
        } else {
            this.output = ap;
        }
        if (rd == null) {
            throw new IllegalArgumentException("Illegal value");
        } else {
            this.rd = rd;
        }
    }

    public void play(TIDConverter model) throws IllegalArgumentException,
            IllegalStateException {
        if (model == null) {
            throw new IllegalArgumentException("Invalid Arguments.\n");
        }
        try {
            if (model.getSID() == 0 && model.getTID() == 0) {
                output.append(model.findTIDSID());
            } else {
                output.append(model.findSID());
            }

        } catch (Exception e) {
            throw new IllegalStateException();
        }
    }
}