package com.company;

public class BinaryTree {
    private BinaryTree leftChild;
    private BinaryTree rightChild;
    private String symbol;
    private String code;
    private int count;
    private int numberParent;

    public BinaryTree(){
        leftChild=null;
        rightChild=null;
    }

    public BinaryTree getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTree leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTree getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTree rightChild) {
        this.rightChild = rightChild;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void changeCount(){
        if(leftChild!=null){
            count = leftChild.getCount()+rightChild.getCount();
        }
    }

    public void upCount(){
        count++;
    }

    public void setNumberParent(int numberParent){
        this.numberParent=numberParent;
    }

    public int getNumberParent(){
        return numberParent;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
