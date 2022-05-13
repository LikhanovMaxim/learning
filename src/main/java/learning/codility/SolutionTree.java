package learning.codility;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");


import org.apache.commons.lang3.tuple.Pair;

import java.util.Stack;

//TODO cannot check on https://app.codility.com/programmers/trainings/4/tree_height/ cause import
class SolutionTree {
    int maxHighTree;

    public int solution(Tree T) {
        maxHighTree = 0;
        Stack<Pair<Tree, Integer>> stack = new Stack<>();
//        Pair pair = new Pair(T, 0);
        push(stack, T, 0);
        findInDeep(stack);
        return maxHighTree;
    }

    private void findInDeep(Stack<Pair<Tree, Integer>> stack) {
        if (stack.isEmpty()) {
            return;
        }
        Pair<Tree, Integer> pair = stack.pop();
        Tree cursor = pair.getLeft();
        Integer highTree = pair.getRight();
        if (highTree > maxHighTree) {
            maxHighTree = highTree;
        }
        if (cursor.r != null) {
            push(stack, cursor.r, highTree + 1);
        }
        if (cursor.l != null) {
            push(stack, cursor.l, highTree + 1);
        }
        findInDeep(stack);
    }

    private void push(Stack<Pair<Tree, Integer>> stack, Tree cursor, int highTree) {
        stack.push(Pair.of(cursor, highTree));
    }
}

class Tree {
    public int x;
    public Tree l;
    public Tree r;

    public Tree(int x, Tree l, Tree r) {
        this.x = x;
        this.l = l;
        this.r = r;
    }
}
