package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        AdaptAlgCode algCode = new AdaptAlgCode(str);
        System.out.println(algCode.getAnswer());
        //AdaptAlgDecode algDecode = new AdaptAlgDecode(algCode.getAnswer());
        //System.out.println(algDecode.getAnswer());
    }
}
