package com.examples.wsdl.helloservice;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import org.junit.Test;

public class HelloServiceIT {

	@Test
	public void test() {

		QName HELLOWORLD_QNAME = new QName("http://www.examples.com/wsdl/HelloService.wsdl", "Hello_Service");
		HelloService hs = new HelloService(null, HELLOWORLD_QNAME);
		HelloPortType helloService = hs.getHelloPort();

		BindingProvider bindingProvider = (BindingProvider) helloService;
		bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				"http://localhost:8088/hello");

		String greeting = helloService.sayHello("Daniel");
		assertThat(greeting, is("Hello Daniel!"));
	}

}
