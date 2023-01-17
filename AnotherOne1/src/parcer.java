import java.io.IOException;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.select.*;
import org.jsoup.nodes.*;
import org.jsoup.*;
public class parcer {
	public static void main(String[] args) throws IOException{
		String link;
		Document doc = Jsoup.connect("https://igis-transport.ru/izh/citybus?").get();
		Elements busNumberElements = doc.getElementsByClass("number");
		for(Element busNumberElement : busNumberElements) {
			String busNumber = busNumberElement.select("a").first().ownText();
			link = "https://igis-transport.ru" + busNumberElement.select("a").first().attr("href");
			Document LinkDoc = Jsoup.connect(link).get();
			Elements busPositions = LinkDoc.getElementsByClass("position");
			System.out.printf("%s:",busNumber);
			for(Element busPosition : busPositions) {
				try {
					String position = busPosition.select("span").first().ownText();
					System.out.printf("%s",position);
					/*String busStationLink = busStation.select("a").first().attr("href");
					link = "https://igis-transport.ru" + busStationLink;
					Document busStationDoc = Jsoup.connect(link).get();
					Elements busStationName = busStationDoc.getElementsByAttributeValue("id", "head");
					String name = busStationName.first().ownText();
					System.out.printf("%s,",name);*/
				}catch(NullPointerException e) {
					System.out.printf("");
				}
			}
			System.out.println();
		}
	}
}
