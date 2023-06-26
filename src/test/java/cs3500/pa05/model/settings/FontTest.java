package cs3500.pa05.model.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Refers to tests for Fonts.
 */
public class FontTest {
  private Font ariel;
  private Font comicSands;
  private Font optimusPrime;
  private Font systemOutPrint;
  private Font typewriterText;
  private Font juliusCaesar;

  /**
   * Initializes fonts before each test.
   */
  @BeforeEach
  public void setUp() {
    ariel = Font.ARIAL;
    comicSands = Font.COMIC_SANS;
    optimusPrime = Font.OPTIMA;
    systemOutPrint = Font.SYSTEM;
    typewriterText = Font.MONOSPACED;
    juliusCaesar = Font.TIMES_NEW_ROMAN;
  }

  /**
   * Tests if the correct font name is returned.
   */
  @Test
  public void testGetFontName() {
    assertEquals("Arial", ariel.getFontName());
    assertEquals("Comic Sans MS", comicSands.getFontName());
    assertEquals("Optima", optimusPrime.getFontName());
    assertEquals("System", systemOutPrint.getFontName());
    assertEquals("Monospaced", typewriterText.getFontName());
    assertEquals("Times New Roman", juliusCaesar.getFontName());
  }
}