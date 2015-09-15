package com.shma.state.vote;

/**
 * 重复投票
 * @author h p
 *
 */
public class RepeatVoteState implements IVoteState {

	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
		System.out.println("请不要重复投票");
	}

}
