package net.caimito.alenews.util;

import java.util.Locale;

import net.caimito.alenews.services.Article;

public class ArticleFactory {

	public static Article createArticle(Locale locale, String title, String summary, String destinationUrl, String topic) {
		Article article = new Article() ;
		article.setDestinationUrl(destinationUrl) ;
		article.setLanguage(locale.getISO3Language()) ;
		article.setTopic(topic) ;
		article.setSummary(summary) ;
		article.setTitle(title) ;
		return article ;
	}
	
}
