package test1;

public enum Day {
    MONDAY("monday"), TUESDAY("tuesday"), SUNDAY("sunday");

    private String din;

    Day(String din) {
        this.din = din;
    }

    public void aajKaDin() {
        System.out.println(this.din);
    }
}
