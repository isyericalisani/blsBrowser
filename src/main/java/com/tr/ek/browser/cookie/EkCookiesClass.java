package com.tr.ek.browser.cookie;

import java.io.Serializable;
import java.net.HttpCookie;
import java.net.URI;
import java.util.Objects;

public class EkCookiesClass implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private URI uri;
    private String name;
    private String value;
    private String domain;
    private String path;
    private String portList;
    private String comment;
    private String commentURL;
    private boolean httpOnly;
    private boolean discard;
    private long maxAge;
    private boolean secure;
    private int version;



    public EkCookiesClass(URI uri, HttpCookie cookie){
        name = cookie.getName();
        value = cookie.getValue();
        domain = cookie.getDomain();
        maxAge =cookie.getMaxAge();
        path = cookie.getPath();
        httpOnly = cookie.isHttpOnly();
        portList = cookie.getPortlist();
        discard = cookie.getDiscard();
        secure = cookie.getSecure();
        version = cookie.getVersion();
        comment = cookie.getComment();
        commentURL = cookie.getCommentURL();
        this.uri = uri;
    }

    public HttpCookie toCookie(){
        HttpCookie cookie =  new HttpCookie(this.name,this.value);
        cookie.setSecure(secure);
        cookie.setDomain(domain);
        cookie.setMaxAge(maxAge);
        cookie.setPath(path);
        cookie.setHttpOnly(httpOnly);
        cookie.setPortlist(portList);
        cookie.setDiscard(discard);
        cookie.setVersion(version);
        cookie.setComment(comment);
        cookie.setCommentURL(commentURL);
        cookie.setValue(value);
        return cookie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EkCookiesClass that = (EkCookiesClass) o;
        return  uri.equals(that.uri) &&
                name.equals(that.name);

    }

    @Override
    public int hashCode() {
        return Objects.hash(uri, name);
    }
}