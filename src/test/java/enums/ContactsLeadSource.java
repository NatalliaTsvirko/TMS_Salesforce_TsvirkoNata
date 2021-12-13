package enums;

public enum ContactsLeadSource {

    ADVERTISEMENT("Advertisement"),
    EMPLOYEErEFERRAL("Employee Referral"),
    EXTERNALREFERRAL("External Referral"),
    INSTORE("In - Store"),
    ONSITE("On Site"),
    OTHER("Other"),
    SOCIAL("Social"),
    TRADESHOW("Trade Show"),
    WEB("Web"),
    WORDOFMOUTH("Word of mouth");

    private String text;

    ContactsLeadSource(String name) {
        this.text = name;
    }

    public static ContactsLeadSource fromString(String text) {
        for (ContactsLeadSource b : ContactsLeadSource.values()) {
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
