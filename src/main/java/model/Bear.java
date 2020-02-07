package model;

import com.google.gson.annotations.SerializedName;

public class Bear {

    @SerializedName("bear_id")
    private int bearId;

    @SerializedName("bear_type")
    private String bearType;

    @SerializedName("bear_name")
    private String bearName;

    @SerializedName("bear_age")
    private double bearAge;

    public Bear(int bearId, String bearType, String bearName, double bearAge) {
        this.bearId = bearId;
        this.bearType = bearType;
        this.bearName = bearName;
        this.bearAge = bearAge;
    }

    public Bear(String bearType, String bearName, double bearAge) {
        this.bearType = bearType;
        this.bearName = bearName;
        this.bearAge = bearAge;
    }

    public Bear() {
    }

    public String getBearType() {
        return bearType;
    }

    public void setBearType(String bearType) {
        this.bearType = bearType;
    }

    public String getBearName() {
        return bearName;
    }

    public void setBearName(String bearName) {
        this.bearName = bearName;
    }

    public double getBearAge() {
        return bearAge;
    }

    public void setBearAge(double bearAge) {
        this.bearAge = bearAge;
    }

    public int getBearId() {
        return bearId;
    }

    @Override
    public String toString() {
        return "Bear{" +
                "bearType='" + bearType + '\'' +
                ", bearName='" + bearName + '\'' +
                ", bearAge=" + bearAge +
                '}';
    }
}
