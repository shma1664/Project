package com.shma.state.vote;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class VoteManager {

	private Map<String, String> mapVote = new HashMap<String, String>();
	
	private Map<String, Integer> mapVoteCount = new HashMap<String, Integer>();
	
	public void vote(String user, String voteItem) {
		
		IVoteState voteState = null;
		
		Integer voteCount = mapVoteCount.get(user);
		
		if(voteCount == null) {
			voteCount = 0;
		}
		
		voteCount++;
		
		mapVoteCount.put(user, voteCount);
		
		if (voteCount == 1) {
			voteState = new NormalVoteState();
		} else if(voteCount > 1 && voteCount <= 5) {
			voteState = new RepeatVoteState();
		} else if(voteCount > 5 && voteCount <= 8) {
			voteState = new SpiteVoteState();
		} else {
			voteState = new BlackVoteState();
		}
		
		voteState.vote(user, voteItem, this);
	} 

	public Map<String, String> getMapVote() {
		return mapVote;
	}
	
	public void print() {
		
		for(Iterator<Entry<String, String>> iterator = mapVote.entrySet().iterator(); iterator.hasNext();) {
			Entry<String, String> data = iterator.next();
			System.out.println(data.getKey() + ":" + data.getValue());
		}
		
		for(Iterator<Entry<String, Integer>> iterator = mapVoteCount.entrySet().iterator(); iterator.hasNext();) {
			Entry<String, Integer> data = iterator.next();
			System.out.println(data.getKey() + ":" + data.getValue());
		}
	}
}
