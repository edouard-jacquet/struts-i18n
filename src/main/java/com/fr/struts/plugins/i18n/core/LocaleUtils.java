package com.fr.struts.plugins.i18n.core;

import java.text.MessageFormat;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import com.fr.struts.plugins.i18n.core.context.LocaleContextHolder;

public final class LocaleUtils {

	private LocaleUtils() {

	}

	/**
	 * Obtient un message à partir d'une clé.
	 *
	 * @param key La clé associée au message.
	 * @return Le message trouvé, ou la clé si le message n'existe pas.
	 */
	public static String getText(String key) {
		try {
			return LocaleUtils.getBundle().getString(key);
		} catch (MissingResourceException exception) {
			return key;
		}
	}

	/**
	 * Obtient un message à partir d'une clé, et le formate avec les paramètres.
	 *
	 * @param key        La clé associée au message.
	 * @param parameters
	 * @return Le message trouvé, ou la clé si le message n'existe pas.
	 */
	public static String getText(String key, Object[] parameters) {
		String text = LocaleUtils.getText(key);

		MessageFormat formatter = new MessageFormat(text);

		return formatter.format(parameters);
	}

	/**
	 * Obtient un message à partir d'une clé, et le formate avec les paramètres.
	 *
	 * @param key        La clé associée au message.
	 * @param parameters
	 * @return Le message trouvé, ou la clé si le message n'existe pas.
	 */
	public static String getText(String key, List<Object> parameters) {
		return LocaleUtils.getText(key, parameters.toArray());
	}

	/**
	 * Obtient un message à partir d'une clé, et le formate avec le paramètre.
	 *
	 * @param key       La clé associée au message.
	 * @param parameter
	 * @return Le message trouvé, ou la clé si le message n'existe pas.
	 */
	public static String getText(String key, Object parameter) {
		return LocaleUtils.getText(key, new Object[] { parameter });
	}

	private static ResourceBundle getBundle() {
		return LocaleContextHolder.getContext().getBundle();
	}

}
