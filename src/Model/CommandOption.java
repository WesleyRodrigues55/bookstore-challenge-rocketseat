package Model;

public enum CommandOption {
    LIST_CUSTOMERS("1"),
    LIST_BOOK_LOANS("2"),
    LIST_CUSTOMER_LOANS("3"),
    YES("Y"),
    NO("N");

    private final String value;

    CommandOption(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CommandOption fromString(String text) {
        for (CommandOption option : CommandOption.values()) {
            if (option.getValue().equalsIgnoreCase(text)) {
                return option;
            }
        }
        return null;
    }


}
