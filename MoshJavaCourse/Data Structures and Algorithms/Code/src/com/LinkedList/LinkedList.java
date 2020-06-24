package com.LinkedList;

public class LinkedList {
    private Node first;
    private Node last;
    private int size;

    public void addFirst (int value){
        Node node = new Node(value, this.first);
        this.first = node;

        if (this.last == null){
            this.last = node;
        }
        this.size++;
    }

    public void addLast (int value){
        Node node = new Node(value, null);

        if (this.last != null){
            this.last.setNext(node);
        }
        else{
            this.first = node;
        }

        this.last = node;
        this.size++;
    }

    public void deleteFirst(){
        if (this.first != null){
            Node currentNode = this.first;
            this.first = currentNode.getNext();
            currentNode.setNext(null);
            this.size--;
        }
    }

    public void deleteLast(){
        if (this.first == this.last){
            this.first = null;
            this.last = null;
            this.size--;
        }
        if (this.last != null){
            Node currentNode = first;
            while (currentNode.getNext().getNext() != null){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(null);
            this.last = currentNode;
            this.size--;
        }
    }

    public boolean contains (int value){
        Node currentNode = first;
        while (currentNode != null){
            if (currentNode.getValue() == value){
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    public int indexOf (int value){
        int count = 0;
        Node currentNode = first;

        while (currentNode != null){
            if (currentNode.getValue() == value){
                return count;
            }
            currentNode = currentNode.getNext();
            count++;
        }
        return -1;
    }

    public int getSize(){
        return this.size;
    }

    public int[] toArray (){
        int[] array = new int [size];
        if (this.first != null){
            int index = 0;
            Node currentNode = first;

            while (currentNode != null){
                array[index] = currentNode.getValue();
                currentNode = currentNode.getNext();
                index++;
            }
        }
        return array;
    }

    public void reverse(){
        Node previousNode = this.first;
        Node currentNode = previousNode.getNext();
        while (currentNode != null){
            Node nextNode = currentNode.getNext();
            currentNode.setNext(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;
        }

        this.last = this.first;
        this.last.setNext(null);
        this.first = previousNode;
    }

    public int getKthFromTheEnd (int k){
        //[10 -> 20 -> 30 -> 40 -> 50]
        if (k <= 0 || k > this.size){
            return -1;
        }

        int indexOfItem = this.size - k;
        Node currentNode = this.first;

        for (int i = 0; i < indexOfItem; i ++){
            currentNode = currentNode.getNext();
        }

        return currentNode.getValue();
    }

    public int getKthFromTheEndWithoutSize (int k){
        //[10 -> 20 -> 30 -> 40 -> 50]
        // *     *
        int distance = k - 1;
        Node targetPointer = this.first;
        Node secondPointer = this.first;
        for (int i = 0; i < distance; i++){
            secondPointer = secondPointer.getNext();
            if (secondPointer == null){
                return -1;
            }
        }

        if (distance < 0)
            return -1;

        while (secondPointer.getNext() != null){
            targetPointer = targetPointer.getNext();
            secondPointer = secondPointer.getNext();
        }

        return targetPointer.getValue();
    }

    public void printMiddle (){
        Node firstNode = this.first;
        Node secondNode = this.first;

        while (secondNode != this.last && secondNode.getNext() != this.last){
            firstNode = firstNode.getNext();
            secondNode = secondNode.getNext().getNext();
        }

        if (secondNode == this.last){
            System.out.println(firstNode.getValue());
        }
        else{
            System.out.println(firstNode.getValue() + ", " + firstNode.getNext().getValue());
        }
    }

    public void print (){
        Node currentNode = first;
        while (currentNode != null){
            System.out.println(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
    }

}
