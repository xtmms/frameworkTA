package module;

import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AssertionHelper {
    private static final Logger logger = LogManager.getLogger(AssertionHelper.class);

    // Assert True
    public static void assertTrue(boolean condition, String message) {
        logger.info("Verifica che la condizione sia vera: " + message);
        try {
            Assert.assertTrue(condition, message);
        } catch (AssertionError e) {
            logger.error("Assertion fallita: " + message);
            throw e;
        }
    }

    // Assert False
    public static void assertFalse(boolean condition, String message) {
        logger.info("Verifica che la condizione sia falsa: " + message);
        try {
            Assert.assertFalse(condition, message);
        } catch (AssertionError e) {
            logger.error("Assertion fallita: " + message);
            throw e;
        }
    }

    // Assert Equals
    public static void assertEquals(Object actual, Object expected, String message) {
        logger.info("Verifica che " + actual + " sia uguale a " + expected + ": " + message);
        try {
            Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            logger.error("Assertion fallita: " + message);
            throw e;
        }
    }

    // Assert Not Equals
    public static void assertNotEquals(Object actual, Object expected, String message) {
        logger.info("Verifica che " + actual + " non sia uguale a " + expected + ": " + message);
        try {
            Assert.assertNotEquals(actual, expected, message);
        } catch (AssertionError e) {
            logger.error("Assertion fallita: " + message);
            throw e;
        }
    }

    // Assert Null
    public static void assertNull(Object object, String message) {
        logger.info("Verifica che l'oggetto sia null: " + message);
        try {
            Assert.assertNull(object, message);
        } catch (AssertionError e) {
            logger.error("Assertion fallita: " + message);
            throw e;
        }
    }

    // Assert Not Null
    public static void assertNotNull(Object object, String message) {
        logger.info("Verifica che l'oggetto non sia null: " + message);
        try {
            Assert.assertNotNull(object, message);
        } catch (AssertionError e) {
            logger.error("Assertion fallita: " + message);
            throw e;
        }
    }

    // Assert Contains (String)
    public static void assertContains(String fullString, String substring, String message) {
        logger.info("Verifica che la stringa '" + fullString + "' contenga il testo: '" + substring + "': " + message);
        try {
            Assert.assertTrue(fullString.contains(substring), message);
        } catch (AssertionError e) {
            logger.error("Assertion fallita: " + message);
            throw e;
        }
    }

    // Assert List Contains (Collection)
    public static <T> void assertListContains(java.util.List<T> list, T element, String message) {
        logger.info("Verifica che la lista contenga l'elemento: '" + element + "': " + message);
        try {
            Assert.assertTrue(list.contains(element), message);
        } catch (AssertionError e) {
            logger.error("Assertion fallita: " + message);
            throw e;
        }
    }

    // Assert Greater Than
    public static void assertGreaterThan(int actual, int expected, String message) {
        logger.info("Verifica che " + actual + " sia maggiore di " + expected + ": " + message);
        try {
            Assert.assertTrue(actual > expected, message);
        } catch (AssertionError e) {
            logger.error("Assertion fallita: " + message);
            throw e;
        }
    }

    // Assert Less Than
    public static void assertLessThan(int actual, int expected, String message) {
        logger.info("Verifica che " + actual + " sia minore di " + expected + ": " + message);
        try {
            Assert.assertTrue(actual < expected, message);
        } catch (AssertionError e) {
            logger.error("Assertion fallita: " + message);
            throw e;
        }
    }

    // Assert String Matches Regex
    public static void assertMatchesRegex(String text, String regex, String message) {
        logger.info("Verifica che la stringa '" + text + "' corrisponda al pattern regex: '" + regex + "': " + message);
        try {
            Assert.assertTrue(text.matches(regex), message);
        } catch (AssertionError e) {
            logger.error("Assertion fallita: " + message);
            throw e;
        }
    }

    // Assert Array Equals
    public static void assertArrayEquals(Object[] actual, Object[] expected, String message) {
        logger.info("Verifica che gli array siano uguali: " + message);
        try {
            Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            logger.error("Assertion fallita: " + message);
            throw e;
        }
    }

    // Assert Element Is Displayed (per WebDriver)
    public static void assertElementDisplayed(org.openqa.selenium.WebElement element, String message) {
        logger.info("Verifica che l'elemento sia visualizzato: " + message);
        try {
            Assert.assertTrue(element.isDisplayed(), message);
        } catch (AssertionError e) {
            logger.error("Assertion fallita: " + message);
            throw e;
        }
    }
}

