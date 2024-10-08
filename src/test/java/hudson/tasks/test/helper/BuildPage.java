package hudson.tasks.test.helper;

import java.io.IOException;
import org.htmlunit.html.HtmlPage;
import org.xml.sax.SAXException;

public class BuildPage extends AbstractPage {

    public BuildPage(HtmlPage htmlPage) {
        super(htmlPage);
    }

    @Override
    protected String getHrefFromTestUrl(String testUrl) {
        return testUrl + "/";
    }

    public TestResultLink getAggregatedTestReportLink() throws IOException, SAXException {
        return new TestResultLink(getTestReportAnchor(AGGREGATED_TEST_REPORT_URL));
    }

    public TestResultLink getTestReportLink() throws IOException, SAXException {
        return new TestResultLink(getTestReportAnchor(TEST_REPORT_URL));
    }

    public void assertNoTestReportLink() {
        assertNoLink(TEST_REPORT_URL);
    }

    public void assertNoAggregatedTestReportLink() {
        assertNoLink(AGGREGATED_TEST_REPORT_URL);
    }
}
