/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seq;

import java.math.BigDecimal;
import utils.SequenceGenerator;

/**
 * Klasa abstrakcyjna implementująca interfejs {@link SequenceGenerator} i
 * dostarczająca podstawową funkcjonalność generatorów ciągów.
 *
 * @author wojciech
 * @version 1.0.0
 */
abstract class Generator implements SequenceGenerator {

    /**
     * Indeks ostatnio uzyskanego wyrazu ciągu.
     */
    protected int lastIndex = 0;

    /**
     * Aktualny wyraz ciągu.
     */
    protected BigDecimal current = null,
            /**
             * Poprzedni wyraz ciągu.
             */
            f_1 = null,
            /**
             * Przedprzedni wyraz ciągu.
             */
            f_2 = null,
            /**
             * Przedprzedprzedni wyraz ciągu.
             */
            f_3 = null;

    @Override
    public void reset() {
        lastIndex = 0;
    }

    @Override
    public final BigDecimal getTerm(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i < lastIndex) {
            reset();
        }
        while (lastIndex <= i) {
            nextTerm();
        }
        return current;
    }
}