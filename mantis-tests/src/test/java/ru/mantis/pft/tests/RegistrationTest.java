package ru.mantis.pft.tests;

import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{

    @Test
    public void testRegistration(){
        app.registration().start("userJ","localj@local.ru");
    }
}