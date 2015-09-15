package com.shma.state.vote;

/**
 * 恶意刷票
 * @author h p
 *
 */
public class SpiteVoteState implements IVoteState {

	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
		String tmpVoteItem = voteManager.getMapVote().get(user);
		if(tmpVoteItem != null) {
			voteManager.getMapVote().remove(user);
		}
		System.out.println("你有恶意刷屏行为，取消投票资格");
	}

}
