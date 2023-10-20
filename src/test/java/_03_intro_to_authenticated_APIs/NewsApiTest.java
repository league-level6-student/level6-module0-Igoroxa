package _03_intro_to_authenticated_APIs;

import _03_intro_to_authenticated_APIs.data_transfer_objects.ApiExampleWrapper;
import _03_intro_to_authenticated_APIs.data_transfer_objects.Article;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class NewsApiTest {


 
  NewsApi news;
  
  @Mock
  Article art;
  
  @Mock
  ApiExampleWrapper wrap;

    @BeforeEach
    void setUp() {
    	MockitoAnnotations.openMocks(this);
    	news = new NewsApi();
    }

    @Test
    void itShouldGetNewsStoryByTopic() {
        //given
    	ApiExampleWrapper example = news.getNewsStoryByTopic("world");
    	List<Article> art = example.getArticles();
    	String res = art.get(0).getTitle();
    	
        //when
    	
        //then
    	assertTrue(res.equals("Use 'Project-Based Learning' to Study on Your Own"));
 
    }

    @Test
    void itShouldFindStory(){
        //given
    	ApiExampleWrapper wrap = new ApiExampleWrapper();
    	List<Article> arts = null;
    	wrap.setArticles(arts);
    	arts.add(new Article());
    	arts.get(0).setTitle("Use 'Project-Based Learning' to Study on Your Own");
    	arts.get(0).setUrl("https://lifehacker.com/best-new-features-android-14-1850897684");
    	arts.get(0).setContent("Made by Google 2023 is officially here, and with it, exciting product announcements. Weve now gotten our eyes on the Pixel 8 and Pixel 8 Pro, the Pixel Watch 2, and two new colors for Pixel Buds Pro.… [+3783 chars]");
    	when(news.getNewsStoryByTopic("world")).thenReturn(wrap);

        String test =
                arts.get(0).getTitle() + " -\n"
                        + arts.get(0).getContent()
                        + "\nFull article: " + arts.get(0).getUrl();

        //when
    	String real = news.findStory("world");
        //thenReturn
    	
    	assertTrue(real.equals(test));
    }


}