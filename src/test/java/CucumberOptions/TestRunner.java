package CucumberOptions;

import java.io.File;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions( features = "src/test/java/Feature", tags = "@Regression",
//"@StockLiftLogin, @CategoryCreate, @SignUp, @SocialSignup, @TickersList, @ChangePassword, @NetworkScreen, @Watchlist, @UserView, @ArticleTypeManagement, @PostCreation, @ArticleLike, @EditProfile, @ArticleView, @FriendRequest, @ArticleComment, @ArticleCommentReply,  @ArticleSearch,  @MailRepot",  
glue =  { "StepDefinition" }, 
//plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, 
monochrome = true
		)
public class TestRunner {


}

