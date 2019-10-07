import java.util.LinkedList;
import java.util.List;

public class MyStructure implements IMyStructure {
	private List<INode> nodes = new LinkedList<INode>();

	public INode findByCode(String code) {
		if(code == null) {
			return null;
		}else {
			for(INode node : nodes) {
				if(node.getCode().equals(code)) {
					return node;
				}
			}
			return null;
		}
	}

	public INode findByRenderer(String renderer) {
		if(renderer == null) {
			return null;
		}else {
			for(INode node : nodes) {
				if(node.getRenderer().equals(renderer)) {
					return node;
				}
			}
			return null;
		}
	}

	public int count() {
		int count = 0;
		for(INode node : nodes) {
			count++;
		}
		return count;
	}
	
	public void add(INode node) {
		if(node!=null) {
			nodes.add(node);
		}
	}
	
	
}