import java.util.LinkedList;
import java.util.List;

public class MyStructure implements IMyStructure {

	private List<INode> nodes = new LinkedList<INode>();

	public INode findByCode(String code) {
		if(code == null) {
			return null;
		}else {
			return nodes.stream().flatMap(INode::toStream).filter(x -> code.equals(x.getCode())).findFirst().orElse(null);
		}
	}

	public INode findByRenderer(String renderer) {
		if(renderer == null) {
			return null;
		}else {
			return nodes.stream().flatMap(INode::toStream).filter(x -> renderer.equals(x.getRenderer())).findFirst().orElse(null);
		}
	}

	public int count() {
		return (int) nodes.stream().flatMap(INode::toStream).count();
	}


	public void add(INode node) {
		if(node!=null) {
			nodes.add(node);
		}
	}
	
	
}