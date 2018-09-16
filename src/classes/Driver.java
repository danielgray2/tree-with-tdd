package classes;

public class Driver {
	
	public static void main(String[] args) {
		TreeManager<Coffee> treeOne = new TreeManager<Coffee>();
		
		Coffee coffeeOne = new Coffee(5.00, "light", "Starbucks");
		Coffee coffeeTwo = new Coffee(4.00, "light", "Starbucks");
		Coffee coffeeThree = new Coffee(5.00, "dark", "Starbucks");
//		Coffee coffeeFour = new Coffee(5.00, "light", "City Brew");
//		Coffee coffeeFive = new Coffee(5.00, "light", "Starbucks");
		Coffee coffeeSix = new Coffee(6.00, "light", "Starbucks");
		Coffee coffeeSeven = new Coffee(5.5, "light", "Starbucks");
		Coffee coffeeEight = new Coffee(3.00, "light", "Starbucks");
		Coffee coffeeNine = new Coffee(7.00, "light", "Starbucks");
		
		Node<Coffee> nodeOne = new Node<Coffee>(coffeeOne);
		Node<Coffee> nodeTwo = new Node<Coffee>(coffeeTwo);
		Node<Coffee> nodeThree = new Node<Coffee>(coffeeThree);
//		Node<Coffee> nodeFour = new Node<Coffee>(coffeeFour);
//		Node<Coffee> nodeFive = new Node<Coffee>(coffeeFive);
		Node<Coffee> nodeSix = new Node<Coffee>(coffeeSix);
		Node<Coffee> nodeSeven = new Node<Coffee>(coffeeSeven);
		Node<Coffee> nodeEight = new Node<Coffee>(coffeeEight);
		Node<Coffee> nodeNine = new Node<Coffee>(coffeeNine);
		
		treeOne.addNode(nodeOne);
		treeOne.addNode(nodeTwo);
		treeOne.addNode(nodeSix);
		treeOne.addNode(nodeThree);
		treeOne.addNode(nodeSeven);
		treeOne.addNode(nodeEight);
		treeOne.addNode(nodeNine);
		
		treeOne.inOrderTraversal();
		treeOne.preOrderTraversal();
		treeOne.postOrderTraversal();
		
		deleteNode(treeOne, 6.00, "light", "Starbucks");
		
		/*
		 * The delete node method called above should delete nodeSix out of the tree.
		 * This inOrderTraversal should not output nodeSix (There should not be a node
		 * that has a price of 6.0).
		 * */
		System.out.println("\nPrint out to verify that nodeSix has been deleted");
		treeOne.inOrderTraversal();
	}
	
	/*
	 * This method was implemented to call the deleteNode method in the TreeManager class. I did it
	 * this way to comply with the requirement of allowing the user to delete nodes by inputing a price,
	 * color, and company. By calling the deleteNode method here, I was also able to reuse the generic compareTo
	 * method in the Node class.
	 * */
	public static void deleteNode(TreeManager<Coffee> tree, Double price, String color, String company) {
		Coffee coffee = new Coffee(price, color, company);
		Node<Coffee> nodeToDelete = new Node<Coffee>(coffee);
		tree.deleteNode(nodeToDelete);
	}
}
