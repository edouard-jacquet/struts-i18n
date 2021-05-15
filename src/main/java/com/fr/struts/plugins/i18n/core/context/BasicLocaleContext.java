package com.fr.struts.plugins.i18n.core.context;

import java.util.Locale;
import java.util.ResourceBundle;

public class BasicLocaleContext implements LocaleContext {

	private static final long serialVersionUID = 242424204641269786L;

	private Locale locale;
	private transient ResourceBundle bundle;

	public BasicLocaleContext() {

	}

	@Override
	public Locale getLocale() {
		return this.locale;
	}

	@Override
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	@Override
	public ResourceBundle getBundle() {
		return this.bundle;
	}

	@Override
	public void setBundle(ResourceBundle bundle) {
		this.bundle = bundle;
	}

}
