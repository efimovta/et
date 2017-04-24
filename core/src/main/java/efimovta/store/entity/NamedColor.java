package efimovta.store.entity;

import java.awt.Color;

/**
 * Named color listing. Each element contains a reference
 * to the corresponding instance of {@link Color}
 *
 * @see NamedColor#getAwtColor()
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

    /**
     * Convert awt color to element of this enum
     *
     * @param color awt color to conver
     * @return Corresponding color or null, if enum not contains
     * color with this defined awt color
     */
    public static NamedColor getNamedColor(Color color) {
        NamedColor namedColor = null;
        for (NamedColor nc : NamedColor.values()) {
            if (nc.getAwtColor().equals(color)) {
                namedColor = nc;
                break;
            }
        }
        return namedColor;
    }

    /**
     * @return defined awt color for this color
     */
    public Color getAwtColor() {
        return awtColor;
    }

}
