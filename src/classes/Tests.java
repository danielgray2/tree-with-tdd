package classes;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.*;

/**
 * This is my test class. It is used to make sure that the tree is functioning
 * properly.
 * @author grayd
 *
 */
class Tests {
	
	TreeManager<Coffee> treeOne = new TreeManager<Coffee>();
	
	Coffee coffeeOne = new Coffee(5.00, "light", "Starbucks");
	Coffee coffeeTwo = new Coffee(4.00, "light", "Starbucks");
	Coffee coffeeThree = new Coffee(5.00, "dark", "Starbucks");
	Coffee coffeeFour = new Coffee(5.00, "light", "City Brew");
	Coffee coffeeFive = new Coffee(5.00, "light", "Starbucks");
	Coffee coffeeSix = new Coffee(6.00, "light", "Starbucks");
	Coffee coffeeSeven = new Coffee(5.5, "light", "Starbucks");
	Coffee coffeeEight = new Coffee(3.00, "light", "Starbucks");
	Coffee coffeeNine = new Coffee(7.00, "light", "Starbucks");
	
	Node<Coffee> nodeOne = new Node<Coffee>(coffeeOne);
	Node<Coffee> nodeTwo = new Node<Coffee>(coffeeTwo);
	Node<Coffee> nodeThree = new Node<Coffee>(coffeeThree);
	Node<Coffee> nodeFour = new Node<Coffee>(coffeeFour);
	Node<Coffee> nodeFive = new Node<Coffee>(coffeeFive);
	Node<Coffee> nodeSix = new Node<Coffee>(coffeeSix);
	Node<Coffee> nodeSeven = new Node<Coffee>(coffeeSeven);
	Node<Coffee> nodeEight = new Node<Coffee>(coffeeEight);
	Node<Coffee> nodeNine = new Node<Coffee>(coffeeNine);
	
	@Test
	void test_coffee_compare_to() {
		//Test for price
		int compareTo = coffeeOne.compareTo(coffeeTwo);
		Assert.assertEquals(1, compareTo);
		//Test for color
		compareTo = coffeeOne.compareTo(coffeeThree);
		Assert.assertEquals(1, compareTo);
		//Test for company
		compareTo = coffeeOne.compareTo(coffeeFour);
		Assert.assertEquals(1, compareTo);
		//Test for equality
		compareTo = coffeeOne.compareTo(coffeeFive);
		Assert.assertEquals(0, compareTo);
		
		//Reverse
		compareTo = coffeeTwo.compareTo(coffeeOne);
		Assert.assertEquals(-1, compareTo);
		//Test for color
		compareTo = coffeeThree.compareTo(coffeeOne);
		Assert.assertEquals(-1, compareTo);
		//Test for company
		compareTo = coffeeFour.compareTo(coffeeOne);
		Assert.assertEquals(-1, compareTo);
		//Test for equality
		compareTo = coffeeFive.compareTo(coffeeOne);
		Assert.assertEquals(0, compareTo);
	}
	
	@Test
	void test_node_compare_to() {
		//Test for price
		int compareTo = nodeOne.compareTo(nodeTwo.getData());
		Assert.assertEquals(1, compareTo);
		//Test for color
		compareTo = nodeOne.compareTo(nodeThree.getData());
		Assert.assertEquals(1, compareTo);
		//Test for company
		compareTo = nodeOne.compareTo(nodeFour.getData());
		Assert.assertEquals(1, compareTo);
		//Test for equality
		compareTo = nodeOne.compareTo(nodeFive.getData());
		Assert.assertEquals(0, compareTo);
	}

