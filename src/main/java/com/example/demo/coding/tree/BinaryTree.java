package com.example.demo.coding.tree;

import java.util.Random;

/**
 * @author Rahil_Khan https://www.baeldung.com/java-binary-tree
 *
 */
public class BinaryTree {

	Node root;
	int globalVal = 0;

	/**
	 * public method to add data to node. Always start from root node.
	 * 
	 * @param value
	 */
	public void add(int value) {
		root = addRec(root, value);
	}

	/**
	 * Recursively traverse tree and add node
	 * 
	 * @param current
	 * @param value
	 * @return
	 */
	private Node addRec(Node current, int value) {
		if (current == null)
			return new Node(value);

		if (value < current.data)
			current.left = addRec(current.left, value);
		else if (value > current.data)
			current.right = addRec(current.right, value);
		else
			return current;

		return current;
	}

	private BinaryTree createBinaryTree(BinaryTree bt) {
		bt.add(6);
		bt.add(4);
		bt.add(8);
		bt.add(3);
		bt.add(5);
		bt.add(7);
		bt.add(9);
		return bt;
	}

	private BinaryTree createBinaryTreeRandomNum(BinaryTree bt) {
		Random random = new Random();
		for (int i = 0; i <= 15; i++) {
			int rndm = random.nextInt(27);
			System.out.println("Generated random no : " + rndm);
			bt.add(rndm);
			if (i == 7)
				globalVal = rndm;
		}
		return bt;
	}

	public Boolean containsNode(int value) {
		return containsNodeRec(root, value);
	}

	private Boolean containsNodeRec(Node current, int value) {
		if (current == null)
			return false;

		if (value == current.data)
			return true;

		return value < current.data ? containsNodeRec(current.left, value) : containsNodeRec(current.right, value);

	}

	public Node delete(int value) {
		return deleteNodeRec(root, value);
	}

	private Node deleteNodeRec(Node current, int value) {
		if (current == null)
			return null;

		if (value < current.data) {
			current.left = deleteNodeRec(current.left, value);
			return current;
		}
		current.right = deleteNodeRec(current.right, value);

		if (value == current.data) {
			System.out.println("Deleting node : " + current.data);
			current = deleteNode(current, value);
		}

		return current;

	}

	private Node deleteNode(Node current, int value) {
		/* 1. Delete leaf node */
		if (current.left == null && current.right == null)
			return null;

		/* 2. Delete node with exactly one child */
		if (current.left == null)
			return current.right;
		if (current.right == null)
			return current.left;

		/* 3. Delete node where the node has two children */
		int smallestValue = findSmallestValue(current.right);
		current.data = smallestValue;
		current.right = deleteNodeRec(current.right, smallestValue);

		return current;

	}

	/**
	 * Find smallest node on right side of binary tree
	 * 
	 * @param root
	 * @return
	 */
	private int findSmallestValue(Node root) {
		return root.left == null ? root.data : findSmallestValue(root.left);
	}

	/**
	 * Traverse node : Depth-First Search
	 * 
	 * @param node
	 */
	public void traverseInOrder(Node node) {
		if (node != null) {
			traverseInOrder(node.left);
			System.out.print(" " + node.data);
			traverseInOrder(node.right);
		}
	}

	public int treeDepth(Node node) {
		if (node == null)
			return 0;
		else {
			int ldepth = treeDepth(node.left);
			int rdepth = treeDepth(node.right);

			if (ldepth > rdepth)
				return ldepth + 1;
			else
				return rdepth + 1;
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.createBinaryTree(bt);
		bt.traverseInOrder(bt.root);
		int nd = 3;
		Node deletedNd = bt.delete(nd);
		System.out.println("\n");
		System.out.println("Value 10 : " + bt.containsNode(10));
		System.out.println("Value 5 : " + bt.containsNode(5));

		System.out.println("\n");
		System.out.println("Deleting node " + nd + "  : " + deletedNd.data + " : " + deletedNd.left.data + " : "
				+ deletedNd.right.data);
		System.out.println("Value " + nd + "    : " + bt.containsNode(nd));
		bt.traverseInOrder(bt.root);

		System.out.println("\n");
		bt.createBinaryTree(bt);
		nd = 6;
		deletedNd = bt.delete(nd);
		System.out.println("\n");
		System.out.println("Deleting node " + nd + " : " + deletedNd.data + " : " + deletedNd.left.data + " : "
				+ deletedNd.right.data);
		bt.traverseInOrder(bt.root);

		System.out.println("\n---------------------------------");
		bt = new BinaryTree();
		bt.createBinaryTreeRandomNum(bt);
		System.out.println("Tree depth : " + bt.treeDepth(bt.root));
		bt.traverseInOrder(bt.root);
		nd = bt.globalVal;
		deletedNd = bt.delete(nd);
		System.out.println("\n");
		System.out.println("Deleting node " + nd + " : " + deletedNd.data + " : " + deletedNd.left.data + " : "
				+ deletedNd.right.data);
		bt.traverseInOrder(bt.root);
		
		System.out.println("Tree depth : " + bt.treeDepth(bt.root));
	}

}
