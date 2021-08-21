package com.company.Model;

import java.util.Scanner;

public class CeilingFan {
    private SpeedSetting mode;
    private DirectionSetting direction;
    private boolean isPowerOn;

    public CeilingFan() {
        this.mode = SpeedSetting.OFF;
        this.direction = DirectionSetting.FORWARD;
        this.isPowerOn = true;
    }

    public void start(){
        Scanner in = new Scanner(System.in);
        userManual();
        while(isPowerOn) {
            int input = in.nextInt();
            switch (input) {
                case 0 -> isPowerOn = false;
                case 1 -> pullFirstCord();
                case 2 -> pullSecondCord();
                default -> System.out.println("ERROR: PLEASE TRY AGAIN");
            }
        }
        in.close();
    }

    private void pullFirstCord(){
        System.out.println("-----------------------------------------------");
        System.out.println("Current Mode Setting is: " + mode);
        if(direction == DirectionSetting.FORWARD) {
            mode = mode.getNextMode();
        }
        else if(direction == DirectionSetting.REVERSED){
            mode = mode.getPreviousMode();
        }
        else{
            System.out.println("ERROR");
        }
        System.out.println("After Changing Mode is: " + mode);
        System.out.println("-----------------------------------------------");
    }

    private void pullSecondCord(){
        System.out.println("-----------------------------------------------");
        System.out.println("Current Direction Setting is: " + direction);
        this.direction = changeDirection(direction);
        System.out.println("After Changing Direction is: " + direction);
        System.out.println("-----------------------------------------------");
    }

    private DirectionSetting changeDirection(DirectionSetting presentDirection) {
        if (presentDirection == DirectionSetting.FORWARD){
            return DirectionSetting.REVERSED;
        } else{
            return DirectionSetting.FORWARD;
        }
    }

    private void userManual(){
        System.out.println("-----------------------------------------------");
        System.out.println("Hello! This is the user manual");
        System.out.println("Press 0 to turn off the ceiling fan");
        System.out.println("Press 1 to pull cord one to change the speed mode");
        System.out.println("Press 2 to pull cord two to change direction");
        System.out.println("-----------------------------------------------");
    }

    private void goodByeMessage(){
        System.out.println("-----------------------------------------------");
        System.out.println("Program Terminated: Goodbye!");
        System.out.println("-----------------------------------------------");
    }
}
