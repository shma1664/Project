package com.shma.state.vote;

/**
 * ����ˢƱ
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
		System.out.println("���ж���ˢ����Ϊ��ȡ��ͶƱ�ʸ�");
	}

}
