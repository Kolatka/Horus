
public class MyApp {

	public static void main(String[] args) {
		MyStructure ms = new MyStructure();
		INode node = new Node("1","r1");
		INode node2 = new Node("2","r2");
		ms.add(node);
		ms.add(node2);
		System.out.println(ms.count());
		System.out.println(ms.findByCode("1"));
		
	}
	
	
}
