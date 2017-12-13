package com.achatCollectif.test;

public class Collections_dao_Test {

	protected static String host ;
	protected static int port ;
	protected static String dataBaseName ;
	
	public Collections_dao_Test(){
		System.out.println("**************Initializing parameters**************");
		this.host = "localhost";
		this.port = 27017;
		this.dataBaseName = "AchatCollectif";
	}
}
