package sikayetVarTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import sikayetVar.HttpRequests;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ParserTest{
	private BufferedReader reader;
	private HttpRequests client;
	private String expected;
	private String tested;
	@Before
	public void setUp() throws Exception{
		File file = new File("sikayetlerTest.txt");
		reader = new BufferedReader(new FileReader(file));
		client = Mockito.mock(HttpRequests.class);
		Mockito.when(client.sendGetRequest()).thenReturn(reader.toString());
	}
	@Test
	public void testClient() throws Exception{
		Document doc1 = Jsoup.parse(client.sendGetRequest());
		tested = doc1.text();
		expected = reader.toString();
		Assert.assertEquals(expected,tested);
	}
	@After
	public void AfterTest() throws Exception{
		reader.close();
	}
}