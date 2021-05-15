package com.fr.struts.plugins.i18n.core.context.strategy;

import com.fr.struts.plugins.i18n.core.context.LocaleContext;

public interface LocaleContextHolderStrategy {

	/**
	 * Récupère le contexte de langue.
	 *
	 * @return le contexte.
	 */
	public LocaleContext getContext();

	/**
	 * Défini le contexte de langue.
	 *
	 * @param localeContext le contexte.
	 */
	public void setContext(LocaleContext localeContext);

	/**
	 * Nettoie le contexte de langue.
	 */
	public void clearContext();

	/**
	 * Créer un nouveau contexte de langue.
	 *
	 * @return le nouveau contexte.
	 */
	public LocaleContext createEmptyContext();

}
