

package ru.stqa.pft.addressbook.bdd;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "classpath:bdd", plugin = {"pretty", "html:build/cucumber-report"})
// pretty - формат отчетов для консоли
// build/cucumber-report - дополнительная опция, расположение отчетов
public class GroupTests extends AbstractTestNGCucumberTests {
    // Класс запускатель для сценариев Cucumber
}