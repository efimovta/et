package efimovta.store.entity.enums;

import java.awt.*;

/**
 * Created by EFIMOVAT on 12.03.2017.
 */
public enum NamedColor {

    BLACK(Color.BLACK),
    WHITE(Color.WHITE),
    GRAY(Color.GRAY),
    DARK_GRAY(Color.DARK_GRAY),
    LIGHT_GRAY(Color.LIGHT_GRAY),

    RED(Color.RED),
    ORANGE(Color.ORANGE),
    YELLOW(Color.YELLOW),
    GREEN(Color.GREEN),
    BLUE(Color.BLUE),
    PINK(Color.PINK),
    CYAN(Color.CYAN),
    MAGENTA(Color.MAGENTA);
    
    private final Color awtColor;

    NamedColor(Color awtColor) {
        this.awtColor = awtColor;
    }

    public Color getAwtColor() {
        return awtColor;
    }

}
