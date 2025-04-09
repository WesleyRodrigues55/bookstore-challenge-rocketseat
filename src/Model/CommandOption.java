package Model;

public enum CommandOption {
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
