package forms.form_enums;

public enum MenuItems {
    YOUR_STORE("foryou_tab"),
    GAMES("genre_tab"),
    SOFTWARE("software_tab"),
    HARDWARE("hardware_tab"),
    VIDEOS("videos_tab");

    private final String id;

    MenuItems(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}
