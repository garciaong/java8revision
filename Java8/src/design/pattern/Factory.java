package design.pattern;

public class Factory {

	public static void main(String [] args) {
		OS os = OSFactory.getInstance(OSEnum.IOS);
		os.osName();
		os = OSFactory.getInstance(OSEnum.LINUX);
		os.osName();
	}
	
	private static class OSFactory{
		public static OS getInstance(OSEnum osType) {
			switch(osType) {
			case ANDRIOD:
				return new Android();
			case IOS:
				return new IOS();
			case MAC:
				return new MAC();
			case WINDOWS:
				return new Windows();
			case LINUX:
				return new Linux();
			default:
				return null;
			}
		}
	}
	
	interface OS {
		public void osName();
	}
	
	static class Android implements OS{
		@Override
		public void osName() {
			System.out.println("This is Android");
		}	
	}
	
	static class IOS implements OS{
		@Override
		public void osName() {
			System.out.println("This is IOS");
		}	
	}
	
	static class MAC implements OS{
		@Override
		public void osName() {
			System.out.println("This is MAC");
		}	
	}
	
	static class Windows implements OS{
		@Override
		public void osName() {
			System.out.println("This is Windows");
		}	
	}
	
	static class Linux implements OS{
		@Override
		public void osName() {
			System.out.println("This is Linux");
		}	
	}
}
