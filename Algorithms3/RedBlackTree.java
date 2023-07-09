package Algorithms3;

public class RedBlackTree {
    private Node root;

    public boolean add(int value) {
        if (root == null) {
            root = new Node(value);
            root.color = Color.BLACK;
            return true;
        }

        Node newNode = addNode(root, value);
        if (newNode == null)
            return false;

        balanceAfterInsertion(newNode);
        return true;
    }

    private Node addNode(Node node, int value) {
        if (node.value == value)
            return null;

        Node newNode;
        if (node.value > value) {
            if (node.left == null) {
                newNode = new Node(value);
                newNode.parent = node;
                node.left = newNode;
                return newNode;
            } else {
                return addNode(node.left, value);
            }
        } else {
            if (node.right == null) {
                newNode = new Node(value);
                newNode.parent = node;
                node.right = newNode;
                return newNode;
            } else {
                return addNode(node.right, value);
            }
        }
    }

    public boolean contains(int value) {
        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.value == value)
                return true;
            if (currentNode.value > value)
                currentNode = currentNode.left;
            else
                currentNode = currentNode.right;
        }
        return false;
    }

    private void balanceAfterInsertion(Node node) {
        node.color = Color.RED;

        while (node != null && node != root && node.parent.color == Color.RED) {
            if (parentOf(node) == leftOf(parentOf(parentOf(node)))) {
                Node uncle = rightOf(parentOf(parentOf(node)));
                if (colorOf(uncle) == Color.RED) {
                    setColor(parentOf(node), Color.BLACK);
                    setColor(uncle, Color.BLACK);
                    setColor(parentOf(parentOf(node)), Color.RED);
                    node = parentOf(parentOf(node));
                } else {
                    if (node == rightOf(parentOf(node))) {
                        node = parentOf(node);
                        rotateLeft(node);
                    }
                    setColor(parentOf(node), Color.BLACK);
                    setColor(parentOf(parentOf(node)), Color.RED);
                    rotateRight(parentOf(parentOf(node)));
                }
            } else {
                Node uncle = leftOf(parentOf(parentOf(node)));
                if (colorOf(uncle) == Color.RED) {
                    setColor(parentOf(node), Color.BLACK);
                    setColor(uncle, Color.BLACK);
                    setColor(parentOf(parentOf(node)), Color.RED);
                    node = parentOf(parentOf(node));
                } else {
                    if (node == leftOf(parentOf(node))) {
                        node = parentOf(node);
                        rotateRight(node);
                    }
                    setColor(parentOf(node), Color.BLACK);
                    setColor(parentOf(parentOf(node)), Color.RED);
                    rotateLeft(parentOf(parentOf(node)));
                }
            }
        }

        root.color = Color.BLACK;
    }

    private Node parentOf(Node node) {
        return node != null ? node.parent : null;
    }

    private Node leftOf(Node node) {
        return node != null ? node.left : null;
    }

    private Node rightOf(Node node) {
        return node != null ? node.right : null;
    }

    private Color colorOf(Node node) {
        return node != null ? node.color : Color.BLACK;
    }

    private void setColor(Node node, Color color) {
        if (node != null)
            node.color = color;
    }

    private void rotateLeft(Node node) {
        if (node != null) {
            Node rightChild = node.right;
            node.right = rightChild.left;
            if (rightChild.left != null)
                rightChild.left.parent = node;
            rightChild.parent = node.parent;
            if (node.parent == null)
                root = rightChild;
            else if (node.parent.left == node)
                node.parent.left = rightChild;
            else
                node.parent.right = rightChild;
            rightChild.left = node;
            node.parent = rightChild;
        }
    }

    private void rotateRight(Node node) {
        if (node != null) {
            Node leftChild = node.left;
            node.left = leftChild.right;
            if (leftChild.right != null)
                leftChild.right.parent = node;
            leftChild.parent = node.parent;
            if (node.parent == null)
                root = leftChild;
            else if (node.parent.right == node)
                node.parent.right = leftChild;
            else
                node.parent.left = leftChild;
            leftChild.right = node;
            node.parent = leftChild;
        }
    }

    private class Node {
        int value;
        Node left;
        Node right;
        Node parent;
        Color color;

        Node(int value) {
            this.value = value;
            this.color = Color.RED;
        }
    }

    enum Color {
        RED, BLACK
    }
}
public static void main(String[] args) {
    RedBlackTree tree = new RedBlackTree();
    
    tree.add(10);
    tree.add(5);
    tree.add(15);
    tree.add(3);
    tree.add(7);
    tree.add(12);
    tree.add(17);
    
    System.out.println(tree.contains(7));
    System.out.println(tree.contains(20));
}
