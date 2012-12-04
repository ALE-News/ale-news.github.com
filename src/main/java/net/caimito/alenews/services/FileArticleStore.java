package net.caimito.alenews.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;

import org.yaml.snakeyaml.Yaml;

public class FileArticleStore implements ArticleStore {

	public Collection<Article> listArticles(Locale locale) {
		Collection<Article> loadedArticles = loadYaml() ;
		Collection<Article> articles = new HashSet<Article>() ;
		
		for (Article article : loadedArticles) {
			if (article.getLanguage().equals(locale.getLanguage()))
				articles.add(article) ;
		}
		
		return articles ;
	}
	
	private Collection<Article> loadYaml() {
		Collection<Article> articles = new HashSet<Article>() ;
		Yaml yaml = new Yaml() ;
		
		try {
			InputStream input = new FileInputStream(new File("/tmp/articles.yaml"));
			for (Object collection : yaml.loadAll(input)) {
				for (Object item : (Iterable<Object>)collection) {
					Article article = (Article)item ;
					articles.add(article) ;
				}
			}
		} catch (FileNotFoundException e) {
			return articles ;
		} catch (Exception e) {
			throw new RuntimeException(e) ;
		}
		
		return articles ;
	}

	public Collection<Article> listArticlesByTopic(Locale locale, String topic) {
		throw new RuntimeException("Not yet implemented");
	}

	public void add(Article article) {
		Collection<Article> existingArticles = loadYaml() ;
		existingArticles.add(article) ;
		
		Yaml yaml = new Yaml() ;
		String output = yaml.dump(existingArticles) ;
		System.out.println(output) ;

		try {
			FileWriter writer = new FileWriter("/tmp/articles.yaml") ;
			writer.write(output) ;
			writer.close() ;
		} catch (Exception e) {
			throw new RuntimeException(e) ;
		}
	}

}
