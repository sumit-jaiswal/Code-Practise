package com.sumit.ds;

public class BinaryTree {
	TreeNode<Integer> root;

	public void insert(TreeNode<Integer> node, int value) {
		if (value < node.value) {
			if (node.leftChild != null) {
				insert(node.leftChild, value);
			} else {
				node.leftChild = new TreeNode<Integer>(value);
			}
		} else if (value > node.value) {
			if (node.rightChild != null) {
				insert(node.rightChild, value);
			} else {
				node.rightChild = new TreeNode<Integer>(value);
			}
		}
		
	}
	
	public void inOrder(TreeNode<Integer> node){
		if(node != null){
			inOrder(node.leftChild);
			System.out.println(" Traversed "+node.value);
			inOrder(node.rightChild);
		}
	}
	
	public void preOrder(TreeNode<Integer> node){
		if(node != null){
			
			inOrder(node.leftChild);
			
			inOrder(node.rightChild);
		}
	}
}

class TreeNode<V> {
	V value;
	TreeNode<V> leftChild;
	TreeNode<V> rightChild;

	public TreeNode(V value) {
		super();
		this.value = value;
	}

}