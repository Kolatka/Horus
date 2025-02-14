import java.util.LinkedList;
import java.util.List;


public class MyStructure implements IMyStructure{
	private final List<INode> nodes = new LinkedList<>();
	private int count;
	private INode firstFound;

	public enum Type {
		COUNT, RENDERER, CODE
	}

	@Override
	public INode findByCode(String code) {
		firstFound = null;
		return recursiveLookup(code, Type.CODE, nodes);
	}
	@Override
	public INode findByRenderer(String renderer) {
		firstFound = null;
		return recursiveLookup(renderer, Type.RENDERER, nodes);
	}
	@Override
	public int count() {
		count = 0;
		recursiveLookup(null,Type.COUNT, nodes);
		return count;
	}

	private INode recursiveLookup(String s, Type type, List<INode> nodes){
		for(INode iNode : nodes){
			if (iNode instanceof ICompositeNode) {
				recursiveLookup(s, type, ((ICompositeNode) iNode).getNodes());
			}
			if(firstFound == null && iNode != null) {
				switch(type){
					case COUNT:
						count++;
					case CODE:
						if (iNode.getCode().equals(s))
							firstFound = iNode;
					case RENDERER:
						if (iNode.getRenderer().equals(s))
							firstFound = iNode;
				}
			}
		}
		if(firstFound != null)
			return firstFound;
		else return null;
	}

	public void add(INode node) {
		if(node != null) {
			nodes.add(node);
		}
	}

	public void add(ICompositeNode target, INode node) {
		if(node != null && target != null) {
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