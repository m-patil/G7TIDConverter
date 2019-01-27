package controller;

import model.TIDConverter;

/**
 * Interface class for the Converter Controller.
 */
public interface ConverterController {
    /**
     * Controller method for the Converter
     *
     * @param model the TID Converter model
     * @throws IllegalArgumentException if the model is null
     * @throws IllegalStateException    if appending the output fails
     */
    void play(TIDConverter model) throws IllegalArgumentException, IllegalStateException;
}
