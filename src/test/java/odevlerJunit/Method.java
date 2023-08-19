package odevlerJunit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Method {
    public void visibleTets(WebElement ddm, String visible){
        Select select=new Select(ddm);
        select.deselectByVisibleText(visible);

    }
}
