package vn.nta.appiumtest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Sample {
    static AndroidDriver<MobileElement> driver;
    static DesiredCapabilities dc;
    public static void main(String[] args) throws MalformedURLException {

        // Thiết lập các thông tin để kết nối với thiết bị Android và khởi động ứng dụng
        dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "emulator-5554");
        dc.setCapability("platformName", "Android");
        dc.setCapability("appPackage", "com.android.calculator2");
        dc.setCapability("appActivity", "com.android.calculator2.Calculator");

        // Khởi tạo các đối tượng driver để thực thi kiểm thử
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        System.out.println("Application Started...");

        // Các bước tương tác với ứng dụng
        driver.findElementById("com.android.calculator2:id/digit_5").click();
        driver.findElementByAccessibilityId("plus").click();
        driver.findElementById("com.android.calculator2:id/digit_6").click();
        driver.findElementByAccessibilityId("equals").click();

        // Kiểm tra kết quả hiển thị
        Assert.assertEquals(driver.findElementById("com.android.calculator2:id/result").getText(), "11");

        // Kết thúc kiểm thử bằng việc đóng ứng dụng
        System.out.println("Testing done");
        //driver.quit();
    }

}
