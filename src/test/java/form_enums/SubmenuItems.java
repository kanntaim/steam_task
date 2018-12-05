package form_enums;

import framework.utils.LanguageProperties;

public enum SubmenuItems {
    ACTIONS("menuGamesActions");

    private final String text;

    SubmenuItems(String propertyKey) {
        LanguageProperties languageProperties = LanguageProperties.getInstance();
        this.text = languageProperties.getProperty(propertyKey);
    }

    public String getText() {
        return this.text;
    }
}
