package data_structures.stack;

import java.util.Collections;
import java.util.Stack;

public class CloneStack {
    void cloneStack(Stack<Integer> st, Stack<Integer> cloned) {
        Collections.copy(st, cloned);
    }
}
