package com.company.Model;

public enum SpeedSetting {
    OFF,  // 0
    WEAK, // 1
    MEDIUM, // 2
    STRONG; // 3

    public SpeedSetting getNextMode() {
        return values()[(ordinal()+1) % values().length];
    }
    public SpeedSetting getPreviousMode() {
        int totalModes = values().length ;
        // (a % b + b) % b to deal with a < 0
        return values()[(((ordinal()-1) % totalModes + values().length ) % values().length) ];
    }
}
