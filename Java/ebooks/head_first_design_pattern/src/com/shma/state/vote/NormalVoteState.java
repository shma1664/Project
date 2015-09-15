package com.shma.state.vote;

/**
 * 正常投票
 * @author h p
 *
 */
public class NormalVoteState implements IVoteState {

	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
		voteManager.getMapVote().put(user, voteItem);
		System.out.println("恭喜投票成功");
	}

}
