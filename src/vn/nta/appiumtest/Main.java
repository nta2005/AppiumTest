package vn.nta.appiumtest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Main {
    static AndroidDriver<MobileElement> driver;
    static DesiredCapabilities dc;

    public static void main(String[] args) throws MalformedURLException {
        //0 is emulator; 1 is real device
        //calculatorApp(0);
        atnApp(0);
    }

    public static void calculatorApp(Integer device) throws MalformedURLException {
        // Thiết lập các thông tin để kết nối với thiết bị Android và khởi động ứng dụng
        dc = new DesiredCapabilities();
        if (device == 0) emulatorDevice(); else realDevice();
        dc.setCapability("platformName", "Android");
        //dc.setCapability("appPackage", "com.android.calculator2");
        //dc.setCapability("appActivity", ".Calculator");

        dc.setCapability("appPackage", "com.coloros.calculator");
        dc.setCapability("appActivity", "com.android.calculator2.Calculator");
        // Khởi tạo các đối tượng driver để thực thi kiểm thử
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("Application Started...");

        // Các bước tương tác với ứng dụng
        driver.findElementById("com.android.calculator2:id/digit_5").click();
        driver.findElementByAccessibilityId("plus").click();
        driver.findElementById("com.android.calculator2:id/digit_6").click();
        driver.findElementByAccessibilityId("equals").click();

        // Kiểm tra kết quả hiển thị
        Assert.assertEquals(driver.findElementById("com.android.calculator2:id/result").getText(), "11");

        // Kết thúc kiểm thử bằng việc đóng ứng dụng
        System.out.println("Testing done, exiting app...");
        driver.quit();
    }

    public static void atnApp(Integer device) throws MalformedURLException {
        // Thiết lập các thông tin để kết nối với thiết bị Android và khởi động ứng dụng
        dc = new DesiredCapabilities();
        if (device == 0) emulatorDevice(); else realDevice();
        dc.setCapability("platformName", "Android");
        dc.setCapability("appPackage", "org.atn21.everydayracism");
        dc.setCapability("appActivity", ".ui.splash.SplashActivity");
        // Khởi tạo các đối tượng driver để thực thi kiểm thử
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("Application Started...");

        // Các bước tương tác với ứng dụng
        driver.findElementById("org.atn21.everydayracism:id/btnSureLetGo").click();
        driver.findElementById("org.atn21.everydayracism:id/btnYes").click();
        driver.findElementById("org.atn21.everydayracism:id/etPostCode").sendKeys("1234");
        driver.findElementById("org.atn21.everydayracism:id/etAge").sendKeys("21");
        driver.findElementById("android:id/text1").click();
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[7]").click();
        driver.findElementById("org.atn21.everydayracism:id/btnContinue").click();
        driver.findElementById("org.atn21.everydayracism:id/etFirstname").sendKeys("All Together");
        driver.findElementById("org.atn21.everydayracism:id/etLastname").sendKeys("Now");
        driver.findElementById("org.atn21.everydayracism:id/etEmail").sendKeys("alltogethernow@gmail.com");
        driver.findElementById("org.atn21.everydayracism:id/btnContinue").click();

        // Kiểm tra kết quả hiển thị
        //Assert.assertEquals(driver.findElementById("com.android.calculator2:id/result").getText(), "11");

        // Kết thúc kiểm thử bằng việc đóng ứng dụng
        System.out.println("Testing done, exiting app...");
        driver.quit();
    }

    public static void emulatorDevice(){
        dc.setCapability("deviceName", "emulator-5554");
        dc.setCapability("udid", "emulator-5554");
    }

    public static void realDevice(){
        dc.setCapability("deviceName", "OPPO F7");
        dc.setCapability("udid", "RG4DDYUWTCEMKRQK");
        dc.setCapability("platformVersion", "10.0");
    }
}
