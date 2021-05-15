package com.fr.struts.plugins.i18n.core.context;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

public interface LocaleContext extends Serializable {

	/**
	 * Retourne le locale associé lié à l'utilisateur.
	 *
	 * @return le locale lié.
	 */
	public Locale getLocale();

	/**
	 * Défini le locale lié à l'utilisateur.
	 *
	 * @param locale le locale à lier.
	 */
	public void setLocale(Locale locale);

	/**
	 * Retourne le bundle associé lié à l'utilisateur.
	 *
	 * @return le bundle lié.
	 */
	public ResourceBundle getBundle();

	/**
	 * Défini le bundle lié à l'utilisateur.
	 *
	 * @param bundle le bundle à lier.
	 */
	public void setBundle(ResourceBundle bundle);

}
