package generateReport;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;

public class TestCase1 {
	@Test
	@Description("Test1")
	@Epic("VT_01")
	@Severity(SeverityLevel.CRITICAL)
	@Step("This is test1")
	public void test1() {
		System.out.println("test1");
	}
	@Test
	@Description("Test2")
	@Epic("VT_01")
	@Severity(SeverityLevel.MINOR)
	@Step("This is test2")
	public void test2() {
		System.out.println("test2");
	}
	@Test
	@Description("Test3")
	@Epic("VT_01")
	@Severity(SeverityLevel.NORMAL)
	@Step("This is test3")
	public void test3() {
		System.out.println("test3");
	}

}
