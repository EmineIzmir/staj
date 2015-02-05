package sikayetVar;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import sikayetVar.HttpRequests;
import sikayetVar.File_Writer;

public class HtmlParser {
	private String[] url = new String[10];
	private ArrayList<Complaint> newComplaints = new ArrayList<Complaint>();
	private HttpRequests _client = new HttpRequests();

	public void parser(ArrayList<Complaint> complaintList)
			throws Exception {
		for (int i = 0; i < 10; i++) {
			Document doc = Jsoup.parse(new HttpRequests().sendPostRequest(i));
			url = takeUrlsFromMainPage(doc);
			createComplaintList(complaintList);
		}
		complaintList.addAll(0,newComplaints);
		new File_Writer().createJson(complaintList, "sikayetler.json");
	}

	public void createComplaintList(ArrayList<Complaint> complaintList)
			throws Exception {
		for (int j = 0; j < 10; j++) {
			_client.setUrl("http:" + url[j] + "/");
			Document doc2 = Jsoup.parse(_client.sendGetRequest());
			Complaint complaint = createComplaintObject(doc2);
			if (!complaintList.toString().contains(complaint.toString()))
				newComplaints.add(complaint);
		}
	}

	public Complaint createComplaintObject(Document htmlCode) throws Exception {
		String a, b, c, d, e;
		Element element = htmlCode.body().select(" div > h1").first();
		c = element.select("a").text();
		a = element.text();
		b = htmlCode.body().select("p.sikayetDetayMetin").text();
		d = htmlCode.body().select("font.sikayetDurumu").text();
		e = htmlCode.body().select("span.sikayetBilgi > a").text();

		return new Complaint(a, b, c, d, e);
	}

	public String[] takeUrlsFromMainPage(Document htmlCode) throws IOException {
		for (int i = 0; i < 10; i++) {
			Element element = htmlCode.body().select(" h3 > a").get(i);
			url[i] = element.attr("href");
		}
		return url;
	}
}
