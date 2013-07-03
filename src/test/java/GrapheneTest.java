import org.jboss.arquillian.drone.api.annotation.Drone;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.jboss.arquillian.junit.Arquillian;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;
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
        WebElement loginButton = driver.findElement(By.id("j_idt13:login"));
        guardHttp(loginButton).click();
        String pageURL = driver.getCurrentUrl();

        //then
        assertTrue(pageURL.startsWith("https://itcrowd.pl/vop/login"));
    }
}