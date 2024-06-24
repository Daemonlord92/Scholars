package org.blitmatthew.general;

public abstract class Sheet {
    private Long id;
    private String name;
    private Short strStat;
    private Short strBonus;
    private Short dexStat;
    private Short dexBonus;
    private Short intStat;
    private Short intBonus;
    private Short chrStat;
    private Short chrBonus;

    public Sheet() {
    }

    public Sheet(String name, Short strStat, Short dexStat, Short intStat, Short chrStat) {
        this.name = name;
        this.strStat = strStat;
        this.strBonus = (short) (this.strStat/20);
        this.dexStat = dexStat;
        this.dexBonus = (short) (this.dexStat/20);
        this.intStat = intStat;
        this.intBonus = (short) (this.intStat/20);
        this.chrStat = chrStat;
        this.chrBonus = (short) (this.chrStat/20);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getStrStat() {
        return strStat;
    }

    public void setStrStat(Short strStat) {
        this.strStat = strStat;
    }

    public Short getStrBonus() {
        return strBonus;
    }

    public void setStrBonus(Short strBonus) {
        this.strBonus = strBonus;
    }

    public Short getDexStat() {
        return dexStat;
    }

    public void setDexStat(Short dexStat) {
        this.dexStat = dexStat;
    }

    public Short getDexBonus() {
        return dexBonus;
    }

    public void setDexBonus(Short dexBonus) {
        this.dexBonus = dexBonus;
    }

    public Short getIntStat() {
        return intStat;
    }

    public void setIntStat(Short intStat) {
        this.intStat = intStat;
    }

    public Short getIntBonus() {
        return intBonus;
    }

    public void setIntBonus(Short intBonus) {
        this.intBonus = intBonus;
    }

    public Short getChrStat() {
        return chrStat;
    }

    public void setChrStat(Short chrStat) {
        this.chrStat = chrStat;
    }

    public Short getChrBonus() {
        return chrBonus;
    }

    public void setChrBonus(Short chrBonus) {
        this.chrBonus = chrBonus;
    }
}
