import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.Matchers.*;

public class MainTest {
	
	private static INode node1 = new Node("1","r1");
	private static INode node2 = new Node("2","r2");
	private static INode node3 = new Node("3","r3");
	private static INode node4 = new Node("4","r4");
	private static INode node5 = new Node("5","r5");
	private static CompositeNode compositeNode1 = new CompositeNode("cn1", "compositeRenderer1");
	private static CompositeNode compositeNode2 = new CompositeNode("cn2", "compositeRenderer2");
	private static CompositeNode compositeNode3 = new CompositeNode("cn3", "compositeRenderer3");
	private static CompositeNode compositeNode4 = new CompositeNode("cn4", "compositeRenderer4");
	private static CompositeNode compositeNode5 = new CompositeNode("cn5", "compositeRenderer5");
	
	private static MyStructure myStructure;
	
	@BeforeEach
	void prepareStructure() {
		compositeNode1.add(node1);
		compositeNode1.add(node2);
		compositeNode1.add(compositeNode2);
		compositeNode2.add(node3);
		compositeNode2.add(compositeNode3);
		compositeNode3.add(node4);
		compositeNode3.add(node5);

		myStructure = new MyStructure();
		myStructure.add(compositeNode1);
	}

	@Test
	void shouldReturnNode() {
		assertThat(myStructure.findByCode("1"), is(node1));
	}


}