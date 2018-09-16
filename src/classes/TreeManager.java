package classes;

public class TreeManager<T extends Comparable<T>> {
	private Node<T> root;
	
	public Node<T> getRoot() {
		return this.root;
	}
	
	public void setRoot(Node<T> root) {
		this.root = root;
	}
	
	/**
	 * This method calls the method in order tree traversal. This is set up like this
	 * so that the root can be passed in and used for the first iteration of the
	 * traversal.
	 */
	public void inOrderTraversal() {
		//Left root right
		System.out.println("\nInOrderTraversal:\n");
		inOrderTraversal(root);
	}
	
	/**
	 * This method actually does the work. It traverses the tree using recursion.
	 * @param node
	 * @return
	 */
	private Node<T> inOrderTraversal(Node<T> node) {
		if(node == null) {
			return null;
		}
		inOrderTraversal(node.getLeft());
		System.out.println(node.getData());
		inOrderTraversal(node.getRight());
		return node;
	}
	
	/**
	 * See inOrderTraversal() for more information on the setup
	 */
	public void postOrderTraversal() {
		//Left root right
		System.out.println("\nPostOrderTraversal:\n");
		postOrderTraversal(root);
	}
	
	private Node<T> postOrderTraversal(Node<T> node) {
		if(node == null) {
			return null;
		}
		postOrderTraversal(node.getLeft());
		postOrderTraversal(node.getRight());
		System.out.println(node.getData());
		return node;
	}
	
	/**
	 * See inOrderTraversal() for more information on the setup
	 */
	public void preOrderTraversal() {
		//Left root right
		System.out.println("\nPreOrderTraversal:\n");
		preOrderTraversal(root);
	}
	
	private Node<T> preOrderTraversal(Node<T> node) {
		if(node == null) {
			return null;
		}
		System.out.println(node.getData());
		preOrderTraversal(node.getLeft());
		preOrderTraversal(node.getRight());
		return node;
	}
	
	/**
	 * The two methods responsible for adding a node work by taking in a node
	 * as a parameter, and searching the tree for the correct location to 
	 * add the node in. Once that location is found, it adds the node. If the
	 * node already exists in the tree, it does not add the node.
	 * @param nodeToAdd
	 */
	public void addNode(Node<T> nodeToAdd) {
		this.root = addNode(nodeToAdd, this.root);
	}
	
	private Node<T> addNode(Node<T> nodeToAdd, Node<T> currentNode) {
		if(currentNode == null) {
			return nodeToAdd;
		}
		if(currentNode.compareTo(nodeToAdd.getData()) < 0) {
			currentNode.setRight(addNode(nodeToAdd, currentNode.getRight()));
			
		}else if(currentNode.compareTo(nodeToAdd.getData()) > 0) {
			currentNode.setLeft(addNode(nodeToAdd, currentNode.getLeft()));
		}
		
		return currentNode;
	}
	
	/**
	 * The two methods that handle the deleteNode process work together to 
	 * recursively search through the tree to find the node that needs to be
	 * deleted. Once that node is found, it is removed from the tree by changing
	 * the references in the tree.
	 * @param nodeToDelete
	 */
	public void deleteNode(Node<T> nodeToDelete) {
		this.root = deleteNode(nodeToDelete, this.root);
	}

	private Node<T> deleteNode(Node<T> nodeToDelete, Node<T> currentNode){
		Node<T> discoveredNode;
		
		if(currentNode == null) {
			return null;
		}
		if(currentNode.compareTo(nodeToDelete.getData()) > 0) {
			currentNode.setLeft(deleteNode(nodeToDelete, currentNode.getLeft()));
		}
		if(currentNode.compareTo(nodeToDelete.getData()) < 0) {
			currentNode.setRight(deleteNode(nodeToDelete, currentNode.getRight()));
		}else{
			if(currentNode.getRight() == null) {
				return currentNode.getLeft();
			}
			discoveredNode = currentNode;
			currentNode = getMinimum(discoveredNode.getRight());
			currentNode.setLeft(discoveredNode.getLeft());
		}
		return currentNode;
	}
	
	/**
	 * This method finds the smallest value in the tree and returns it. Its primary purpose
	 * for existence is to help with the deleteNode process.
	 * @param node
	 * @return
	 */
	public Node<T> getMinimum(Node<T> node){
		if(node.getLeft() == null) {
			return node;
		}
		return getMinimum(node.getLeft());
	}
}
