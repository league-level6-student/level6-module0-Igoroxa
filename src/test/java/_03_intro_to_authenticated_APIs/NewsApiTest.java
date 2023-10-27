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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class NewsApiTest {


 @Mock
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
    	assertTrue(res.equals("12 Cozy Podcasts to Warm Your Mind, Body, and Soul"));
 
    }

    @Test
    void itShouldFindStory(){
        //given
    	ApiExampleWrapper wrap = new ApiExampleWrapper();
    	List<Article> arts = new ArrayList<Article>();
    	arts.add(new Article());
    	wrap.setArticles(arts);
    	arts.get(0).setTitle("12 Cozy Podcasts to Warm Your Mind, Body, and Soul");
    	arts.get(0).setUrl("https://lifehacker.com/best-cozy-podcasts-1850950191");
    	arts.get(0).setContent("In todays fast-paced world, as glaring screens and blaring social media notification demand our attention, the allure of a cozy podcast offers a soothing respite. Picture yourself nestled under a war… [+8245 chars]");

        String test =
                arts.get(0).getTitle() + " -\n"
                        + arts.get(0).getContent()
                        + "\nFull article: " + arts.get(0).getUrl();

        //when
       // when(news.getNewsStoryByTopic("world")).thenReturn(wrap);
    	String real = news.findStory("world");
        //thenReturn
    	
    	assertTrue(real.equals(test));
    }


}