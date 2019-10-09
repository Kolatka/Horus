import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class CompositeNode extends Node implements ICompositeNode{

	private List<INode> nodes = new LinkedList<INode>();

	CompositeNode(String code, String renderer) {
		super(code, renderer);
	}

	public List<INode> getNodes() {
		return nodes;
	}

	public void add(INode node) {
		if(node!=null) nodes.add(node);
	}

	public void remove(INode node) {
		if(node!=null && nodes.contains(node)) {
			nodes.remove(node);
		}
	}

	public Stream<INode> toStream() {
		return Stream.concat(super.toStream(), nodes.stream().flatMap(INode::toStream));
	}
}
