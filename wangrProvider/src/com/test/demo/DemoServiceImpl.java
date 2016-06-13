package com.test.demo;

public class DemoServiceImpl implements DemoService {

	@Override
	public String SayHello(String S) {
		System.out.println(S);
		return S;
	}

}
