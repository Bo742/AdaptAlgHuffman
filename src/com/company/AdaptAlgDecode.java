package com.company;

import java.util.ArrayList;

public class AdaptAlgDecode {
    private ArrayList<BinaryTree> masBinaryTree = new ArrayList<>();
    private String answer = "";
    private String codeString = "";

    public AdaptAlgDecode(String codeString){
        createSpecialSymbol();
        this.codeString=codeString;
        getFirstSymbol();
        createFirstBinaryTree(answer);
        sortBinaryTree();
        changeCount();
        updateCode();
        while (codeString.length()>0){
            decodeAlg();
        }

    }

    public void decodeAlg(){
        int lengthSpecialSymbol = masBinaryTree.get(masBinaryTree.size()-1).getCode().length();
        String[] strSymbol = codeString.split("");
        String strSpecial = "";
        for (int i = 0; i < lengthSpecialSymbol ; i++) {
            strSpecial=strSpecial+strSymbol[i];
        }
        codeString="";
        if (strSpecial.equals(masBinaryTree.get(masBinaryTree.size()-1).getCode())){
            codeString="";
            for (int i = lengthSpecialSymbol; i < strSymbol.length; i++) {
                codeString = codeString + strSymbol[i];
            }
            getFirstSymbol();
            String[] str = answer.split("");
            createFirstBinaryTree(str[str.length-1]);
            sortBinaryTree();
            changeCount();
            updateCode();
        }
        else {

        }
    }

    public void updateCode(){
        for (int i = 0; i <masBinaryTree.size() ; i++) {
            if(masBinaryTree.get(i).getLeftChild()!=null){
                masBinaryTree.get(i).getLeftChild().setCode(masBinaryTree.get(i).getCode()+"0");
                masBinaryTree.get(i).getRightChild().setCode(masBinaryTree.get(i).getCode()+"1");
            }
        }
    }

    public void createFirstBinaryTree(String symbol){
        masBinaryTree.add(new BinaryTree());
        masBinaryTree.get(masBinaryTree.size()-1).setCount(1);
        masBinaryTree.get(masBinaryTree.size()-1).setSymbol(symbol);

        masBinaryTree.add(new BinaryTree());
        masBinaryTree.get(masBinaryTree.size()-1).setLeftChild(masBinaryTree.get(masBinaryTree.size()-2));
        masBinaryTree.get(masBinaryTree.size()-1).setRightChild(masBinaryTree.get(masBinaryTree.size()-3));
        masBinaryTree.get(masBinaryTree.size()-1).changeCount();
        masBinaryTree.get(masBinaryTree.size()-1).getLeftChild().setNumberParent(masBinaryTree.size()-1);
        masBinaryTree.get(masBinaryTree.size()-1).getLeftChild().setItsLeftCHild(1);
        masBinaryTree.get(masBinaryTree.size()-1).getLeftChild().setItsRightChild(0);
        masBinaryTree.get(masBinaryTree.size()-1).getRightChild().setNumberParent(masBinaryTree.size()-1);
        masBinaryTree.get(masBinaryTree.size()-1).getRightChild().setItsRightChild(1);
        masBinaryTree.get(masBinaryTree.size()-1).getRightChild().setItsLeftCHild(0);
        masBinaryTree.get(masBinaryTree.size()-1).setSymbol("");
        masBinaryTree.get(masBinaryTree.size()-1).setCode("");
        masBinaryTree.get(masBinaryTree.size()-1).setNumberParent(-1);
    }
    public void getFirstSymbol(){

        String[] strSymbol = codeString.split("");
        String symbol = "";
        codeString="";
        for (int i = 8; i < strSymbol.length ; i++) {
            codeString=codeString+strSymbol[i];
        }
        for (int i = 0; i < 8 ;i++){
            symbol=symbol+strSymbol[i];
        }
        int s = Integer.parseInt(symbol,2);
        char ch = (char)s;
        answer=answer+ch;
    }

    public String getAnswer(){
        return answer;
    }

    public void toSwap(int first,int second){
        BinaryTree swap = masBinaryTree.get(first);
        masBinaryTree.set(first,masBinaryTree.get(second));
        masBinaryTree.set(second,swap);
    }

    public void changeCount(){
        for (int i = masBinaryTree.size()-1; i >-1 ; i--) {
            masBinaryTree.get(i).changeCount();
        }
    }

