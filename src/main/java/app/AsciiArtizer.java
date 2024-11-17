package app;

import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;

class AsciiArtizer {

    static String transform(String ...words) {
        try {
            return FigletFont.convertOneLine(String.join(" ", words));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
