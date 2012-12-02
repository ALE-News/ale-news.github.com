package net.caimito.alenews.pages.admin.article;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import net.caimito.alenews.pages.Index;
import net.caimito.alenews.services.Article;
import net.caimito.alenews.services.ArticleStore;

public class Add {

	@Property
	private Article article ;
	
	@Inject
	private ArticleStore articleStore ;
	
	public Object onSuccess() {
		articleStore.add(article) ;
		return Index.class ;
	}
}
