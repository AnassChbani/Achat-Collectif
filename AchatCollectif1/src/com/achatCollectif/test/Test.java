package com.achatCollectif.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("/test")
public class Test {
	@GET 
	@Path("/hello")
	public String hello(){
		System.out.println("Hello Anass");
		return "Hello Anass";
	}
}
