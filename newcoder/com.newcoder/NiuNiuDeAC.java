package com.newcoder;

/**
 * @author ghower
 * @date 2022/3/24 17:08
 */
public class NiuNiuDeAC {
    public int Solve (int k, String s) {
        // write code here
        if(s.isEmpty()){
            return 0;
        }
        int res = 1;
        int left = 0,right = 0;
        int aNum = s.charAt(0) == 'A' ? 1:0;
        int cNum = s.charAt(0) == 'C' ? 1:0;

        while(right < s.length()-1){
            if(aNum > k && cNum > k){
                if(s.charAt(left) == 'A'){
                    --aNum;
                }else{
                    --cNum;
                }
                ++left;
            }else{
                res = Math.max(res,right - left +1);
                ++right;
                if(s.charAt(right) == 'A'){
                    ++aNum;
                }else{
                    ++cNum;
                }
            }
        }
        return res;
    }
}
