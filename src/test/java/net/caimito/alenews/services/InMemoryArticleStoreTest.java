package net.caimito.alenews.services;

import static org.junit.Assert.* ;
import static org.hamcrest.Matchers.* ;

import org.junit.Test;

public class InMemoryArticleStoreTest {

	@Test
	public void emptyArticleList() {
		ArticleStore articleStore = new InMemoryArticleStore() ;
		assertThat(articleStore.listArticles(), is(empty())) ;
	}
	
	@Test
	public void oneArticle() {
		Article article = new Article("Agile") ;
		
		ArticleStore articleStore = new InMemoryArticleStore() ;
		articleStore.add(article) ;
		assertThat(articleStore.listArticles(), hasItem(equalTo(article))) ;
	}
	
}
