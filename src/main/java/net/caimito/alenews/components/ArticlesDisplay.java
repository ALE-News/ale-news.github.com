package net.caimito.alenews.components;

import java.util.Collection;
import java.util.List;
import java.util.Locale;

import net.caimito.alenews.services.Article;
import net.caimito.alenews.services.ArticleCollectionGrouper;
import net.caimito.alenews.services.ArticleStore;

import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArticlesDisplay {
	private static Logger LOGGER = LoggerFactory.getLogger(ArticlesDisplay.class) ;

	@Parameter
	private String topicSection ;
	
	@Parameter
	private int numberOfArticles ;
	
	@Parameter
	private int articlesPerRow ;
	
	@Property
	private Collection<Article> articleRow ;
	
	@Property
	private Article article ;
	
	@Inject
	private ArticleStore articleStore ;
	
	@Inject
	private Locale currentLocale ;
	
	@Inject
	private Response response ;
	
	public List<List<Article>> getArticles() {
		ArticleCollectionGrouper grouper = new ArticleCollectionGrouper() ;
		
		if (numberOfArticles == 0)
			numberOfArticles = ArticleStore.NO_LIMIT ;
		
		return grouper.group(articleStore.listArticlesByTopic(currentLocale, topicSection, numberOfArticles), articlesPerRow) ;
	}
	
	public Object onActionFromGotoArticle(String url) {
		try {
			LOGGER.info("METRIC: Sending visitor to {}", url) ;
			response.sendRedirect(url) ;
			return null ;
		} catch (Exception e) {
			LOGGER.error("Redirect to article URL failed", e) ;
			return null ;
		}
	}
}