    public void sortBinaryTree(){
        for (int i = masBinaryTree.size()-1; i >=1 ; i--) {
            for (int j = 0; j<i ; j++) {
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

        for (int i = masBinaryTree.size()-1; i >=1 ; i--) {
            for (int j = 0; j<i ; j++) {
                if(masBinaryTree.get(j).getNumberParent()==masBinaryTree.get(j+1).getNumberParent()){
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
        }

        for (int i = masBinaryTree.size()-1; i >=1 ; i--) {
            for (int j = 0; j<i ; j++) {
                if(masBinaryTree.get(j).getNumberParent()==masBinaryTree.get(j+1).getNumberParent()){
                    if(masBinaryTree.get(j).getItsLeftCHild()<masBinaryTree.get(j+1).getItsLeftCHild()){
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

    public void checkOrder(){
        for (int i = 0; i < masBinaryTree.size() ; i++) {
            for (int k = 0; k <masBinaryTree.size() ; k++) {
                changeCount();
                sortBinaryTree();
                if (checkLeaf(k)) {
                    for (int j = 1; j < k+1; j++) {
                        if (masBinaryTree.get(j).getCount() < masBinaryTree.get(k).getCount()) {
                            if (masBinaryTree.get(j).getLeftChild() != null) {
                                masBinaryTree.get(j).getLeftChild().setNumberParent(k);
                                masBinaryTree.get(j).getRightChild().setNumberParent(k);
                            }
                            int l = masBinaryTree.get(j).getItsLeftCHild();
                            int r = masBinaryTree.get(j).getItsRightChild();
                            masBinaryTree.get(j).setItsLeftCHild(masBinaryTree.get(k).getItsLeftCHild());
                            masBinaryTree.get(j).setItsRightChild(masBinaryTree.get(k).getItsRightChild());
                            masBinaryTree.get(k).setItsLeftCHild(l);
                            masBinaryTree.get(k).setItsRightChild(r);

                            int p = masBinaryTree.get(j).getNumberParent();
                            masBinaryTree.get(j).setNumberParent(masBinaryTree.get(k).getNumberParent());
                            masBinaryTree.get(k).setNumberParent(p);

                            if (masBinaryTree.get(k).getItsLeftCHild() == 1) {
                                masBinaryTree.get(masBinaryTree.get(k).getNumberParent()).setLeftChild(masBinaryTree.get(k));
                            }

                            if (masBinaryTree.get(k).getItsRightChild() == 1) {
                                masBinaryTree.get(masBinaryTree.get(k).getNumberParent()).setRightChild(masBinaryTree.get(k));
                            }

                            if (masBinaryTree.get(j).getItsLeftCHild() == 1) {
                                masBinaryTree.get(masBinaryTree.get(j).getNumberParent()).setLeftChild(masBinaryTree.get(j));
                            }

                            if (masBinaryTree.get(j).getItsRightChild() == 1) {
                                masBinaryTree.get(masBinaryTree.get(j).getNumberParent()).setRightChild(masBinaryTree.get(j));
                            }

                            toSwap(j, k);
                        }
                    }
                    for (int j = k + 1; j < masBinaryTree.size() - 2; j++) {
                        if (masBinaryTree.get(j).getCount() > masBinaryTree.get(k).getCount()) {
                            if (masBinaryTree.get(j).getLeftChild() != null) {
                                masBinaryTree.get(j).getLeftChild().setNumberParent(k);
                                masBinaryTree.get(j).getRightChild().setNumberParent(k);
                            }
                            int l = masBinaryTree.get(j).getItsLeftCHild();
                            int r = masBinaryTree.get(j).getItsRightChild();
                            masBinaryTree.get(j).setItsLeftCHild(masBinaryTree.get(k).getItsLeftCHild());
                            masBinaryTree.get(j).setItsRightChild(masBinaryTree.get(k).getItsRightChild());
                            masBinaryTree.get(k).setItsLeftCHild(l);
                            masBinaryTree.get(k).setItsRightChild(r);

                            int p = masBinaryTree.get(j).getNumberParent();
                            masBinaryTree.get(j).setNumberParent(masBinaryTree.get(k).getNumberParent());
                            masBinaryTree.get(k).setNumberParent(p);

                            if (masBinaryTree.get(k).getItsLeftCHild() == 1) {
                                masBinaryTree.get(masBinaryTree.get(k).getNumberParent()).setLeftChild(masBinaryTree.get(k));
                            }

                            if (masBinaryTree.get(k).getItsRightChild() == 1) {
                                masBinaryTree.get(masBinaryTree.get(k).getNumberParent()).setRightChild(masBinaryTree.get(k));
                            }

                            if (masBinaryTree.get(j).getItsLeftCHild() == 1) {
                                masBinaryTree.get(masBinaryTree.get(j).getNumberParent()).setLeftChild(masBinaryTree.get(j));
                            }

                            if (masBinaryTree.get(j).getItsRightChild() == 1) {
                                masBinaryTree.get(masBinaryTree.get(j).getNumberParent()).setRightChild(masBinaryTree.get(j));
                            }

                            toSwap(j, k);
                        }
                    }
                }
            }

        }
    }

    public boolean checkLeaf(int i){
        return masBinaryTree.get(i).getLeftChild()==null;
    }
    public void createSpecialSymbol(){
        masBinaryTree.add(new BinaryTree());
        masBinaryTree.get(0).setSymbol("ESC");
        masBinaryTree.get(0).setCode("");
        masBinaryTree.get(0).setCount(0);
    }
}
