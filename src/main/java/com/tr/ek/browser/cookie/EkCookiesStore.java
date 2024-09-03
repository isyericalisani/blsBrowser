package com.tr.ek.browser.cookie;

import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class EkCookiesStore 
implements CookieStore 
{
	 private List<HttpCookie> cookies = new ArrayList<>();

	public void add(URI uri, HttpCookie cookie) {
       //cookies.add(new EkCookiesClass(uri,cookie));
       //saveCookieStoreToFile("ekCookie");
	}

	public List<HttpCookie> get(URI uri) {
		// TODO Auto-generated method stub
		/*  
		 * List<HttpCookie> uriCookies = new ArrayList<>();
		    myCookieClass[] tempCookies = cookies.toArray(myCookieClass[]::new);
		    for (myCookieClass c: tempCookies) {
		        if(c.uri.toString().contains(uri.getRawAuthority())){
		            uriCookies.add(c.toCookie());
		        }
		    }
		        return uriCookies;*/
		        
		return null;
	}

	public List<HttpCookie> getCookies() {
		// TODO Auto-generated method stub
		
		/*       
		 *  List<HttpCookie> httpCookies = new ArrayList<>();
        myCookieClass[] tempCookies = cookies.toArray(myCookieClass[]::new);
        for (myCookieClass c : tempCookies) {
            httpCookies.add(c.toCookie());
        }

        return httpCookies;
        */
		return null;
	}

	public List<URI> getURIs() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean remove(URI uri, HttpCookie cookie) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeAll() {
		// TODO Auto-generated method stub
		return false;
	}
}