package net.caimito.alenews.components;

import net.caimito.alenews.services.ApplicationPropertiesService;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 * Layout component for pages of application ale-news.
 */
@Import(stylesheet = { "context:css/screen.css", "context:css/scaffolding.css" })
public class Frontpage {
	@Property
	@Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
	private String title;
	
	@Inject
	private ApplicationPropertiesService applicationPropertiesService ;
	
	public String getCurrentVersion() {
		return applicationPropertiesService.getCurrentVersion() ;
	}
}
