package com.newcoder.huawei;

import java.util.Scanner;

/**
 * @author ghower
 * @date 2022/3/25 9:30
 */
public class HJ2JiSuanMouZiFuChuXianCiShu {
    // 655b203khDc79w76239SC60Yx5O634244O8oNKw2g5c12
    // 2dt9M17197FQ9fR0fC8619q00cC156NJQ958ZAH8qe76G
    // 024Xvy74ETiO10WgQmOuNx104B9L8Euod682x6hVX941D
    // UalUwb20nyD6IX6IM57Jvypu2mtZ8fpk9Z72AU9g0zob3
    // 2W7J427VT50P7x40d6QF1067yYMioy6E037e2fTDTse6Z
    // 983873849KSB3t93t1wR14717iDi9ybw76h9410q345Z4
    // 882zWY3v7C0jD33NlLiF53Hp69067Dzvu1s4Er0G24Mhc
    // AHEq151Y339jyfbP6w9j1dX72DEv7L02764f2K7XVf7tW
    // NYGqU5iNlS5RpV619vg7zR96D8jMsO5xN223W97CMuHHW
    // BX806AD732q42h1bwpSb923V3Q73D3g3O0100tk948693
    // d67nxrd7LB6He5O9qG2i9xJ0U1x9054y20039V9uD61HF
    // 9eP825JJ79M200X3zH1pW99QeG40kR4275p5P96S3J6mj
    // 60z278C1K685As6CX35rcY70qI5810i3rt5WB1C6H7411
    // 8433Z8wsfE9s2M82q7TN7Q6Zz3047W99g56kLK58NqPfS
    // uhSfEs0W4u1D720A3jqpG7aD0Be3N18395zS037T0Rg47
    // K3O90H5w5660bNW58O8TK3l38xyN7R36kH4l21VYDx3wa
    // ZK8kf5O3ySWJQdN7eVnf778GIa70Fan34v0owxkg4N5ke
    // Nbaxh044l67Vimm110i7N8614Xj4667rQd6R67aHlm5z6
    // N51jtbAm22305l9p83Uu6l8pBOaxQL56c5M76SUUKv953
    // 8FVD28WT1046sPQ1eHf5e65tk3Q6Lub314FBNv2C4Q12e
    // 6oPcX95jC06g8oFj7q7V20ciEO73m00U8v8342H1w86yS
    // 298r094x2y8O24e8p6j685D9a539930DQ6s6813uF8D34
    // i6E1x5j2v9
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char c = in.next().charAt(0);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 基础
//            if( ch <= '9' && ch >= '0' &&  ch == c){
//                res++;
//            }else if(ch <= 'Z' && ch >= 'A' && (ch == c || ch + 32 == c)){
//                res++;
//            }else if(ch <= 'z' && ch >= 'a' && (ch == c || ch - 32 == c)){
//                res++;
//            }

        }
        System.out.println(res);
    }
}
