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

//File to run single tests instead of whole testset from soapui.

public class UnitTestRunner 
{
	
	@Test
	public void singletestrunner() throws XmlException, IOException, SoapUIException
		{
			WsdlProject project = new WsdlProject("C:\\Users\\tacio.degrazia\\Documents\\SOAP_Testing\\SOAP_Projects\\NewLibrary-API-soapui-project.xml");
			//grab the testsuite into the project - Insert the name of your test suite below.
			WsdlTestSuite testsuite=project.getTestSuiteByName("TestSuite");
			//inster the name of the test suite you want to execute.
			WsdlTestCase testcase= testsuite.getTestCaseByName("GetBook.php TestCase2");
			
			TestRunner	runner= testcase.run(new PropertiesMap(), false);
			Assert.assertEquals(Status.FINISHED, runner.getStatus());
		
		
		
		}

}
