package InnerClass;

public class SuperAPI {

	public void show() {
		System.out.println(this.getClass().toString());
	}
	
	
	public static SuperAPIInnerPri getInerPriClass()
	{
		SuperAPIInnerPri obj = new SuperAPI().new SuperAPIInnerPri();
		return obj;
	}

	public class SuperAPIInnerPub {
		public void inerPubShow() {
			System.out.println(this.getClass().toString());
		}
	}

	private class SuperAPIInnerPri {
		public void inerPriShow() {
			System.out.println(this.getClass().toString());
		}
	}

	protected class SuperAPIInnerPro {
		public void inerProShow() {
			System.out.println(this.getClass().toString());

		}
	}
}

class SuperApiSub {

	public void show() {
		System.out.println(this.getClass().toString());
	}

}
