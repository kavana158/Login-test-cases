package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void setupPage() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLoginButtonDisabledWhenFieldAreEmpty() {
        Assert.assertFalse(loginPage.isLoginButtonEnabled());
    }

    @Test
    public void testPasswordMaskedButton() {
        loginPage.enterPassword("dummyPassword");
        Assert.assertEquals(loginPage.getPasswordFieldType(), "password");
        loginPage.togglePasswordVisibility();
        Assert.assertEquals(loginPage.getPasswordFieldType(), "text");
    }

    @Test
    public void testInvalidLoginShowErrorMsg() {
        loginPage.enterUserId("invalidUser");
        loginPage.enterPassword("invalidPass");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.getErrorMessage().toLowerCase().contains("invalid"));
    }
}
