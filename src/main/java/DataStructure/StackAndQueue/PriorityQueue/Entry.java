package DataStructure.StackAndQueue.PriorityQueue;

import DataStructure.StackAndQueue.Priority;

public class Entry implements Priority {
    String element;
    int priority;

    public Entry(String element, int priority){
        this.element = element;
        this.priority = priority;
    }

    @Override
    public int priority() {
        return priority;
    }

    @Override
    public String toString() {
        return "( " + element + " priority: " + priority + " )";
    }
}
