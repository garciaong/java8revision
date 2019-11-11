package design.pattern;

public class Singleton {

	public static void main(String [] args) {
		System.out.println(ObjSingleton.getInstance());
		System.out.println(ObjSingleton.getInstance());
	}
	
	private static class ObjSingleton {
		private static Obj instance = null;
		
		public static Obj getInstance(){
			//If empty initiate new instance
			if(instance==null) {
				//There might have concurrent access, block the other
				synchronized(ObjSingleton.class) {
					//To make sure the other concurrent request that pass the empty check not initialize again after the first initialization
					if(instance==null) {
						instance = new Obj();
					}
				}
			}
			return instance;
		}
	}
	
	private static class Obj{
		
	}
}
