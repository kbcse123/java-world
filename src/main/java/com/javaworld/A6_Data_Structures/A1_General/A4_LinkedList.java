package com.javaworld.A6_Data_Structures.A1_General;

/**
 * 
 *         A linked list is a linear data structure (like arrays) where each
 *         element is a separate object. Each element (that is node) of a list
 *         is comprising of two items – the data and a reference to the next
 *         node.
 * 
 *         Types of Linked List :
 * 
 *         1. Singly Linked List : In this type of linked list, every node
 *         stores address or reference of next node in list and the last node
 *         has next address or reference as NULL. For Eg. 1->2->3->4->NULL
 * 
 *         2. Doubly Linked List : In this type of Linked list, there are two
 *         references associated with each node, One of the reference points to
 *         the next node and one to the previous node. Advantage of this data
 *         structure is that we can traverse in both the directions and for
 *         deletion we don’t need to have explicit access to previous node.
 *         Eg. NULL<-1<->2<->3->NULL
 * 
 *         3. Circular Linked List : Circular linked list is a linked list where
 *         all nodes are connected to form a circle. There is no NULL at the
 *         end. A circular linked list can be a singly circular linked list or
 *         doubly circular linked list. Advantage of this data structure is that
 *         any node can be made as starting node. This is useful in
 *         implementation of circular queue in linked list. Eg. 1->2->3->1 [The
 *         next pointer of last node is pointing to the first]
 * 
 *         Accessing time of an element : O(n) Search time of an element : O(n)
 *         Insertion of an Element : O(1) - If we are at the position where we
 *         have to insert an element. Deletion of an Element : O(1) - If we know
 *         address of node previous the node to be deleted.
 * 
 * 
 *         One big drawback of linked list is, random access is not allowed.
 *         With arrays, we can access i’th element in O(1) time. In linked
 *         list, it takes Θ(i) time.
 * 
 */

public class A4_LinkedList {
	public static void main(String... args) {

	}

}
