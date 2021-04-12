package JiraConfig;



import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.Issue.FluentCreate;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

public class JiraServiceProvider {
	public JiraClient jiraClient;
	String project;

	public JiraServiceProvider(String jiraUrl,String username,String password,String project) {
		BasicCredentials creds=new BasicCredentials(username, password);
		jiraClient=new JiraClient(jiraUrl, creds);
		this.project=project;
	}
	
	public void createJiraTicket(String issueType,String summary,String description,String assignee) {
		FluentCreate fluentCreate;
		try {
			fluentCreate = jiraClient.createIssue(project, issueType);
			fluentCreate.field(Field.SUMMARY, summary);
			fluentCreate.field(Field.DESCRIPTION, description);
			fluentCreate.field(Field.ASSIGNEE, assignee);
			Issue issue = fluentCreate.execute();
			System.out.println("new issue is created in jira with ID: "+issue);
		} catch (JiraException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
