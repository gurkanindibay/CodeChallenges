package com.hackerrank.search;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

/**
 * Evaluation
 * I can use recursive methods more effectively. Practice worked.
 * Understanding the problem was very difficult for me. The problem statement was too long and complicated. I even could not understand the problem statement in the first read
 * I needed to reevaluate the statement two or three times.
 * Once I understood the statement, forming a solution was a little bit difficult for me. I realized that I needed to use Tree data structures to solve the problem. However initial array to form the tree
 * was linear, in the order of tree level, not the order of tree, so converting this linear structure into tree structure was complicated for me.In the end, I had to get help from discussion and found out that
 * I needed to use stack or queue like structures. I used stack but because of its FILO nature, I needed to change it into Queue because of its FIFO nature.
 * SUMMARY: I need to understand and practice basic data types like Tree, Queue, stack and I need some practice to find out their limitations and use them together like a chef to create a solution.
 */

public class SwapNodes {

    static int[][] swapNodes(int[][] indexes, int[] queries) {
        int[][] result = new int[queries.length][];

        TreeNode root = buildTree(indexes);


        for (int i = 0; i < queries.length; i++) {
            swapNode(root, queries[i]);
            List<Integer> valueList = new ArrayList<>();
            printNode(root, valueList);
            result[i] = valueList.stream().mapToInt(v -> v).toArray();
        }
        return result;
    }

    private static TreeNode buildTree(int[][] indexes) {
        TreeNode root = new TreeNode(1, 0);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int counter = 0;
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            if (indexes[counter][0] > 0) {
                node.left = new TreeNode(indexes[counter][0], node.level + 1);
                queue.add(node.left);
            }
            if (indexes[counter][1] > 0) {
                node.right = new TreeNode(indexes[counter][1], node.level + 1);
                queue.add(node.right);
            }
            counter++;
        }
        return root;
    }

    public static void swapNode(TreeNode node, int level) {
        if (level == 0 || node == null) return;
        if ((node.level + 1) % level == 0) {
            TreeNode t = node.left;
            node.left = node.right;
            node.right = t;
        }
        swapNode(node.left, level);
        swapNode(node.right, level);

    }

    private static void printNode(TreeNode node, List<Integer> result) {
        if (node == null) return;

        if (node.left != null) printNode(node.left, result);
        result.add(node.value);
        if (node.right != null) printNode(node.right, result);
    }

    static class TreeNode {
        int value;
        int level;

        TreeNode(int value, int level) {
            this.value = value;
            this.level = level;
        }


        TreeNode left;
        TreeNode right;
    }


    private static Scanner scanner;

    static {
        try {
            scanner = new Scanner(Paths.get(("resources/search/input_swap_nodes.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
