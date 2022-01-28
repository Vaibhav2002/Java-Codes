package data_structures.linkedlist.doubly;

class Dnode {
    Dnode next, prev;
    int data;

    Dnode(int x) {
        next = prev = null;
        data = x;
    }

}