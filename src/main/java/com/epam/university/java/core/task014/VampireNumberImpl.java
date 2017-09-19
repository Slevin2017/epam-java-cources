package com.epam.university.java.core.task014;

/**
 * Created by Александр on 18.09.2017.
 */
public class VampireNumberImpl implements VampireNumber {

    private final int first;
    private final int second;
    private final int multiplication;

    VampireNumberImpl(int multiplication, int fisrst, int second){
        this.multiplication = multiplication;
        this.first = fisrst;
        this.second = second;
    }

    /**
     * Get multiplication of numbers.
     *
     * @return value of multiplication
     */
    @Override
    public int getMultiplication() {
        return first*second;
    }

    /**
     * Get first part of vampire number.
     *
     * @return value if first part
     */
    @Override
    public int getFirst() {
        return first;
    }

    /**
     * Get second part of vampire number.
     *
     * @return value of second part
     */
    @Override
    public int getSecond() {
        return second;
    }
}
