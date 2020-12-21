import org.testng.SkipException;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class TestBase {


    public void skipIfNotFixed(int issueId) throws RemoteException, MalformedURLException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }

    public boolean isIssueOpen(int issueId) throws RemoteException, MalformedURLException {

        String issueStatus = getIssueStatus(issueId);
        return !issueStatus.equals("closed");
    }

    private String getIssueStatus(int issueId) {
        return null; //!issueStatus.equals("closed");
    }
}
