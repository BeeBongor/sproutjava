package mathmatics;

import java.util.Stack;

/**
 * Created by dengmingliang on 2020/5/12
 */
public class MinStack {
  Stack<Integer> helpStack;
  Stack<Integer> actualStack;

  /**
   * initialize your data structure here.
   */
  public MinStack() {
    this.helpStack = new Stack();
    this.actualStack = new Stack();
  }

  public void push(int x) {
    if (!helpStack.isEmpty()) {
      if (helpStack.peek() < x) {
        helpStack.push(helpStack.peek());
      } else {
        helpStack.push(x);
      }
    } else {
      helpStack.push(x);
    }
    actualStack.push(x);
  }

  public void pop() {
    helpStack.pop();
    actualStack.pop();
  }

  public int top() {
    return actualStack.peek();
  }

  public int getMin() {
    return helpStack.peek();
  }
}
