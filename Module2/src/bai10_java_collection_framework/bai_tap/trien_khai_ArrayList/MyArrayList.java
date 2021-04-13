package bai10_java_collection_framework.bai_tap.trien_khai_ArrayList;

import java.util.Arrays;

public class MyArrayList<E> {
    private int size=0;
    private static final int DEFAULT_CAPACITY=10;
    private Object elements[];

    public MyArrayList() {
        elements=new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        if (capacity>0){
            this.size = capacity;
        } else {
            throw new IllegalArgumentException("capacity"+capacity);
        }
    }
    private int size(){
        return this.size;
    }
    private void clear(){
        size=0;
        for (int i=0;i<elements.length;i++){
            elements[i]=null;
        }
    }
    private boolean add(E element){
        if (elements.length==size){
            this.ensureCapacity(2);
        }
        elements[size]=element;
        size++;
        return true;
    }
    private void add(E element,int index){
        if (index>elements.length){
            throw new IllegalArgumentException("index"+index);
        }
        else if (elements.length==size){
            this.ensureCapacity(2);
        }
        if (elements[index]==null){
            elements[index]=element;
            size++;
        }else {
            for (int i=size+1;i>=index;i--){
                elements[i]=elements[i-1];
            }
            elements[index]=element;
            size++;
        }
    }

    private void ensureCapacity(int minCapacity){
        if(minCapacity>0){
            int newSize=this.elements.length*minCapacity;
            elements= Arrays.copyOf(elements,newSize);
        }
        else {
            throw new IllegalArgumentException("minCapacity"+minCapacity);
        }

    }
}
