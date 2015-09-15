package com.shma.state.vote;

public class TestMainApp {

	public static void main(String[] args) {
		
		VoteManager vm = new VoteManager();
		
		for(int i=0; i<10; ++i) {
			vm.vote("shma1664", "vm");
			vm.print();
		}
	}

}
