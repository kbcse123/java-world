
package com.javaworld.A9_Algorithms.F_Searching_Algorithms;

/**
 * 
 * @author Shaik Khader
 * 
 *         Trees:
 * 
 *         .Unlike Arrays, Linked Lists, Stack and queues, which are linear data
 *         structures, trees are hierarchical data structures.
 * 
 *         .The topmost node is called root of the tree. The elements that are
 *         directly under an element are called its children.
 * 
 *         The element directly above something is called its parent.
 * 
 *         Why Trees?
 * 
 *         1. One reason to use trees might be because you want to store
 *         information that naturally forms a hierarchy. For example, the file
 *         system on a computer:
 * 
 *         2. Trees (with some ordering e.g., BST) provide moderate
 *         access/search (quicker than Linked List and slower than arrays).
 * 
 *         3. Trees provide moderate insertion/deletion (quicker than Arrays and
 *         slower than Unordered Linked Lists).
 * 
 *         4. Like Linked Lists and unlike Arrays, Trees don�t have an upper
 *         limit on number of nodes as nodes are linked using pointers.
 * 
 *         Binary Tree: A tree whose elements have at most 2 children is called
 *         a binary tree. Since each element in a binary tree can have only 2
 *         children,
 * 
 *         we typically name them the left and right child.
 * 
 *         Binary Search Tree: BST is a special type of Binary Tree that follows
 *         following condition:
 * 
 *         left child node is smaller than its parent Node
 * 
 *         right child node is greater than its parent Node
 * 
 *         The left and right subtree each must also be a binary search tree.
 * 
 *         Insertion:
 * 
 *         A new key is always inserted at leaf. We start searching a key from
 *         root till we hit a leaf node. Once a leaf node is found,
 * 
 *         the new node is added as a child of the leaf node.
 * 
 *         Search:
 * 
 *         To search a given key in Binary Search Tree, we first compare it with
 *         root, if the key is present at root, we return root.
 * 
 *         If key is greater than root�s key, we move to right subtree of root
 *         node, Otherwise we move to left subtree and so on.
 * 
 *         Removal:
 * 
 *         When we want to delete a node, three possibilities arise.
 * 
 *         1) Node to be deleted is leaf: Simply remove from the tree.
 * 
 *         2) Node to be deleted has only one child: link the child to the
 *         parent of the removing node and delete the node.
 * 
 *         3) Node to be deleted has two children:
 * 
 *         a.find a successor in the right subtree;
 * 
 *         b.replace value of the node to be removed with found successor. Now,
 *         right subtree contains a duplicate!
 * 
 *         c.apply remove to the right subtree to remove a duplicate.
 * 
 *         Traversal:
 * 
 *         Depth-First Search:
 * 
 *         Inorder-Traversal {Left sub-tree,Parent,Right sub-tree} - LPR
 * 
 *         Preorder-Traversal {Parent,Left sub-tree,Right sub-tree} - PLR
 * 
 *         Postorder-Traversal {Left sub-tree,Right sub-tree,Parent} - LRP
 * 
 *         Breadth-First Search:
 * 
 *         This is another common type of traversal that visits all the nodes of
 *         a level before going to the next level.
 * 
 *         This kind of traversal is also called level-order and visits all the
 *         levels of the tree starting from the root, and from left to right.
 * 
 * 
 * 
 */

class Node

{

	int key;

	Node left, right;

	public Node(int item)

	{

		key = item;

		left = right = null;

	}

}

interface BinaryTree {

	void add(int key);

	void remove(int key);

	void inOrder(Node node);

	void preOrder(Node node);

	void postOrder(Node node);

	void breadFirstSearch(Node node);

	default void displayNode(Node node) {

		if (node != null) {

			displayNode(node.left);

			System.out.println(node.key);

			displayNode(node.right);

		}

	}

}

class BinarySearchTree implements BinaryTree

{

	// Root of Binary Tree

	Node root;

	// Constructors

	BinarySearchTree(int key)

	{

		root = new Node(key);

	}

	BinarySearchTree()

	{

		root = null;

	}

	public void add(int key) {

		if (root == null) {

			root = new Node(key);

			return;

		}

		Node n = new Node(key);

		Node pointer = root, parent = root;

		while (pointer != null) {

			parent = pointer;

			pointer = (key > pointer.key) ? pointer.right : pointer.left;

		}

		if (parent.key < key)

			parent.right = n;

		else if (parent.key > key)

			parent.left = n;

	}

	/*
	 * private Node findEmptyNode(int key,Node temp) {
	 * 
	 * while(temp != null){
	 * 
	 * temp = (key > temp.key) ? temp.right : temp.left;
	 * 
	 * }
	 * 
	 * return temp;
	 * 
	 * }
	 */

