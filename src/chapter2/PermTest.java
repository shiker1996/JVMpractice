package chapter2;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class PermTest {
	static class OOMObject {
	}

	public static void main(String[] args) {
		while (true) {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(OOMObject.class);
			enhancer.setUseCache(false);
			enhancer.setCallback(new MethodInterceptor() {
				@Override
				public Object intercept(Object obj, Method method,
						Object[] args, MethodProxy proxy) throws Throwable {
					// TODO Auto-generated method stub
					return proxy.invokeSuper(obj, args);
				}
			});
			enhancer.create();
		}
	}
}
