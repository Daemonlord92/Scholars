package org.blitmatthew.classes;

public class Computer {
    private String brand;
    private String model;
    private int year;
    private int ram;
    private int cpuCores;
    private String hardDriveType;
    private int storage;

    public Computer(String brand, String model, int year, int ram, int cpuCores, String hardDriveType, int storage) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.ram = ram;
        this.cpuCores = cpuCores;
        this.hardDriveType = hardDriveType;
        this.storage = storage;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getCpuCores() {
        return cpuCores;
    }

    public void setCpuCores(int cpuCores) {
        this.cpuCores = cpuCores;
    }

    public String getHardDriveType() {
        return hardDriveType;
    }

    public void setHardDriveType(String hardDriveType) {
        this.hardDriveType = hardDriveType;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", ram=" + ram +
                ", cpuCores=" + cpuCores +
                ", hardDriveType='" + hardDriveType + '\'' +
                ", storage=" + storage +
                '}';
    }
}