	@Test
	void test_add_node() {
		
		treeOne.addNode(nodeOne);
		Assert.assertEquals(treeOne.getRoot(), nodeOne);
		
		treeOne.addNode(nodeTwo);
		Assert.assertEquals(treeOne.getRoot().getLeft(), nodeTwo);
		
		treeOne.addNode(nodeSix);
		Assert.assertEquals(treeOne.getRoot().getRight(), nodeSix);
		
		treeOne.addNode(nodeThree);
		Assert.assertEquals(treeOne.getRoot().getLeft().getRight(), nodeThree);
		
		treeOne.addNode(nodeSeven);
		Assert.assertEquals(treeOne.getRoot().getRight().getLeft(), nodeSeven);
		
		treeOne.addNode(nodeEight);
		Assert.assertEquals(treeOne.getRoot().getLeft().getLeft(), nodeEight);
		
		treeOne.addNode(nodeNine);
		Assert.assertEquals(treeOne.getRoot().getRight().getRight(), nodeNine);
	}
	
	//Console should have this format
	/*	Starbucks light roast for 3.0
		Starbucks light roast for 4.0
		Starbucks dark roast for 5.0
		Starbucks light roast for 5.0
		Starbucks light roast for 5.5
		Starbucks light roast for 6.0
		Starbucks light roast for 7.0
	*/
	@Test
	void test_in_order_traversal() {
		treeOne.addNode(nodeOne);
		treeOne.addNode(nodeTwo);
		treeOne.addNode(nodeSix);
		treeOne.addNode(nodeThree);
		treeOne.addNode(nodeSeven);
		treeOne.addNode(nodeEight);
		treeOne.addNode(nodeNine);
		
		treeOne.inOrderTraversal();
	}
	
	//Console should have this format
	/*	Starbucks light roast for 5.0
		Starbucks light roast for 4.0
		Starbucks light roast for 3.0
		Starbucks dark roast for 5.0
		Starbucks light roast for 6.0
		Starbucks light roast for 5.5
		Starbucks light roast for 7.0
	*/
	@Test
	void test_pre_order_traversal() {
		treeOne.addNode(nodeOne);
		treeOne.addNode(nodeTwo);
		treeOne.addNode(nodeSix);
		treeOne.addNode(nodeThree);
		treeOne.addNode(nodeSeven);
		treeOne.addNode(nodeEight);
		treeOne.addNode(nodeNine);
		
		treeOne.preOrderTraversal();
		
	}
	
	@Test
	/*
	 	Starbucks light roast for 3.0
		Starbucks dark roast for 5.0
		Starbucks light roast for 4.0
		Starbucks light roast for 5.5
		Starbucks light roast for 7.0
		Starbucks light roast for 6.0
		Starbucks light roast for 5.0
	*/
	void test_post_order_traversal() {
		treeOne.addNode(nodeOne);
		treeOne.addNode(nodeTwo);
		treeOne.addNode(nodeSix);
		treeOne.addNode(nodeThree);
		treeOne.addNode(nodeSeven);
		treeOne.addNode(nodeEight);
		treeOne.addNode(nodeNine);
		
		treeOne.postOrderTraversal();
	}
	
	@Test
	void test_get_minimum() {
		treeOne.addNode(nodeOne);
		treeOne.addNode(nodeTwo);
		treeOne.addNode(nodeSix);
		treeOne.addNode(nodeThree);
		treeOne.addNode(nodeSeven);
		treeOne.addNode(nodeEight);
		treeOne.addNode(nodeNine);
		
		Node<Coffee> minimum = treeOne.getMinimum(treeOne.getRoot());
		Assert.assertEquals(minimum, nodeEight);
	}
	
	@Test
	void test_delete() {
		treeOne.addNode(nodeOne);
		treeOne.addNode(nodeTwo);
		treeOne.addNode(nodeSix);
		treeOne.addNode(nodeThree);
		treeOne.addNode(nodeSeven);
		treeOne.addNode(nodeEight);
		treeOne.addNode(nodeNine);
		
		treeOne.deleteNode(nodeSix);
		Assert.assertNotEquals(nodeSix, treeOne.getRoot().getRight());
	}
	
	@Test
	void test_delete_empty_tree() {
		treeOne.deleteNode(nodeSix);
	}
	
	@Test
	void test_delete_node_not_in_tree() {
		treeOne.addNode(nodeOne);
		treeOne.deleteNode(nodeSix);
		Assert.assertEquals(nodeOne, treeOne.getRoot());
	}
}
