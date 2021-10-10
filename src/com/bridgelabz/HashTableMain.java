package com.bridgelabz;

public class HashTableMain {
    public static void main(String[] args) {
        MyHashTable<String, Integer> hashTable = new MyHashTable();
        String sentence = "To be or not to be";

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
    public static class MyHashTable <K, V> {
        MyMapNode head;
        MyMapNode tail;

        /**
         * Purpose: Method to get the word from Linked List.
         * @param word: word returned.
         */
        public V get(K word) {
            MyMapNode<K, V> myNode = searchNode(word);
            return (myNode == null) ? null : myNode.getValue();
        }

        /**
         * Purpose: Method to search word from Linked List.
         * @param word: word to search.
         */
        public MyMapNode<K, V> searchNode(K word) {
            MyMapNode<K, V> currentNode = head;
            int position = 0;
            while (currentNode != null) {
                position++;
                if (currentNode.getKey().equals(word)) {
                    return currentNode;
                }
                currentNode = currentNode.getNext();
            }
            return currentNode;
        }

        /**
         * Purpose: Method to add key and value to hash table.
         * @param key: word to be added.
         * @param value: frequency of word.
         */
        public void add(K key, V value) {
            MyMapNode<K, V> myNode = searchNode(key);
            if (myNode == null) {
                myNode = new MyMapNode<>(key, value);
                this.append(myNode);
            } else
                myNode.setValue(value);

        }

        /**
         * Purpose: Method to append value to Linked List.
         * @param myNode: value to append.
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
            return "MyLinkedListNodes{" + head + '}';
        }
    }
    public static class MyMapNode <K,V>{
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
            this.next = (MyMapNode<K, V>) next;
        }

        @Override
        public String toString() {
            StringBuilder nodeString = new StringBuilder();
            nodeString.append("MyMapNode{" + " Key= ").append(key).append(" Value= ").append(value).append('}');
            if (next != null)
                nodeString.append("->").append(next);
            return nodeString.toString();
        }
    }
}
