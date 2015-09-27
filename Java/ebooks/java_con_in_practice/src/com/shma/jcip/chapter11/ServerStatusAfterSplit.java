package com.shma.jcip.chapter11;

import java.util.HashSet;
import java.util.Set;

/**
 * Ëø·Ö½â
 * @author admin
 *
 */
public class ServerStatusAfterSplit {

	private final Set<String> users;
	private final Set<String> queries;
	
	public ServerStatusAfterSplit() {
        users = new HashSet<String>();
        queries = new HashSet<String>();
    }

    public void addUser(String u) {
        synchronized (users) {
            users.add(u);
        }
    }

    public void addQuery(String q) {
        synchronized (queries) {
            queries.add(q);
        }
    }

    public void removeUser(String u) {
        synchronized (users) {
            users.remove(u);
        }
    }

    public void removeQuery(String q) {
        synchronized (users) {
            queries.remove(q);
        }
    }
}
