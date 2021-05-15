package com.fr.struts.plugins.i18n.core.context;

import java.util.Locale;
import java.util.ResourceBundle;

import com.fr.struts.plugins.i18n.core.context.strategy.LocaleContextHolderStrategy;
import com.fr.struts.plugins.i18n.core.context.strategy.ThreadLocalLocaleContextHolderStrategy;

public final class LocaleContextHolder {

	private static final String BUNDLE_NAME = "languages/messages";
	private static LocaleContextHolderStrategy strategy;

	private LocaleContextHolder() {

	}

	static {
		LocaleContextHolder.initialize();
	}

	/**
	 * Récupère le contexte de langue.
	 *
	 * @return le contexte.
	 */
	public static LocaleContext getContext() {
		return LocaleContextHolder.strategy.getContext();
	}

	/**
	 * Défini le contexte de langue.
	 *
	 * @param localeContext le contexte.
	 */
	public static void setContext(LocaleContext localeContext) {
		LocaleContextHolder.strategy.setContext(localeContext);
	}

	/**
	 * Nettoie le contexte de langue.
	 */
	public static void clearContext() {
		LocaleContextHolder.strategy.clearContext();
	}

	/**
	 * Créer un nouveau contexte de langue.
	 *
	 * @return le nouveau contexte.
	 */
	public static LocaleContext createEmptyContext() {
		return LocaleContextHolder.strategy.createEmptyContext();
	}

	/**
	 * Défini le nouveau locale, recharge le ResourceBundle correspondant.
	 *
	 * @param locale Le nouveau locale
	 */
	public static void setLocale(Locale locale) {
		LocaleContext context = LocaleContextHolder.getContext();

		context.setLocale(locale);
		context.setBundle(ResourceBundle.getBundle(LocaleContextHolder.BUNDLE_NAME, locale));
	}

	private static void initialize() {
		LocaleContextHolder.strategy = new ThreadLocalLocaleContextHolderStrategy();
	}

}
