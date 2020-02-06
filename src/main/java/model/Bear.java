package model;

import com.google.gson.annotations.SerializedName;

public class Bear {

    @SerializedName("bear_type")
    private String bearType;

    @SerializedName("bear_name")
    private String bearName;

    @SerializedName("bear_age")
    private double bearAge;

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

    @Override
    public String toString() {
        return "Bear{" +
                "bearType='" + bearType + '\'' +
                ", bearName='" + bearName + '\'' +
                ", bearAge=" + bearAge +
                '}';
    }
}
