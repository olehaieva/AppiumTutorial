import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
//tap imported
//added import io.appium.java_client.TouchAction;
//added import static io.appium.java_client.touch.TapOptions.tapOptions;
//added import static io.appium.java_client.touch.offset.ElementOption.element;
//added import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
//added import static java.time.Duration.ofSeconds;

public class gestures  extends base{

	public static void main(String[] args) throws MalformedURLException{
		AndroidDriver<AndroidElement> driver=Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//works	driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		//	driver.findElementByXPath("//android.widget.TextView[@text=‘Views’]").click();
		driver.findElementByXPath("//android.widget.TextView[@index='10']").click();
		
		
		TouchAction touchact =new TouchAction(driver);
		//WebElement expandList=driver.findElementByXPath("//android.widget.TextView[@text=‘Expandable Lists’]");
		WebElement expandList=driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")");
		touchact.tap(tapOptions().withElement(element(expandList))).perform();
		// driver.findElementByXPath("//android.widget.TextView[@text=‘1. Custom Adapter’]").click();
		driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")").click();
		
		WebElement pn=driver.findElementByAndroidUIAutomator("text(\"People Names\")");
		touchact.longPress(longPressOptions().withElement(element(pn)).withDuration(ofSeconds(2))).release().perform();
		System.out.println(driver.findElementById("android:id/content").isDisplayed());
	}

}
  