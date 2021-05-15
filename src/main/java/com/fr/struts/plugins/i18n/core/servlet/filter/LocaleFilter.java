package com.fr.struts.plugins.i18n.core.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fr.struts.plugins.i18n.core.context.LocaleContextHolder;

public class LocaleFilter implements Filter {

	private Logger logger = LogManager.getLogger(LocaleFilter.class);

	public LocaleFilter() {

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.logger.info("Success to initialize Struts Locale");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		try {
			LocaleContextHolder.setLocale(request.getLocale());

			chain.doFilter(request, response);
		} finally {
			LocaleContextHolder.clearContext();
		}
	}

	@Override
	public void destroy() {
		this.logger.info("Success to destroy Struts Locale");
	}

}
