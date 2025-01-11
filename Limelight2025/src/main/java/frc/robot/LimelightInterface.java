package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class LimelightInterface {
    //Limelight Abbreviations For Networktable https://docs.limelightvision.io/docs/docs-limelight/apis/complete-networktables-api

    /*This instantiates the network table, where the limeight sends its data 
    (The table you are getting should be whatever your limelight is named) */
    private static NetworkTable limelight = NetworkTableInstance.getDefault().getTable("limelight"); 

    public double getDoubleEntry(String entry) {
        //This reads the table for a double
        return limelight.getEntry(entry).getDouble(0);
    }

    public double[] getArrayEntry(String entry) {
        //This reads the table for an array, 6 is the length of the array which the limelight will return
        return limelight.getEntry(entry).getDoubleArray(new double[6]); 
    }

    public double getID() {
        //This tells us what Apriltag it sees
        return getDoubleEntry("tid"); //tid stands for target id
    }

    public double getTargetArea() {
        //Area of the apriltag
        return getDoubleEntry("ta"); //ta is target area
    }

    public boolean hasValidTargets() {
        return getDoubleEntry("tv") == 1.0; // if tv is 1, it means that it actually sees an apriltag
    }

    public double getXOffset() {
        return getDoubleEntry("tx"); // Horizontal offset from crosshair to target
    }

    public double[] getBotPose() {
        return getArrayEntry("botpose_targetspace"); // position relative to Apriltag
    }
}
