package com.binarytree;

public class ExpressionEvaluation {
	
	static class Node {
		String data;
		Node left;
		Node right;
		
		Node(String data) {
			this.data= data;
			this.left = null;
			this.right = null;
		}
	}
	
	// function to check for leaf node
	static boolean isLeafNode(Node root) {
		return root.left == null && root.right == null;
	}
	
	// Function to check for operator to apply
	static int compute(String op, int a, int b) {
		switch(op) {
			case "+" :
				return a + b;
			
			case "-" :
				return a - b;
				
			case "*" :
				return a * b;
				
			case "/" :
				return a / b;
		}
		
		return 0;
	}
	
	static int evaluate(Node root) {
		if(root == null)
			return 0;
		
		// Leaf node, an integer
		if(isLeafNode(root)) {
			return Integer.parseInt(root.data);
		}
		
		// Evaluate Left Subtree
		int a = evaluate(root.left);
		
		// Evaluate Right Subtree
		int b = evaluate(root.right);
		
		return compute(root.data, a, b);
	}
	public static void main(String[] args) {
		Node root = new Node("*");
        root.left = new Node("+");
        root.right = new Node("+");
        root.left.left = new Node("3");
        root.left.right = new Node("2");
        root.right.left = new Node("4");
        root.right.right = new Node("5");
        
        System.out.println(evaluate(root));
	}

}
