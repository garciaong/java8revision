package simply.test;

public class MyImpl implements MyInterface{

	@Override
	public void method1() {
		// TODO Auto-generated method stub
	}
	
	protected void method2() {
		//default modifier will caused subclass MyImplExtension not able to access this method
	}
	
	

}
