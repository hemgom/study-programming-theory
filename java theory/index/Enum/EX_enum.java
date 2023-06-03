package Enum;

public enum EX_enum {
    LEFT("왼쪽"),
    RIGHT("오른쪽");

    private final String message;

    EX_enum(String message) { this.message = message; }

    public String printMessage() {
        return this.message;
    }
}
