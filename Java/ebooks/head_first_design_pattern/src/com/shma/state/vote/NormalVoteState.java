package com.shma.state.vote;

/**
 * ����ͶƱ
 * @author h p
 *
 */
public class NormalVoteState implements IVoteState {

	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
		voteManager.getMapVote().put(user, voteItem);
		System.out.println("��ϲͶƱ�ɹ�");
	}

}
