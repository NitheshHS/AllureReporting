package generateReport;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class TestCase2 {
	@Severity(SeverityLevel.MINOR)
	@Epic("VT_02")
	@Story("User is able to create product")
	@Description("create product")
	@Test
	public void createProductTest() {
		System.out.println("Product is created successfuly");
	}

}
