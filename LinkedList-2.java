// Author: Joshua Castro
// Date: September 2022
// This is a class implementing the LinkedList data structure
// Each list consists of private Node objects, with a .next as well as a .data
// Each list is a generic type that is set by user upon initialization
// LinkedList contains various methods to store, remove, or modify list items, as required by project

public class LinkedList<T extends Comparable<T>>
{
    // Node to represent the head of the list
    Node head;
    // Node class with generic type data and a .next
    private class Node
    {
        T data;
        Node next;
        // Node constructor with generic data parameter
        public Node(T d)
        {
            data = d;
            next = null;
        }
    }
    // method to insert a new node at the last position of the list
    // input: value to store in node
    // return: none
    public void insertLast(T value)
    {
        // If list is empty
        Node insert = new Node(value);
        if(head == null)
        {
            head = insert;
        }
        // If list is not empty
        else
        {
            // find the end of the list before inserting
            Node temp = head;
            while(temp.next!=null)
            {
                temp = temp.next;
            }
            temp.next = insert;
        }
    }
    // method to insert a node at the start of the list
    // input: value to store in node
    // return: none
    public void insertFirst(T value)
    {
        // list is empty
        if(head == null)
        {
            head = new Node(value);
        }
        // list is not empty
        else
        {
            Node n = new Node(value);
            n.next = head;
            head = n;
        }
    }
    // method to insert a node at a specific index in the list
    // input: value to store in node
    // return: none
    public void insertIndex(T value, int index)
    {
        // if the index is 1, calls method to insert at start of list
        if(index==1)
        {
            insertFirst(value);
        }
        // checks if the list is empty
        if (head == null)
        {
            System.out.println("List is empty");
        }
        // variable to track position in list
        else
        {
            int i = 1;
            Node temp = head;
            // loops through list as long as another item in list exists and the index hasn't been reached yet
            while (i != (index - 1) && temp.next != null)
            {
                temp = temp.next;
                i++;
            }
            // if the end of the list is reached and index still hasn't been reached, prints appropriate statement
            if (temp.next == null && i < (index - 1))
            {
                System.out.println("Index " + i + " does not exist in list");
            }
            // if end of list not reached yet and index is reached, inserts node at position
            else
            {
                Node insert = new Node(value);
                insert.next = temp.next;
                temp.next = insert;
            }
        }
    }
    // method to remove the first node in the list
    // input: none
    // return: none
    public void removeFirst()
    {
        // if list is empty lets user know
        if (head == null)
        {
            System.out.println("nothing to delete");
        }
        // if list only contains one element, deletes it
        else if (head.next==null)
        {
            head=null;
            System.out.println("Deleted first element. List is now empty");
        }
        // if list >1 element, sets the head of the list to what was previously the second item in the list
        else
        {
            head = head.next;
        }
    }
    // method to remove the last node in the list
    // input: none
    // return: none
    public void removeLast()
    {
        // if list is empty lets user know
        if (head == null)
        {
            System.out.println("nothing to delete");
        }
        // if one item in list, deletes item
        else if (head.next == null)
        {
            head = null;
        }
        // if >1 item in list, iterates through list and deletes the last node
        else
        {
            Node temp = head;
            Node prev = head;
            // sets temp to be the last item, and prev to be the second-to-last
            while (temp.next != null)
            {
                prev = temp;
                temp = temp.next;
            }
            // deletes the connection from the second-to-last node to the last, deleting the last
            prev.next = null;
        }
    }
    // method to remove a specific node as given in an index
    // input: index of node to remove
    // return: none
    public void removeIndex(int index)
    {
        // checks that the index is valid (could be in list)
        if (index<=0)
        {
            System.out.println("Index must be positive integer");
        }
        // checks if the list exists
        else if (head==null)
        {
            System.out.println("List is empty");
        }
        // if index is the first in list, calls appropriate method
        else if (index==1)
        {
            removeFirst();
        }
        // finds the appropriate index and deletes it
        else
        {
            // prev and temp node kept
            Node prev = head;
            Node temp = head;
            // variable to track position in list
            int i = 1;
            // while not at the end of the list and the index hasn't been found yet, loops through list
            while(temp.next!=null&&i!=index)
            {
                prev = temp;
                temp = temp.next;
                i++;
            }
            // if at the end of the list and index still hasn't been reached, lets user know
            if (temp.next==null&&i<index)
            {
                System.out.println("Index "+index+" does not exist in list");
            }
            // if index has been reached, sets the node before the node to be deleted to point to the node after the node to be deleted
            else
            {
                prev.next = temp.next;
            }
        }
    }
    // method to search for the first occurrence of an index value given data to look for
    // input: value to search for
    // return: int of index location
    public int searchByValue(T val)
    {
        // checks if the list exists
        if (head==null)
        {
            System.out.println("List is empty");
            return 0;
        }
        // index variable to be returned
        int index = 1;
        Node temp = head;
        // loops through the list while another element exists and the data value hasn't been found
        while(temp.next!=null&&val!=temp.data)
        {
            temp = temp.next;
            index++;
        }
        // if at the end of the list and value still hasn't been found, lets user know
        if(temp.next==null&&val!=temp.data)
        {
            System.out.println("Value "+val+" does not exist in list");
            return -1;
        }
        // if found, returns index
        else return index;
    }
    // method to return the data in a specific index of the list
    // input: index to search for
    // return: data in node
    public T searchByIndex(int index)
    {
        // confirms that the index is valid and could be in list
        if (index<=0)
        {
            System.out.println("Index must be positive integer");
            return null;
        }
        // checks if the list exists
        else if (head==null)
        {
            System.out.println("List is empty");
            return null;
        }
        // if the index is 1, returns data in head
        else if (index==1)
        {
            return head.data;
        }
        // if index is >1 and list exists, finds the appropriate index in list (if exists)
        else
        {
            // Node to iterate through the list and variable to keep track of current position
            Node temp = head;
            int i = 1;
            // goes through list until the end is reached or the index is reached
            while(temp.next!=null&&i!=index)
            {
                temp = temp.next;
                i++;
            }
            // if at the end, lets user know that their index is too big
            if (temp.next==null&&i<index)
            {
                System.out.println("Index "+i+" does not exist in list");
                return null;
            }
            // if index is reached, returns appropriate data
            else return temp.data;
        }
    }
    // method to update a specific index with new data, returning a t/f showing if the update has been made
    // input: index to update, data to change to
    // return: t/f if updated/not
    public boolean update(int index, T data)
    {
        // boolean to return
        boolean r = false;
        // checks if index is valid and could exist in list
        if (index<=0)
        {
            System.out.println("Index must be positive integer");
        }
        // checks if list is empty
        else if (head==null)
        {
            System.out.println("List is empty");
        }
        // if index is 1, updates the head's data
        else if (index==1)
        {
            head.data = data;
            r = true;
        }
        // if list is not empty and index>1, finds appropriate index (if it exists) and updates data
        else
        {
            // Node and variable to iterate through list and keep track of position
            Node temp = head;
            int i = 1;
            // loops through list as long as index and end of list haven't been reached
            while(temp.next!=null&&i!=index)
            {
                temp = temp.next;
                i++;
            }
            // if at the end of the list and index still isn't reached, prints appropriate message
            if (temp.next==null&&i<index)
            {
                System.out.println("Index "+index+" does not exist in list");
            }
            // if index is reached, sets return boolean to true and updates data
            else
            {
                temp.data = data;
                r = true;
            }
        }
        return r;
    }
    // method to update a specific number of old values to be a new value, returning how many updates have been made
    // input: old value to replace, new value to set it to, maximum number of times to update
    // return: number of times updated
    public int updateAll(T oldVal, T newVal, int times)
    {
        // checks if times is an appropriate value
        int t = 0;
        if (times<=0)
        {
            System.out.println("Must update at least one time");
        }
        // checks if anything is in list
        else if (head == null)
        {
            System.out.println("Nothing in list.");
        }
        // loops through list as long as another item exists and user still wants to update at least one more element
        else
        {
            Node temp = head;
            while (temp.next!=null&&times>0)
            {
                // if the data is equal to the old value to update, updates it to new value and decreases the times remaining
                if(temp.data == oldVal)
                {
                    temp.data = newVal;
                    t++;
                    times--;
                }
                temp = temp.next;
            }
        }
        // returns the number of items updated
        return t;
    }
    // method to update all instances of an old value to be set to a new value, without a specific number of times
    // input: old value to replace, new value to set it to
    // return: number of times updated
    public int updateAll(T oldVal, T newVal)
    {
        int t = 0;
        // makes sure list exists
        if (head == null)
        {
            System.out.println("Nothing in list.");
        }
        // iterates through list updating values as desired
        else
        {
            Node temp = head;
            while (temp!=null)
            {
                if(temp.data == oldVal)
                {
                    temp.data = newVal;
                    t++;
                }
                temp = temp.next;
            }
        }
        // returns number of updates made
        return t;
    }
    // overwrites the toString method to return all elements of the list
    // input: none
    // return: String with list separated by commas
    public String toString()
    {
        // string to be returned
        String s = new String("");
        // makes sure something is in list
        if (head==null)
        {
            System.out.println("Nothing in list.");
        }
        // iterates through list, updating S to include each element of the list separated by a comma
        else
        {
            Node temp = head;
            // goes through list as long as another element exists
            while(temp.next!=null)
            {
                s = s.concat(temp.data.toString()+", ");
                temp = temp.next;
            }
            // once at the last element, adds that to string without a comma at the end
            s = s.concat(temp.data.toString());
        }
        // returns final string
        return s;
    }
    // method to insert a value at an appropriate place that would fit as sorted
    // input: value to store
    // return: none
    public void insertSorted(T val)
    {
        // checks that the list exists, if not, creates new node for head
        if (head==null)
        {
            head = new Node(val);
        }
        // if list longer than 0 elements, checks each item in list to see if it's greater than value. If so, inserts value appropriately
        else
        {
            // boolean to check if item is already inserted
            boolean stored = false;
            Node temp = head;
            // if value is lower than head, inserts it as the new head
            if(val.compareTo(head.data)<0)
            {
                insertFirst(val);
            }
            else
            {
                // loops through list as long as another element exists and val hasn't been stored yet
                while (temp.next != null && stored == false)
                {
                    // node to keep track of the previous node
                    Node prev = temp;
                    temp = temp.next;
                    // if value greater than current node data, checks if end of list, if not, goes to next item in list
                    if (val.compareTo(temp.data) > 0)
                    {
                        // if at end of list, inserts val at the end and updates stored
                        if(temp.next == null)
                        {
                            insertLast(val);
                            stored = true;
                        }
                    }
                    // if value less than or equal to current node data, sets new node to point at current node and previous node to point at new node
                    else
                    {
                        Node n = new Node(val);
                        n.next = temp;
                        prev.next = n;
                        stored = true;
                    }
                }
            }
        }
    }
    // method to bubble sort the list
    // input/return: none
    public void reSort()
    {
        // checks if list has an element
        if (head==null)
        {
            System.out.println("No list to sort.");
        }
        // checks if list has more than one element
        else if (head.next==null)
        {
            System.out.println("List contains only one element.");
        }
        // if list >1 element, sorts it using bubble sort method
        else
        {
            Boolean sorted = false;
            while (sorted == false)
            {
                sorted = true;
                // node to track through the unsorted part of the list, until the end of unsorted portion is reached
                Node temp = head;
                while (temp.next != null)
                {
                    // if one node value is greater than the next node value, swaps the two node elements
                    if(temp.data.compareTo(temp.next.data)>0)
                    {
                        // bubble sort swap method using a temporary variable to store data
                        T store = temp.data;
                        temp.data = temp.next.data;
                        temp.next.data = store;
                        sorted = false;
                    }
                    temp = temp.next;
                }
            }
        }
    }
}