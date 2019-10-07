public class Node implements INode{
	private String code;
	private String renderer;
	
	Node(String code, String renderer){
		this.code = code;
		this.renderer = renderer;
	}

	public String getCode() {
		return code;
	}

	public String getRenderer() {
		return renderer;
	}

}
