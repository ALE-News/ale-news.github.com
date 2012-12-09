package net.caimito.alenews.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

public class FileArticleStore implements ArticleStore {
	private static Logger LOGGER = LoggerFactory.getLogger(FileArticleStore.class) ;
	
	private File articleFile;

	public FileArticleStore(final String fileName) {
		this.articleFile = new File(fileName);
	}

	public FileArticleStore() {
		try {
			File articleFile = File.createTempFile("articles", null);
			articleFile.deleteOnExit();

			this.articleFile = articleFile;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Article> listArticles(Locale locale, int limitNumberOfArticles) {
		List<Article> loadedArticles = loadYaml();
		List<Article> articles = new ArrayList<Article>();

		for (Article article : loadedArticles) {
			if (article.getLanguage().equals(locale.getLanguage())) {
				articles.add(article);
				if (articles.size() == limitNumberOfArticles)
					break ;
			}
		}

		if (limitNumberOfArticles == ArticleStore.NO_LIMIT)
			LOGGER.info("METRIC: Listing {} articles for language {}. No limit of articles set.", articles.size(), locale.getLanguage()) ;
		else
			LOGGER.info("METRIC: Listing {} articles for language {}. Limit for articles is {}", articles.size(), locale.getLanguage(), limitNumberOfArticles) ;
		
		return articles;
	}

	private List<Article> loadYaml() {
		Set<Article> articles = new HashSet<Article>();
		Yaml yaml = new Yaml();

		try {
			InputStream input = new FileInputStream(articleFile);
			for (Object collection : yaml.loadAll(input)) {
				for (Object item : (Iterable<Object>) collection) {
					Article article = (Article) item;
					articles.add(article);
				}
			}
		} catch (FileNotFoundException e) {
			return new ArrayList<Article>(articles);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		LOGGER.info("METRIC: Loaded {} total articles", articles.size()) ;
		return new ArrayList<Article>(articles);
	}

	public List<Article> listArticlesByTopic(Locale locale, String topic, int limitNumberOfArticles) {
		List<Article> loadedArticles = loadYaml();
		List<Article> articles = new ArrayList<Article>();

		for (Article article : loadedArticles) {
			if (article.getTopic().equals(topic) && article.getLanguage().equals(locale.getLanguage()))
				articles.add(article);
			if (articles.size() == limitNumberOfArticles)
				break ;
		}

		if (limitNumberOfArticles == ArticleStore.NO_LIMIT)
			LOGGER.info("METRIC: Listing {} articles for language {} and topic {}. No limit of articles set.", articles.size(), locale.getLanguage(), topic) ;
		else
			LOGGER.info("METRIC: Listing {} articles for language {} and topic {}. Limit for articles is {}", articles.size(), locale.getLanguage(), topic, limitNumberOfArticles) ;

		return articles;
	}

	public void add(Article article) {
		Collection<Article> existingArticles = loadYaml();
		existingArticles.add(article);

		Yaml yaml = new Yaml();
		try {
			FileWriter writer = new FileWriter(articleFile);
			writer.write(yaml.dump(existingArticles));
			writer.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
