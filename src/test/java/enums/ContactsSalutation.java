package enums;

public enum ContactsSalutation {
    MR("Mr."),
    MS("Ms."),
    MRS("Mrs."),
    DR("Dr."),
    PROF("Prof.");

    private String text;

    ContactsSalutation(String name) {
        this.text = name;
    }

    public static ContactsSalutation fromString(String text) {
        for (ContactsSalutation b : ContactsSalutation.values()) {
            if (b.text.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }

    public String getName() {
        return this.text;
    }

}
