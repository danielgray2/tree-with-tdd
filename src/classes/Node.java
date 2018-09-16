package classes;

public class Node<T extends Comparable<T>> implements Comparable<T>{
	private T t;
	private Node<T> left;
	private Node<T> right;
	
	public Node(T t) {
		this.t = t;
	}
	
	public void setLeft(Node<T> left) {
		this.left = left;
	}
	
	public Node<T> getLeft() {
		return this.left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}
	
	public T getData() {
		return this.t;
	}
	
	@Override
	public int compareTo(T otherData) {
		return this.getData().compareTo(otherData);
	}
}
