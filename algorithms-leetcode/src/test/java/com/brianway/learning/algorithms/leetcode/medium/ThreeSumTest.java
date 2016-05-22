package com.brianway.learning.algorithms.leetcode.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Brian on 2016/4/30.
 */
public class ThreeSumTest {

    private ThreeSum testObject;

    int []nums ;
    ArrayList<ArrayList<Integer>> result ;//= new ArrayList<ArrayList<Integer>>();


    //int [][] nums_array = new int[][]{
    //
    //};
    //int [] result_array = new int[]{0,1,0,2,0,2};
    @Before
    public void SetUp(){
        nums = new int[]{1, -1, -1, 2,0,1};
        int [][] array = {
                {-1,-1,2},
                {-1,0,1}
        };
        result=getArrayList(array);
        testObject =  new ThreeSum().new ThreeSum0();
    }

    private ArrayList<ArrayList<Integer>> getArrayList(int [][] array){
        ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<array.length;i++){
            ArrayList<Integer> match = new ArrayList<Integer>(3);
            match.add(array[i][0]);
            match.add(array[i][1]);
            match.add(array[i][2]);
            all.add(match);
        }
        return all;
    }


    @Test
    public void testThreeSum(){
        Assert.assertEquals(result,testObject.threeSum(nums));
    }




}
