package tests;

import manage.ConfigurationWiki;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.MainScreen;

public class Login extends ConfigurationWiki {

    @Test
    public void  login1(){
        User user = User.builder().userName("juliakliot.jk").password("Misha240613").build();
        boolean isLogged = new MainScreen(driver)
                .clickTheFlowButton()
                .cklickTheLoginButton()
                .fillInLoginForm(user)
                .clickTheFlowButton()
                .isLogged();
        Assert.assertTrue(isLogged);
    }
}