package com.shma.state.vote;

/**
 * �ظ�ͶƱ
 * @author h p
 *
 */
public class RepeatVoteState implements IVoteState {

	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
		System.out.println("�벻Ҫ�ظ�ͶƱ");
	}

}
