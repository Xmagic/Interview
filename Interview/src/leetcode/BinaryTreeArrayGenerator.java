package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 							  0
 * 	                        /   \
 * 						   /     \
 *                        1       2
 *                       / \     / \
 *                      3   4   5   6
 *                     / \ / \ / \ / \
 *                     7 8 9 a b c d e 
 */
public class BinaryTreeArrayGenerator {
	static int high = 2;
	static int a[] = new int[(1<<(high+1)) - 1]; // 2^(high+1) - 1
	
	public static void main(String[] args) {
		System.out.println("Tree high is: " + high);
		System.out.println("Tree total nodes:" + a.length);
		TreeNode root = new TreeNode(0);
		generateTree(root);
		System.out.println("Level Order:");
		printTreeInLevelOrder(root);
		System.out.println("Pre Order:");
		printTreeInPreOrder(root);
		
		System.out.println("\nIn Order:");
		printTreeInMidOrder(root);
		
		System.out.println("\nPost Order:");
		printTreePostOrder(root);
	}
	
	
	static List<List<Integer>> result = new ArrayList<List<Integer>>();
	
	public static void printTreeInPreOrder(TreeNode node) {
		System.out.print(node.getValue() + " ");
		if(node.getLeft() != null) printTreeInPreOrder(node.getLeft());
		if(node.getRight() != null) printTreeInPreOrder(node.getRight());
	}
	
	public static void printTreeInMidOrder(TreeNode node) {
		if(node.getLeft() != null) printTreeInMidOrder(node.getLeft());
		System.out.print(node.getValue() + " ");
		if(node.getRight() != null) printTreeInMidOrder(node.getRight());
	}
	
	public static void printTreePostOrder(TreeNode node) {
		if(node.getLeft() != null) printTreePostOrder(node.getLeft());
		if(node.getRight() != null) printTreePostOrder(node.getRight());
		System.out.print(node.getValue() + " ");
	}
	
	public static void printTreeInLevelOrder(TreeNode node) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(node);
		while (!queue.isEmpty()) {
			int queueSize = queue.size();
			List<Integer> list = new ArrayList<Integer>();

			for (int i = 0; i < queueSize; i++) {
				TreeNode n = queue.poll();
				list.add(n.getValue());
				if (n.getLeft() != null)
					queue.offer(n.getLeft());
				if (n.getRight() != null)
					queue.offer(n.getRight());
			}
			result.add(list);
		}

		for (List<Integer> l : result) {
			System.out.println(l);
		}
	}

	public static void generateTree(TreeNode node) {
		int v = node.getValue();
		if (2*v + 1 >= a.length)
			return;
		node.setLeft(new TreeNode(2*v + 1));
		node.setRight(new TreeNode(2*v + 2));
		
		generateTree(node.getLeft());
		generateTree(node.getRight());
	}
}


class TreeNode {
	private int value;
	
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(int v) {
		this.value = v;
	}
	
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}