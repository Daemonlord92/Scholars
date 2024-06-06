package org.blitmatthew.thread;

import java.util.Scanner;

public class ResourceMiner extends Thread{

    private final String resource;
    private int amountMined;
    private boolean isMining;
    private String input;

    public ResourceMiner(String resource) {
        this.resource = resource;
        this.amountMined = 0;
        this.isMining = false;
        this.input = "";
    }

    @Override
    public void run() {
        while (isMining){
            switch(this.input) {
                case "mine":
                    for (int i = 0; i < 5; i++) {
                        amountMined = (i * 5) + amountMined;
                        System.out.println("You have mined " + resource + " amount: " + amountMined);
                    }
                    try {
                        Thread.sleep(1000 * 30);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "done":
                    this.interrupt();
                    isMining = false;
                    break;
                default:
                    System.out.println("Please input a command");
                    break;
            }
        }
    }

    public String getResource() {
        return resource;
    }

    public int getAmountMined() {
        return amountMined;
    }

    public void setAmountMined(int amountMined) {
        this.amountMined = amountMined;
    }

    public boolean isMining() {
        return isMining;
    }

    public void setMining(boolean mining) {
        isMining = mining;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
