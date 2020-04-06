package com.company;

/**
 * @author baojiang create on 2020/3/1.
 */
public class NumTimesAllBlue5353 {

    public static void main(String[] args) {
        int[] arr = {4,1,2,3};

        NumTimesAllBlue5353 object = new NumTimesAllBlue5353();
        Object res = object.numTimesAllBlue(arr);
        System.out.println(res);
    }



    public int numTimesAllBlue(int[] light) {
        int[] status = new int[light.length];

        int sum = 0;
        int time =0;
        int count = 0;
        for(int value:light){
            time++;
            status[value - 1] = 1;
            sum = check(status,value -1,sum);
            if(sum == time * 2) {
                count++;
            }
        }
        return count;
    }

    //handle 是数组位置
    private int check(int[] status,int handle,int presum){
        if(handle == 0){
            // 如果1 默认就是蓝色(2)
            status[handle] = 2;
            presum+=2;
            for (int i = handle + 1; i < status.length; i++) {
                if (status[i] == 0) {
                    break;
                }
                if (status[i - 1] == 2) {
                    status[i] = 2;
                    presum+=1;
                }
            }
        }else {
            //计算自己
            if (status[handle - 1] == 2) {
                status[handle] = 2;
                presum += 2;
                //更新状态

                for (int i = handle + 1; i < status.length; i++) {
                    if (status[i] == 0) {
                        break;
                    }
                    if (status[i - 1] == 2) {
                        status[i] = 2;
                        presum+=1;
                    }
                }
            } else {
                presum += 1;
            }
        }
        return presum;
    }
}
