package enums;

public enum Bears {

    POLAR("POLAR", "Vasya", 10),
    BROWN("BROWN", "Greg", 5),
    BLACK("BLACK", "Igor", 8),
    GUMMY("GUMMY", "Stef", 1);

    String bearType;
    String bearName;
    double bearAge;

    Bears(String bearType, String bearName, double bearAge) {
        this.bearType = bearType;
        this.bearName = bearName;
        this.bearAge = bearAge;
    }

    public String getBearType() {
        return bearType;
    }

    public String getBearName() {
        return bearName;
    }

    public double getBearAge() {
        return bearAge;
    }
}
