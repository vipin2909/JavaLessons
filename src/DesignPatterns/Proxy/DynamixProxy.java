package DesignPatterns.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.HashMap;

// A proxy which constructed at runtime time

interface Human {
	void walk();
	void talk();
}

class Person1 implements Human {

	@Override
	public void walk() {
		System.out.println("I'am Waliking");
	}

	@Override
	public void talk() {
		System.out.println("I'am talking");
	}
}

class LoggingHandler implements InvocationHandler {

	private final Object target;
	private Map<String, Integer> calls = new HashMap<>();
	
	public LoggingHandler(Object target) {
		this.target = target;
	}

	@Override 
	public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
		
		String name = method.getName();
		if(name.contains("toString")) {
			return calls.toString();
		}
		calls.merge(name, 1, Integer::sum);
		
		return method.invoke(target, args);
	}
}

public class DynamixProxy {
	@SuppressWarnings("unchecked")
	public static <T> T withLogging(T target, Class<T> itf) {
		return (T) Proxy.newProxyInstance(
			itf.getClassLoader(), 
			new Class<?>[] { itf },
			new LoggingHandler(target)
		);
	}
		
	public static void main(String[] args) {
		Person1 Person1 = new Person1();
		Human logged = withLogging(Person1, Human.class);
		logged.talk();
		logged.walk();
		logged.walk();
		System.out.println(logged);

	}
}
