package com.shma.state.vote;

public interface IVoteState {

	/**
     * ����״̬��Ӧ����Ϊ
     * @param user    ͶƱ��
     * @param voteItem    ͶƱ��
     * @param voteManager    ͶƱ�����ģ�������ʵ��״̬��Ӧ�Ĺ��ܴ����ʱ�򣬿��Իص������ĵ�����
     */
    public void vote(String user, String voteItem, VoteManager voteManager);
}
