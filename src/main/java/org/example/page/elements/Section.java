package org.example.page.elements;

import org.example.page.components.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Section extends BaseComponent {

    private static By section = By.className("section");


    public static boolean isSectionPageDisplayed(String sectionName) {
        List<WebElement> visibleSections = driver.findElements(section);
        return visibleSections.stream()
                .anyMatch(element -> element.getAttribute("id").replaceAll("_"," ").toLowerCase().contains(sectionName.toLowerCase()));
    }
}
