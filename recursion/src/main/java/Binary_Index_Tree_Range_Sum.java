public class Binary_Index_Tree_Range_Sum {
    static int bit[] = new int[100005];

    /**
     *  Does Array[idx]+=val
     * @param idx : Index which needs to be updated
     * @param val : value which needs to be updated
     */
    static void update(int idx,int val) //Operation takes logn complexity where n is size of array in this case 100005
    {
       for(;idx<100005;idx+=(idx&(-idx)))
       {
           bit[idx]+=val;
       }
    }

    /**
     *  return Array[1]+Array[2]......Array[idx]
     * @param idx - index
     * @return
     */
    static int getSum(int idx) //Operation takes logn complexity where n is size of array in this case 100005
    {
        int sum = 0;
        for(;idx>0;idx-=(idx&(-idx))){
            sum += bit[idx];
        }
        return sum;
    }

    public static void main(String[] args) {
        int input[] = new int[10];
        input[1]=2;
        update(1,2);
        input[2]= 5;
        update(2,5);
        input[3] = 6;
        update(3,6);
        input[4]=2;
        update(4,2);
        //Input Array is [2,5,6,2]
        System.out.println(getQuerySum(2,4));// 1 based indexing [5,6,2]
        update(2,9-5); //New update will be old value - new value
        //Input Array is now [2,9,6,2]
        System.out.println(getQuerySum(2,4));// 1 based indexing [9,6,2]
        update(3,2-6);
        //Input Array is now [2,9,2,2]
        System.out.println(getQuerySum(2,4));// 1 based indexing [9,2,2]
        System.out.println(getQuerySum(2,3));//1 based indexing [9,2]
        System.out.println(getQuerySum(1,3));//1 based indexing [2,9,2]


    }

    private static int getQuerySum(int l, int r) {
        return getSum(r)-getSum(l-1);
    }


}
