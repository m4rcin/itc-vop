import org.jboss.arquillian.drone.api.annotation.Drone;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.jboss.arquillian.junit.Arquillian;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
public class GrapheneTest {
    @Drone
    WebDriver driver;


    @Test
    public void testHappyPath()
    {
        //given

        //when
        driver.get("https://itcrowd.pl/vop/");
        WebElement loginButton = driver.findElement(By.id("j_idt13:login")); //j_idt13:login is id of login href
        loginButton.click();
        //String pageURL = driver.getCurrentUrl();
        WebElement loginForm = driver.findElement(By.id("lF:e:label")); //lF:e:label is id of label in login form on login page

        //then
        //assertEquals("https://itcrowd.pl/vop/login/", pageURL);
        assertTrue(loginForm.isDisplayed());
    }
}