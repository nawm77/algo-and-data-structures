package org.ilya.Data_structures.modifiedPriorityQueue;

class Node {
    int priority;
    String data;
    Node next;

    Node(int priority, String data) {
        this.priority = priority;
        this.data = data;
        this.next = null;
    }
}

public class PriorityQueueWithBinaryHeap {
    private Node root;

    public void push(int priority, String data) {
        Node newNode = new Node(priority, data);
        if (root == null) {
            root = newNode;
        } else {
            newNode.next = root;
            root = newNode;
            heapifyUp();
        }
    }

    public Node pop() {
        if (root == null) {
            return null;
        }

        Node removedNode = root;

        if (root.next == null) {
            root = null;
        } else {
            Node lastNode = getLastNode();
            swapNodes(root, lastNode);
            root = removeLastNode();
            heapifyDown();
        }

        return removedNode;
    }

    public boolean changePriority(String data, int newPriority) {
        Node nodeToUpdate = findNode(data);
        if (nodeToUpdate != null) {
            int oldPriority = nodeToUpdate.priority;
            nodeToUpdate.priority = newPriority;
            if (newPriority > oldPriority) {
                heapifyDown(nodeToUpdate);
            } else {
                heapifyUp(nodeToUpdate);
            }
            return true;
        }
        return false;
    }

    private void heapifyUp() {
        heapifyUp(root);
    }

    private void heapifyUp(Node startNode) {
        Node currentNode = startNode;

        while (currentNode.next != null && currentNode.priority > currentNode.next.priority) {
            swapNodes(currentNode, currentNode.next);
            currentNode = currentNode.next;
        }
    }

    private void heapifyDown() {
        heapifyDown(root);
    }

    private void heapifyDown(Node startNode) {
        Node currentNode = startNode;

        while (currentNode.next != null) {
            Node minChild = findMinChild(currentNode);

            if (minChild != null && currentNode.priority > minChild.priority) {
                swapNodes(currentNode, minChild);
                currentNode = minChild;
            } else {
                break;
            }
        }
    }

    private Node findMinChild(Node parentNode) {
        if (parentNode == null || parentNode.next == null) {
            return null;
        }

        Node leftChild = parentNode.next;
        Node rightChild = (leftChild.next != null) ? leftChild.next : null;

        return (rightChild != null && rightChild.priority < leftChild.priority) ? rightChild : leftChild;
    }

    private Node getLastNode() {
        Node current = root;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    private Node removeLastNode() {
        if (root == null) {
            return null;
        }

        Node current = root;
        Node previous = null;

        while (current.next != null) {
            previous = current;
            current = current.next;
        }

        if (previous != null) {
            previous.next = null;
        } else {
            root = null;
        }

        return current;
    }

    private Node findNode(String data) {
        Node current = root;
        while (current != null) {
            if (current.data.equals(data)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    private void swapNodes(Node node1, Node node2) {
        int tempPriority = node1.priority;
        String tempData = node1.data;

        node1.priority = node2.priority;
        node1.data = node2.data;

        node2.priority = tempPriority;
        node2.data = tempData;
    }

    public static void main(String[] args) {
        PriorityQueueWithBinaryHeap priorityQueue = new PriorityQueueWithBinaryHeap();
        priorityQueue.push(3, "Task 1");
        priorityQueue.push(1, "Task 2");
        priorityQueue.push(2, "Task 3");

        System.out.println("Initial Queue:");
        while (priorityQueue.root != null) {
            Node node = priorityQueue.pop();
            System.out.println("Priority: " + node.priority + ", Data: " + node.data);
        }

        // Изменение приоритета
        priorityQueue.push(5, "Task 4");
        priorityQueue.changePriority("Task 4", 1);

        System.out.println("\nQueue after changing priority:");
        while (priorityQueue.root != null) {
            Node node = priorityQueue.pop();
            System.out.println("Priority: " + node.priority + ", Data: " + node.data);
        }
    }
}
