package com.company;

import java.util.ArrayList;

public class AdaptAlg {
    private ArrayList<BinaryTree> masBinaryTree = new ArrayList<>();
    private String answer="";

    public AdaptAlg(String str){
        createSpecialSymbol();
        String[] strSymbols = str.split("");
        createFirstBinaryTree(strSymbols[0]);
        sortBinaryTree();
        System.out.println("b" + masBinaryTree.get(masBinaryTree.size()-1).getNumberParent());
        for (int i = 1; i <strSymbols.length ; i++) {
            codeAlg(strSymbols[i]);
        }
        for (int i = 0; i <masBinaryTree.size() ; i++) {
            System.out.println(masBinaryTree.get(i).getCount() + " " + masBinaryTree.get(i).getSymbol() + " "+masBinaryTree.get(i).getNumberParent());
        }
        System.out.println(answer);
    }

    public void codeAlg(String symbol){

        int flag=0;
        for (int i = 0; i <masBinaryTree.size() ; i++) {
            if(masBinaryTree.get(i).getSymbol().equals(symbol)){
                flag=1;
                break;
            }
        }
        if(flag==0){
            createFirstTimeSymbol(symbol);
            sortBinaryTree();

        }
        else{
            flag=0;
        }
    }

    public void createFirstTimeSymbol(String symbol){
        int ch = symbol.charAt(0);
        String code = Integer.toString(ch,2);
        answer=answer+masBinaryTree.get(masBinaryTree.size()-1).getCode()+code;

        masBinaryTree.add(new BinaryTree());
        masBinaryTree.get(masBinaryTree.size()-1).setCount(1);
        masBinaryTree.get(masBinaryTree.size()-1).setSymbol(symbol);

        masBinaryTree.add(new BinaryTree());
        masBinaryTree.get(masBinaryTree.get(masBinaryTree.size()-3).getNumberParent()).setRightChild(masBinaryTree.get(masBinaryTree.size()-1));
        masBinaryTree.get(masBinaryTree.size()-1).setNumberParent(masBinaryTree.get(masBinaryTree.size()-3).getNumberParent());
        System.out.println("n" + masBinaryTree.get(masBinaryTree.size()-3).getNumberParent());
        masBinaryTree.get(masBinaryTree.size()-1).setLeftChild(masBinaryTree.get(masBinaryTree.size()-2));
        masBinaryTree.get(masBinaryTree.size()-1).setRightChild(masBinaryTree.get(masBinaryTree.size()-3));
        masBinaryTree.get(masBinaryTree.size()-1).changeCount();
        masBinaryTree.get(masBinaryTree.size()-1).getLeftChild().setNumberParent(masBinaryTree.size()-1);
        masBinaryTree.get(masBinaryTree.size()-1).getRightChild().setNumberParent(masBinaryTree.size()-1);
        masBinaryTree.get(masBinaryTree.size()-1).setSymbol("");
        masBinaryTree.get(masBinaryTree.get(masBinaryTree.size()-1).getNumberParent()).changeCount();
    }

    public void createFirstBinaryTree(String symbol){
        int ch = symbol.charAt(0);
        String code = Integer.toString(ch,2);
        answer=answer+masBinaryTree.get(masBinaryTree.size()-1).getCode()+code;

        masBinaryTree.add(new BinaryTree());
        masBinaryTree.get(masBinaryTree.size()-1).setCount(1);
        masBinaryTree.get(masBinaryTree.size()-1).setSymbol(symbol);

        masBinaryTree.add(new BinaryTree());
        masBinaryTree.get(masBinaryTree.size()-1).setLeftChild(masBinaryTree.get(masBinaryTree.size()-2));
        masBinaryTree.get(masBinaryTree.size()-1).setRightChild(masBinaryTree.get(masBinaryTree.size()-3));
        masBinaryTree.get(masBinaryTree.size()-1).changeCount();
        masBinaryTree.get(masBinaryTree.size()-1).getLeftChild().setNumberParent(masBinaryTree.size()-1);
        masBinaryTree.get(masBinaryTree.size()-1).getRightChild().setNumberParent(masBinaryTree.size()-1);
        masBinaryTree.get(masBinaryTree.size()-1).setSymbol("");
        masBinaryTree.get(masBinaryTree.size()-1).setNumberParent(-1);
    }

    public void sortBinaryTree(){
        for (int i = 0; i <masBinaryTree.size()-1 ; i++) {
            for (int j = i; j < masBinaryTree.size()-1 ; j++) {
                if(masBinaryTree.get(j).getCount()<masBinaryTree.get(j+1).getCount()){
                    if(masBinaryTree.get(j).getLeftChild()!=null){
                        masBinaryTree.get(j).getLeftChild().setNumberParent(j+1);
                        masBinaryTree.get(j).getRightChild().setNumberParent(j+1);
                    }
                    if(masBinaryTree.get(j+1).getLeftChild()!=null){
                        masBinaryTree.get(j+1).getLeftChild().setNumberParent(j);
                        masBinaryTree.get(j+1).getRightChild().setNumberParent(j);
                    }
                    toSwap(j,j+1);
                }
            }
        }
        for (int i = 0; i <masBinaryTree.size() ; i++) {
            for (int j = i; j < masBinaryTree.size()-1 ; j++) {
                if(masBinaryTree.get(j).getCount()==masBinaryTree.get(j+1).getCount()){
                    if(masBinaryTree.get(j).getNumberParent()>masBinaryTree.get(j+1).getNumberParent()){
                        if(masBinaryTree.get(j).getLeftChild()!=null){
                            masBinaryTree.get(j).getLeftChild().setNumberParent(j+1);
                            masBinaryTree.get(j).getRightChild().setNumberParent(j+1);
                        }
                        if(masBinaryTree.get(j+1).getLeftChild()!=null){
                        masBinaryTree.get(j+1).getLeftChild().setNumberParent(j);
                        masBinaryTree.get(j+1).getRightChild().setNumberParent(j);
                        }
                        toSwap(j,j+1);
                    }
                }
            }
        }

    }

    public void toSwap(int first,int second){
        BinaryTree swap = masBinaryTree.get(first);
        masBinaryTree.set(first,masBinaryTree.get(second));
        masBinaryTree.set(second,swap);
    }

    public void createSpecialSymbol(){
        masBinaryTree.add(new BinaryTree());
        masBinaryTree.get(0).setSymbol("ESC");
        masBinaryTree.get(0).setCode("");
        masBinaryTree.get(0).setCount(0);
    }

}
