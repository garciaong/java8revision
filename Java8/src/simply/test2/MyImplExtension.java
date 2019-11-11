package simply.test2;

import simply.test.MyImpl;

public class MyImplExtension extends MyImpl{

	protected void method3() {
		method1();
		method2();
	}
	
}
