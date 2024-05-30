package org.blitmatthew.test;

public class AloeVera extends Plant{

    private double latexContext;

    public AloeVera(double latexContext) {
        this.latexContext = latexContext;
    }

    public AloeVera(String name, String genus, double latexContext) {
        super(name, genus);
        this.latexContext = latexContext;
    }

    @Override
    public void grow() {

    }

    @Override
    public void die() {

    }
}
