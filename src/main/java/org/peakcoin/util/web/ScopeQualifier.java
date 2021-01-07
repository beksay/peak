package org.peakcoin.util.web;

import javax.servlet.http.HttpSession;

import org.peakcoin.enums.ScopeConstants;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

public interface ScopeQualifier {
	
	public <U> U getValue(String name, ScopeConstants scope);
	public <U> void setValue(String name, U u, ScopeConstants scope);
	public void remove(String name, ScopeConstants scope);
	public HttpSession getSession();

}