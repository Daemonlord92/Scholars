package org.blitmatthew.vehicles;

public class Car implements Vehicle{
    private Integer speed;
    private Boolean isOn;
    private final Integer acceleration;
    private Integer milesTraveled;
    private Boolean isMoving;

    public Car(Integer acceleration) {
        this.acceleration = acceleration;
        this.speed = 0;
        this.isOn = false;
        this.milesTraveled = 0;
        this.isMoving = false;
    }

    @Override
    public void start() {
        this.isOn = true;
    }

    @Override
    public void stop() {
        this.isOn = false;
        this.speed = 0;
        this.isMoving = false;
        System.out.println("You have travelled " + milesTraveled + " miles");
    }

    @Override
    public void brake() {
        this.speed -= 5;
        if(this.speed == 0){
            this.isMoving = false;
            System.out.println("You have travelled " + milesTraveled + " miles");
        }
    }

    @Override
    public void speedUp() {
        if (!isMoving){
            this.isMoving = true;
            Thread moving = new Thread(() -> {
                while(isMoving) {
                    this.milesTraveled += speed;
                    System.out.println("You have travelled " + this.milesTraveled + " miles");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            //moving.setDaemon(true);
            moving.start();
        }
        this.speed += this.acceleration;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Boolean getOn() {
        return isOn;
    }

    public void setOn(Boolean on) {
        isOn = on;
    }

    public Integer getAcceleration() {
        return acceleration;
    }

    public Integer getMilesTraveled() {
        return milesTraveled;
    }

    public void setMilesTraveled(Integer milesTraveled) {
        this.milesTraveled = milesTraveled;
    }
}