	public void remove(int key) {

		// Node node = findNode(key);

		Node pointer = root, parent = root;

		loop: while (pointer != null) {

			if (key == pointer.key) {

				// System.out.println("\nGot it:"+pointer.key);

				break loop;

			}

			parent = pointer;

			if (key > pointer.key) {

				pointer = pointer.right;

			} else if (key < pointer.key) {

				pointer = pointer.left;

			}

		}

		if (pointer != null) {

			System.out.println("\nRemoving " + key);

			// Rule 1: If Node to be deleted is leaf: Simply remove from the
			// tree.

			if (pointer.left == null && pointer.right == null) {

				if (parent.key < pointer.key)

					parent.right = null;

				else

					parent.left = null;

				pointer = null;

				return;

			}

			// Rule 2: If Node to be deleted has only one child: Link the child
			// to the parent of the removing node and delete the node.

			if (pointer.left == null) {

				if (parent.key < pointer.key)
					parent.right = pointer.right;

				else
					parent.left = pointer.right;

				pointer = null;

				return;

			} else if (pointer.right == null) {

				if (parent.key < pointer.key)
					parent.right = pointer.left;

				else
					parent.left = pointer.left;

				pointer = null;

				return;

			}

			// Rule 3: If Node to be deleted has two children:

			// a.find a successor(minimum) of the node in the right subtree;

			Node successor = successor(pointer);

			System.out.println("successorParent = " + successor.key);

			// b.replace value of the node to be removed with found successor.
			// Now, right subtree contains a duplicate!

			pointer.key = successor.key;

			// c.remove the successor which is a duplicate.

			Node successorParent = pointer;

			Node removingNode = pointer.right;

			while (removingNode.left != null) {

				successorParent = removingNode;

				removingNode = removingNode.left;

			}

			if (removingNode.key < successorParent.key)

				successorParent.right = null;

			else

				successorParent.left = null;

		} else {

			System.out.println("Item not found...");

		}

	}

	// find successor of a node

	private Node successor(Node parent) {

		Node successor = parent.right;

		while (successor.left != null) {

			successor = successor.left;

		}

		return successor;

	}

	private Node predecessor(Node parent) {

		Node predecessor = parent.left;

		while (predecessor != null) {

			predecessor = predecessor.right;

		}

		return predecessor;

	}

	/*
	 * private Node findNode(int key){
	 * 
	 * Node temp=root;
	 * 
	 * 
	 * 
	 * while(temp != null){
	 * 
	 * if(key > temp.key){
	 * 
	 * temp = temp.right;
	 * 
	 * }else if(key < temp.key){
	 * 
	 * temp = temp.left;
	 * 
	 * }else{
	 * 
	 * System.out.println("\nGot it:"+temp.key);
	 * 
	 * return temp;
	 * 
	 * }
	 * 
	 * }
	 * 
	 * return null;
	 * 
	 * }
	 */

	public void iterateNodes(String traversal) {

		System.out.println("\nTraversal: " + traversal);

		switch (traversal) {

		case "inorder":
			inOrder(root);

			break;

		case "preorder":
			inOrder(root);

			break;

		case "postorder":
			inOrder(root);

			break;

		case "bfs":
			breadFirstSearch(root);

			break;

		}

	}

	@Override

	public void inOrder(Node node) {

		if (node == null)

			return;

		inOrder(node.left);

		System.out.print(node.key + " ");

		inOrder(node.right);

	}

	@Override

	public void preOrder(Node node) {

		if (node == null)

			return;

		System.out.print(node.key + " ");

		preOrder(node.left);

		preOrder(node.right);

	}

	@Override

	public void postOrder(Node node) {

		if (node == null)

			return;

		postOrder(node.left);

		postOrder(node.right);

		System.out.print(node.key + " ");

	}

	@Override

	public void breadFirstSearch(Node node) {

	}

}

public class A6_BinarySearchTree {

	public static void main(String... args) {

		BinarySearchTree tree = new BinarySearchTree(7);

		tree.add(7);
		tree.add(2);
		tree.add(3);
		tree.add(4);
		tree.add(9);
		tree.add(15);
		tree.add(10);
		tree.add(8);
		tree.iterateNodes("inorder");

		/*
		 * tree.preOrder();
		 * 
		 * tree.postOrder();
		 */

		// leaf node

		tree.remove(4);
		tree.iterateNodes("inorder");

		// one child node

		// tree.remove(15);

		// tree.iterateNodes("inorder");

		// two children node

		tree.remove(9);
		tree.iterateNodes("inorder");

	}

}
