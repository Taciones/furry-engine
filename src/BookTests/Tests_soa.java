package BookTests;
import java.io.IOException;
import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.support.SoapUIException;

public class Tests_soa {
	@Test //JAVA API to run all the tests on test suite with TESTNG.
public void SoapTest() throws XmlException, IOException, SoapUIException
	{
		//Grab the project
		WsdlProject project = new WsdlProject("C:\\Users\\tacio.degrazia\\Documents\\SOAP_Testing\\SOAP_Projects\\NewLibrary-API-soapui-project.xml");
		//grab the testsuite into the project - Insert the name of your test suite below.
		WsdlTestSuite testsuite=project.getTestSuiteByName("TestSuite");
		
		//Looping to execute all the tests remaining in the project.	
		for(int i=0;i<testsuite.getTestCaseCount();i++)
			{
			
				WsdlTestCase testcase = testsuite.getTestCaseAt(i);
				//run the testCase. It will run all tests from soapui, if they are finished it will suceed here.
				TestRunner	runner= testcase.run(new PropertiesMap(), false);
				Assert.assertEquals(Status.FINISHED, runner.getStatus());
			
			}
	}

}
