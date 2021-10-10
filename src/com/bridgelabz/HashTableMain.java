package com.bridgelabz;
import java.util.ArrayList;

public class HashTableMain {
    public static void main(String[] args) {
        MyHashMap<String, Integer> hashTable = new MyHashMap();
        String sentence = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";

        /* Storing given sentence in an array.
           Converting the sentence to lower case and removing spaces.
        */
        String[] sentenceArray = sentence.toLowerCase().split(" ");

        // Iterating over the array.
        for (String word : sentenceArray) {
            Integer count = hashTable.get(word);

            if (count == null)
                count = 1;
            else
                count = count + 1;
            hashTable.add(word, count);
        }
        System.out.println(hashTable);
    }
}

class MyHashMap <K, V> {
    MyMapNode<K, V> head;
    MyMapNode<K, V> tail;
    private final int numOfBuckets;
    ArrayList<MyMapNode<K, V>> myBucketArray;

    public MyHashMap() {
        this.numOfBuckets = 10;
        this.myBucketArray = new ArrayList<>(numOfBuckets);
        // Create empty LinkedLists
        for (int i = 0; i < numOfBuckets; i++)
            this.myBucketArray.add(null);
    }

    /**
     * Purpose : method to get value from LinkedList using index number
     * @param key : key is returned
     */

    public V get(K key) {
        int index = this.getBucketIndex(key);
        if (this.myBucketArray.get(index) == null)
            return null;
        MyMapNode<K, V> myNode = search(key);
        return (myNode == null) ? null : myNode.getValue();
    }

    /**
     * Purpose : Method to search the word in LinkedList
     * @param key : key to search
     */

    public MyMapNode<K, V> search(K key) {
        MyMapNode<K, V> currentNode = head;
        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }

        return currentNode;
    }

    /**
     * Purpose : Method to add key and value to hash table
     * @param key : word to be added
     * @param value: frequency of word
     */
    public void add(K key, V value) {
        int index = this.getBucketIndex(key);
        MyMapNode<K, V> myNode = this.myBucketArray.get(index);
        if (myNode == null) {
            myNode = new MyMapNode<>(key, value);
            this.myBucketArray.set(index, myNode);
        }
        myNode = search(key);
        if (myNode == null) {
            myNode = new MyMapNode<>(key, value);
            this.append(myNode);
        } else
            myNode.setValue(value);
    }

    // This implements hash function to find index for a key
    public int getBucketIndex(K key) {
        int hashCode = Math.abs(key.hashCode());
        int index = hashCode % numOfBuckets;
        return index;

    }

    /**
     * Purpose : Method to append value to Linked List
     * @param myNode : value to append
     */

    private void append(MyMapNode<K, V> myNode) {
        if (this.head == null)
            this.head = myNode;
        if (this.tail == null)
            this.tail = myNode;
        else {
            this.tail.setNext(myNode);
            this.tail = myNode;
        }
    }

    @Override
    public String toString() {
        return "MyHashMapNodes{" + head + '}';
    }
}
class MyMapNode <K, V> {
    K key;
    V value;
    MyMapNode<K, V> next;

    public MyMapNode(K key, V value) {
        this.key = key;
        this.value = value;
        next = null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public MyMapNode<K, V> getNext() {
        return next;
    }

    public void setNext(MyMapNode<K, V> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder nodeString = new StringBuilder();
        nodeString.append("Node{" + "Key=").append(key).append(" Value=").append(value).append("}");
        if(next != null)
            nodeString.append("->").append(next);
        return nodeString.toString();
    }
}
