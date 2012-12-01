package net.caimito.alenews.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;

/**
 * Layout component for pages of application ale-news.
 */
@Import(stylesheet = { "context:css/screen.css", "context:css/scaffolding.css" })
public class Frontpage {
	@Property
	@Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
	private String title;
}
