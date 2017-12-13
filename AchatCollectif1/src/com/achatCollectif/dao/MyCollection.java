package com.achatCollectif.dao;

public class MyCollection {
	
	MyDB myDB ;
	String host;
	int port;
	String dataBaseName;
	
	public MyCollection(String host, int port, String dataBaseName){
		this.host = host;
		this.port = port;
		this.dataBaseName = dataBaseName;
		myDB = new MyDBImp(host, port, dataBaseName);
	}
	
	public MyCollection(String host, int port){
		myDB = new MyDBImp(host, port);
	}
	
	public MyCollection() {
		super();
	}

	public MyCollection(MyDB myDB) {
		super();
		this.myDB = myDB;
	}

	public MyDB getMyDB() {
		return myDB;
	}
	
	public void setMyDB(MyDB myDB) {
		this.myDB = myDB;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getDataBaseName() {
		return dataBaseName;
	}

	public void setDataBaseName(String dataBaseName) {
		this.dataBaseName = dataBaseName;
	}
	
	
}
