package com.shma.state.vote;

/**
 * 黑名单
 * @author h p
 *
 */
public class BlackVoteState implements IVoteState {

	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
		System.out.println("进入黑名单，将禁止登录和使用本系统");
	}

}
