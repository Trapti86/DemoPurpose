import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

public class Winium {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		DesktopOptions option = new DesktopOptions();
		 
		option.setApplicationPath("C://Program Files//WindowsApps//Microsoft.Office.Desktop.Outlook_16051.11901.20176.0_x86__8wekyb3d8bbwe//Office16//OUTLOOK.exe");
		 
		WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"), option);
		//driver.findElement(By.name("Inbox: 11 unread messages")).click();
       // driver.findElementByName("Inbox: 12 unread messages").click();
        //driver.findElementByName("Send / Receive").click();
        driver.findElement(By.name("Send / Receive")).click();
        Thread.sleep(5000);
        //driver.findElementByName("Update Folder").click();
        
        driver.findElement(By.name("Inbox - kapil.goswami@mphasis.com - Outlook")).click();
        driver.findElement(By.name("Inbox")).click();
        Thread.sleep(5000);
        driver.findElement(By.name("kapil.goswami@mphasis.com")).click();
        driver.findElement(By.name("Inbox: 12 unread messages")).click();
        driver.findElement(By.name("From MediBuddy, Subject [External] Re:Insurance policy, Received Wed 14-08, Size 99 KB, Flag Status Unflagged, "));
        //driver.findElementByName("From eTMS Admin, Subject (Auto Approved)Transport Ad-hoc request raised - #AD1459001, Received Wed 10:33, Size 48 KB, Flag Status Unflagged, ").click();
        Thread.sleep(5000);

	}

}


