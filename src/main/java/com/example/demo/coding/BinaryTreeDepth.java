/**
 * 
 */
package com.example.demo.coding;

import java.util.Arrays;
import java.util.List;

/**
 * Given a binary tree, write a program to find the maximum depth of the binary tree.
i) The maximum depth is the number of nodes along the longest path from the root node to the leaf node.
ii) A leaf is a node with no child nodes.
Input: Given binary tree,
[5, 3, 6, 2, 4, -1, -1, 1, -1, -1, -1, -1, -1]
      5
     / \
    3   6
   / \
  2   4
/
1
 * @author Rahil_Khan
 *
 */
public class BinaryTreeDepth {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> intAL = Arrays.asList(5, 3, 6, 2, 4, -1, -1, 1, -1, -1, -1, -1, -1);

		BinaryTreeDepth btd = new BinaryTreeDepth();
		btd.binaryTreeDepth(intAL);
	}
	
	private void binaryTreeDepth(List<Integer> intAL) {
		if(intAL.size() == 0)
			System.out.println("Node depth : -1");
		else if(intAL.size() == 1)
			System.out.println("Node depth : 1");
		
		for(int i=0;i< intAL.size();i++) {
			
		}
		
		
	}

}
