import java.util.LinkedList;
import java.util.List;


public class MyStructure implements IMyStructure{

	private List<INode> nodes = new LinkedList<>();
	private int count;
	private INode firstFound;

	public INode findByCode(String code) {
		firstFound = null;

		return searchRecursive(code, "code", nodes);
	}

	public INode findByRenderer(String renderer) {
		firstFound = null;

		return searchRecursive(renderer, "renderer", nodes);
	}

	private INode searchRecursive(String s, String type, List<INode> nodes){
		for(INode iNode : nodes){
			if (iNode instanceof ICompositeNode) {
				searchRecursive(s, type, ((ICompositeNode) iNode).getNodes());
			}
			if(firstFound == null) {
				if (type.equals("code") && iNode != null && iNode.getCode().equals(s)) {
					firstFound = iNode;
				} else if (type.equals("renderer") && iNode != null && iNode.getRenderer().equals(s)) {
					firstFound = iNode;
				}
			}
		}
		if(firstFound!=null)
			return firstFound;
		else
			return null;
	}


	public int count() {
		count = 0;

		return countRecursive(nodes);
	}

	private int countRecursive(List<INode> nodes){
		for(INode iNode : nodes){
			if(iNode instanceof ICompositeNode){
				countRecursive(((ICompositeNode) iNode).getNodes());
			}
			count++;
		}

		return count;
	}


	public void add(INode node) {
		if(node!=null) {
			nodes.add(node);
		}
	}

	public void add(ICompositeNode target, INode node) {
		if(node!=null && target!=null) {
			target.getNodes().add(node);
		}
	}

}

interface IMyStructure {
	INode findByCode(String code);
	INode findByRenderer(String renderer);
	int count();
}

interface ICompositeNode extends INode {
	List<INode> getNodes();
}

interface INode {
	String getCode();
	String getRenderer();
}