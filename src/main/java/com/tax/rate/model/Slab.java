package com.tax.rate.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Dhriti Ghosh
 */
@Setter
@Getter
public class Slab {
    private int upperLimit;
    private int lowerLimit;
    private int rate;
    private String country;
}
