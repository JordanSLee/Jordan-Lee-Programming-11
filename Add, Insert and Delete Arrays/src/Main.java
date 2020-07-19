import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        int[] nums = new int[5];// creates array (nums) and makes it's length 5
        for (int i = 0; i < nums.length; i++) {// "for" loop fills in the values of the length until index 5
            nums[i] = i;// makes the index and value ratio 1:1
        }
        System.out.println("The original Array: " + Arrays.toString(nums));// prints the original array
        System.out.println("The Array with the number added at the end: " + Arrays.toString(add(nums,5)));// prints the original array with a added index and value
        System.out.println("The Array with the  number removed at the end: " + Arrays.toString(delete(nums, 5)));// prints the original array with a deleted index and value
        System.out.println("The Array with the replaced number: " + Arrays.toString(insert(nums,5,3)));// prints the original array with a value inserted at index 3


    }

    public static int[] add(int[] input, int value) {// makes static method "add" to allow an array and value be input
        int[] addArray = new int[input.length + 1];// makes a new array with a length that is one greater than the original array
        for (int i = 0; i < input.length; i++) {//"for" loop fills in the values of "addArray"
            addArray[i] = input[i];// makes the values of "addArray" and "nums" equal
        }
        addArray[addArray.length-1] = value;// makes the new index at the end to be equal to the value inputted
        return addArray;// tells code that "addArray" is the method to be followed when method "add" is used
    }
    public static int[] delete(int[]input, int index){// makes static method "delete" to allow an array and value be input
        int[] minusArray = new int[input.length - 1];// makes a new array with a length that is one less than the original array
        for (int i = 0; i <minusArray.length; i++){// "for" loop fills in the values of "minusArray"
            if (i < index) {// follow the next step if i is less than the index inputted
                minusArray[i] = input[i];// makes the values of "minusArray" and "nums" equal
            }
            if (i > index) {// follow the next step if i is greater than the index inputted
                minusArray[i-1] = input[i];// makes values of "minusArray" one less than every value of the same index in "nums"
            }
        }
        return minusArray;// tells code that "minusArray" is the method to be followed when the method "delete" is used

    }
    public static int[] insert(int[]input, int value, int index){// makes static method "insert" to allow an array and value be input
        int[]insertArray = new int[input.length + 1];// makes new array with an equal length to the original array
        for (int i = 0; i < insertArray.length; i++){// "for" loop fills in the values of "insertArray"
            if (i < index  - 1)// follow the next step if i is less than the index - 1
                insertArray[i] = input[i];// makes the values of "insertArray" and "nums" equal
            else if (i == index - 1)// or follow the next step if i is equal to the index - 1
                insertArray[i] = value;// makes "insertArray"'s i value equal to the value inserted
            else// or follow the next step
                insertArray[i] = input[i-1];// makes i value of "insertArray" equal to the input's value - 1
        }
        return insertArray;// tells code that "insertArray" is the method to be followed when the method "insert" is used

    }
}
