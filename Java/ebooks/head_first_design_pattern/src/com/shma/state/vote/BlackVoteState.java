package com.shma.state.vote;

/**
 * ������
 * @author h p
 *
 */
public class BlackVoteState implements IVoteState {

	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
		System.out.println("���������������ֹ��¼��ʹ�ñ�ϵͳ");
	}

}
