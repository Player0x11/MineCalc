package Data.Action;

public class Mining {
    private int level;
    private String tool;

    public Mining(int level, String tool) {
        this.level = level;
        this.tool = tool;
    }

    public int getLevel() {
        return level;
    }

    public String getTool() {
        return tool;
    }
}