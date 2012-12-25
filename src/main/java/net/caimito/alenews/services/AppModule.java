package net.caimito.alenews.services;

import org.apache.commons.lang.StringUtils;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This module is automatically included as part of the Tapestry IoC Registry,
 * it's a good place to configure and extend Tapestry, or to place your own
 * service definitions.
 */
public class AppModule {
	private static Logger LOGGER = LoggerFactory.getLogger(AppModule.class) ;
	
	public static void bind(ServiceBinder binder) {
		binder.bind(SectionService.class) ;
	}
	
	public static ArticleStore buildArticleStore() {
		String aleNewsDir = System.getenv("ALE_NEWS_HOME") ;
		if (StringUtils.isEmpty(aleNewsDir)) {
			LOGGER.warn("ALE_NEWS_HOME not set. Using /tmp for articles files") ;
			return new FileArticleStore("/tmp/articles.yaml") ;
		} else
			return new FileArticleStore(aleNewsDir + "/articles.yaml") ;
	}

	public static void contributeFactoryDefaults(MappedConfiguration<String, Object> configuration) {
		configuration.override(SymbolConstants.APPLICATION_VERSION, "1.0-SNAPSHOT");
	}

	public static void contributeApplicationDefaults(MappedConfiguration<String, Object> configuration) {
		configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en,es,de");
	}

}
