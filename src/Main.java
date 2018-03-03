import com.upwork.fb.crawler.domain.FacebookData;
import com.upwork.fb.crawler.factory.FacebookCrawlerFactory;

public class Main {

	public static void main(String[] args) {
		final FacebookData makeRequest = FacebookCrawlerFactory.newInstance("sascust@gmail.com", "metafisica", "149102852110068").makeRequest();
		
	}
}
	