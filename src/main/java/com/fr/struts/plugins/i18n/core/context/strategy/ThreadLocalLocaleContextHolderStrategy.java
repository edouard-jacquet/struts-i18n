package com.fr.struts.plugins.i18n.core.context.strategy;

import com.fr.struts.plugins.i18n.core.context.BasicLocaleContext;
import com.fr.struts.plugins.i18n.core.context.LocaleContext;

public final class ThreadLocalLocaleContextHolderStrategy implements LocaleContextHolderStrategy {

	private static final ThreadLocal<LocaleContext> contextHolder = new ThreadLocal<LocaleContext>();

	@Override
	public LocaleContext getContext() {
		LocaleContext localeContext = ThreadLocalLocaleContextHolderStrategy.contextHolder.get();

		if (localeContext == null) {
			localeContext = this.createEmptyContext();
			ThreadLocalLocaleContextHolderStrategy.contextHolder.set(localeContext);
		}

		return localeContext;
	}

	@Override
	public void setContext(LocaleContext localeContext) {
		ThreadLocalLocaleContextHolderStrategy.contextHolder.set(localeContext);
	}

	@Override
	public void clearContext() {
		ThreadLocalLocaleContextHolderStrategy.contextHolder.remove();
	}

	@Override
	public LocaleContext createEmptyContext() {
		return new BasicLocaleContext();
	}

}
