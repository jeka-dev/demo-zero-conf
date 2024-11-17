package app;

import org.junit.jupiter.api.Test;

public class AsciiArtizerTest {

    @Test
    void Helloword_ok() {
        System.out.println(AsciiArtizer.transform("Hello World!"));
    }

}
