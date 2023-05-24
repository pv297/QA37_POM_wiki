package tests;


import manage.ConfigurationWiki;
import manage.MyDataProvider;
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

    @Test
    public void login2(){
        User user = User.builder().userName("juliakliot.jk").password("Misha240613").build();
        String inf = new MainScreen(driver)
                .clickTheFlowButton()
                .cklickTheLoginButton()
                .fillInLoginForm(user)
                .clickTheFlowButton()
                .getInf();
        Assert.assertEquals(inf,"Juliakliot.jk");
    }
    @Test
    public void login3(){
        User user = User.builder().userName("juliakliot.jk").password("Misha240613").build();
        String infOut= new MainScreen(driver)
                .clickTheFlowButton()
                .cklickTheLoginButton()
                .fillInLoginForm(user)
                .clickTheFlowButton()
                .getInfOut();
        Assert.assertEquals(infOut,"Log out");

    }
    @Test(dataProvider = "loginData", dataProviderClass = MyDataProvider.class)
    public void login4(User user){
        //User user = User.builder().userName("juliakliot.jk").password("Misha240613").build();
        String infLog = new MainScreen(driver)
                .clickTheFlowButton()
                .cklickTheLoginButton()
                .fillInLoginForm(user)
                .clickTheFlowButton()
                .logOut()
                .clickTheFlowButton()
                .getIngLog();
        Assert.assertEquals(infLog, "Log in to Wikipedia");

    }
    @Test(dataProvider = "loginDataCsv", dataProviderClass = MyDataProvider.class)
    public void login5(User user){
        // User user = User.builder().userName("juliakliot.jk").password("Misha240613").build();
        String infLog = new MainScreen(driver)
                .clickTheFlowButton()
                .cklickTheLoginButton()
                .fillInLoginForm(user)
                .clickTheFlowButton()
                .logOut()
                .clickTheFlowButton()
                .getIngLog();
        Assert.assertEquals(infLog, "Log in to Wikipedia");

    }

}