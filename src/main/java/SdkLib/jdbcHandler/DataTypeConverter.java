/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SdkLib.jdbcHandler;

/**
 *
 * @author priya
 */
public class DataTypeConverter {
    public int StringToInt(String S){
        return Integer.parseInt(S);
    }
    
    public double StringToDouble(String S){
        return Double.parseDouble(S);
    }
    
    public float StringToFloat(String S){
        return Float.parseFloat(S);
    }
    
    public String toString(int num){
        return num+"";
    }
    public String toString(double num){
        return num+"";
    }
    
    public String toString(float num){
        return num+"";
    }
    public int[] StringArrayToIntArray1D(String[] S){
        int[] IntArray=new int[S.length];
        for(int i=0;i<S.length;i++)
        {
            IntArray[i]=StringToInt(S[i]);
        }
        return IntArray;
    }
    
    public double[] StringArrayToDoubleArray1D(String[] S){
        double[] IntArray=new double[S.length];
        for(int i=0;i<S.length;i++)
        {
            IntArray[i]=StringToDouble(S[i]);
        }
        return IntArray;
    }
    
    public float[] StringArrayToFloatArray1D(String[] S){
        float[] IntArray=new float[S.length];
        for(int i=0;i<S.length;i++)
        {
            IntArray[i]=StringToFloat(S[i]);
        }
        return IntArray;
    }
    
    public String[] intToStringArray(int[] arr){
        String[] str=new String[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            str[i]=toString(arr[i]);
        }
        return str;
    }
    
    public String[] DoubleToStringArray(double[] arr){
        String[] str=new String[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            str[i]=toString(arr[i]);
        }
        return str;
    }
    
    public String[] FloatToStringArray(float[] arr){
        String[] str=new String[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            str[i]=toString(arr[i]);
        }
        return str;
    }
}
