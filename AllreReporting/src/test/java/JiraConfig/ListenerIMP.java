package JiraConfig;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerIMP implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		JiraPolicy jirapolicy = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraPolicy.class);
		JiraServiceProvider jira = new JiraServiceProvider("https://nitheshgowda.atlassian.net/", "nitheshdemo@gmail.com", "1oaKCguQ4JgrgvS3uJw21048", "VTIG");
		String summary=result.getMethod().getConstructorOrMethod().getMethod().getName()
				+ "got failed due to some assertion or exception";
		String description=result.getThrowable().getMessage()+"\n";
		description.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));
		jira.createJiraTicket("Bug", summary, description, "Nithesh Demo");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}


}
