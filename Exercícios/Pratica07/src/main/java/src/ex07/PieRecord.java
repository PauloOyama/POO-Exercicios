package src.ex07;

public class PieRecord {

    public PieRecord(String pieName, int num) {
        this.name = pieName;
        this.num = num;
    }


    public int getnumOfPie() {
        return num;
    }

    public String getName() {
        return name;
    }


    public void setNumOfPie(int num) {
        this.num = num;
    }

    public String toString() {
        return "Pie = " + this.name + ", Number in Pie = "
                + this.num;
    }

    private String name;

    private int num;
}
