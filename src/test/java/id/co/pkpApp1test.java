package id.co;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.util.List;

public class pkpApp1test {
    @Test
    @DisplayName ("Test Web google")
    public void test1() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch();
        Page page = browser.newPage();
        page.navigate("https://www.google.com/");
        System.out.println("Page Title nya adalah:"+page.title());
        browser.close();
        playwright.close();
    }
@Test
@DisplayName("Check URL or Check HTTPS")
public void testcheckHTTPS(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://10.8.11.1:8761/");
        String currentUrl = page.url();
        String expectedUrl = "http://10.8.11.1:8761/";
        if (currentUrl.equals(expectedUrl)) {
            System.out.println("URL is correct: " + currentUrl);
        } else {
            System.out.println("URL is incorrect. Expected: " + expectedUrl + ", but got: " + currentUrl);
        }
        // System.out.println(currentUrl);
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Check Place Holder")
    public void checkPlaceHolder (){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.programsbuzz.com/user/login");

        Locator searchBar = page.locator("#edit-keys");
        String placeText = searchBar.getAttribute("placeholder");

        if (placeText.contains("Enter the terms you wish to search for")) {

            System.out.println("PASS");

        } else {
            System.out.println("FAIL! No such texts");
        }
        page.close();
        browser.close();
        playwright.close();
    }
@Test
@DisplayName("Assert Checkbox")
    public void assertCheckBox(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://autopract.com/selenium/dropdown1/");
        Locator locator = page.locator("select.custom-select option >> nth=-2");
        String attributeV = locator.getAttribute("value");

        if (attributeV.equals("item3")) {
            System.out.println("Attribute value is correct!");
        } else {
            System.out.println("Attribute value is incorrect.");
        }
    page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Tooltip Check Test")
    public void tooltipCheckTest() {
        Playwright playwright = Playwright.create();
        BrowserContext browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false))
                .newContext();

        Page page = browser.newPage();
        page.navigate("https://jqueryui.com/tooltip/");
        FrameLocator frameOne = page.frameLocator(".demo-frame");
        Locator ageBox = frameOne.locator("#age");
        Locator toolTipText = frameOne.locator(".ui-tooltip-content");
        ageBox.hover();
        String textContent = toolTipText.textContent();
        System.out.println(textContent);

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Soft Assertion Test")
    public void softAssertionTest() {
        Playwright playwright = Playwright.create();
        BrowserContext browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false))
                .newContext();
        Page page = browser.newPage();
        page.navigate("https://www.programsbuzz.com/user/login");
        page.locator("#edit-name").type("nana");
        page.locator("#edit-pass").type("nnv");
        page.locator("(//input[@type='submit'])[2]").click();
        String actualText = page.locator("//a[normalize-space()='Forgot your password?']").textContent();
        System.out.println(actualText);
        String expectedText = "Forgot your password?";
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(actualText, expectedText, "Matched");

        System.out.println("This part is executed");
        soft.assertAll();

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Assetion Title Test")
    public void assertionTitleTest() {
        Playwright playwright = Playwright.create();
        BrowserContext browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false))
                .newContext();
        Page page = browser.newPage();
        page.navigate("http://www.programsbuzz.com");
        String title = page.title();
        String expectedTitle = "ProgramsBuzz - Online Technical Courses";
        if (title.equalsIgnoreCase(expectedTitle)) {
            System.out.println("Title Match Verfied");
        } else {
            System.out.println("Not a match!!");
        }
        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Assert Text On Web Page Test")
    public void assertTextOnWebPageTest() {
        Playwright playwright = Playwright.create();
        BrowserContext browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false))
                .newContext();
        Page page = browser.newPage();
        page.navigate("http://www.programsbuzz.com");
        Locator body = page.locator("body");
        String bodyText = body.textContent();
        Assert.assertFalse(bodyText.contains("Spam Message"), "Spam Text Not Found!!");

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Get Current URL Test")
    public void GetCurrentURLJava() {
        Playwright playwright = Playwright.create();
        BrowserContext browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false))
                .newContext();
        Page page = browser.newPage();
        page.navigate("http://www.programsbuzz.com/user/login");
        page.locator("#edit-name").type("Naruto");
        page.locator("#edit-pass").type("uzumaki");

        String currentUrl = page.url();
        System.out.println(currentUrl);

        page.close();
        browser.close();
        playwright.close();

    }

    @Test
    @DisplayName("Click Browser Back and Forward Button Test Case")
    public void ClickBrowserBackandForwardButtonTestCase() {
        Playwright playwright = Playwright.create();
        BrowserContext browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false))
                .newContext();
        Page page = browser.newPage();
        page.navigate("https://www.programsbuzz.com");
        page.locator("#edit-submit--3").click();
        page.locator("//input[@id='edit-keys']").type("Playwright");
        page.locator("//input[@id='edit-submit']").click();
        page.goBack();
        page.goForward();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Navigate to URL")
    public void NavigatetoURL() {
        Playwright playwright = Playwright.create();
        BrowserContext browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false))
                .newContext();
        Page page = browser.newPage();
        page.navigate("http://autopract.com/selenium/upload1/");
        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("How To Refresh Page")
    public void HowToRefreshPage() {
        Playwright playwright = Playwright.create();
        BrowserContext browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false))
                .newContext();
        Page page = browser.newPage();
        page.navigate("http://autopract.com/selenium/popup/");
        page.reload();
        page.locator("//a[normalize-space()='JQuery Popup Model']").click();
        String textContent = page.locator("//p[normalize-space()='This is Sample Popup.']").textContent();
        System.out.println(textContent);
        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Maximize Browser")
    public void MaximizeBrowserTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        browser.newContext(new Browser.NewContextOptions().setViewportSize(800, 600));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        Page page = browser.newPage();
        page.navigate("https://www.google.com/");
        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("getfistandlastelemet")
    public void getfistandlastelemetTest() {
        Playwright playwright = Playwright.create();
        BrowserContext browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false))
                .newContext();
        Page page = browser.newPage();
        page.navigate("https://www.programsbuzz.com/search/node?keys=playwright+java");
        Locator listEle = page.locator("//h3[@class='search-result__title']");
        listEle.first().click();

        page.navigate("https://www.programsbuzz.com/search/node?keys=playwright+java");
        Locator listEle2 = page.locator("//h3[@class='search-result__title']");
        listEle2.nth(0).click();

        page.navigate("https://www.programsbuzz.com/search/node?keys=playwright+java");
        Locator listEle3 = page.locator("//h3[@class='search-result__title']");
        listEle3.last().click();

        page.navigate("https://www.programsbuzz.com/search/node?keys=playwright+java");
        Locator listEle4 = page.locator("//h3[@class='search-result__title']");
        listEle4.nth(0).click();

        page.close();
        browser.close();
        playwright.close();


    }

    @Test
    @DisplayName("Getting List of Elements")
    public void GettingListofElements() {
        Playwright playwright = Playwright.create();
        BrowserContext browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false))
                .newContext();
        Page page = browser.newPage();
        page.navigate("https://www.programsbuzz.com/search/node?keys=playwright+java");

        Locator listEle = page.locator("//h3[@class='search-result__title']");
        int count = listEle.count();
        Assert.assertEquals(count, 10);

        page.navigate("https://www.programsbuzz.com/search/node?keys=playwright+java");
        String textContent = listEle.nth(1).textContent();
        System.out.println(textContent);

        page.navigate("https://www.programsbuzz.com/search/node?keys=playwright+java");
        List<String> allTextContents = listEle.allTextContents();
        System.out.println(allTextContents);

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Using Xpath")
    public void UsingXpathTest() {
        Playwright playwright = Playwright.create();
        BrowserContext browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false))
                .newContext();
        Page page = browser.newPage();
        page.navigate("http://www.programsbuzz.com/user/login");
        page.locator("#edit-name").type("Naruto");
        page.locator("#edit-pass").type("uzumaki");
        page.locator("#edit-pass").type("Sasuke");

        page.close();
        browser.close();
        playwright.close();
    }
}

