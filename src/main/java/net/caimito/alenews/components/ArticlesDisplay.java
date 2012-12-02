package net.caimito.alenews.components;

import java.util.Collection;

import net.caimito.alenews.services.Article;
import net.caimito.alenews.services.ArticleStore;

import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

public class ArticlesDisplay {

	@Parameter
	private String topicSection ;
	
	@Property
	private Article article ;
	
	@Inject
	private ArticleStore articleStore ;
	
	public Collection<Article> getArticles() {
		return articleStore.listArticlesByTopic(topicSection) ;
	}
}