class Solution {
     List<List<Integer>> result=new ArrayList<>();

    public void helper(int indx,int [] nums,ArrayList<Integer> arr){
      if(indx>=nums.length){
        result.add(new ArrayList<>(arr));  //jaise hi indx length k barabar hai ek subset mil gaya
        return;
      }
       arr.add(nums[indx]);    //take
       helper(indx+1,nums,arr);
       arr.remove(arr.size()-1);    //not take ,jo last add kiya hai wo remove kro
       helper(indx+1,nums,arr);
    }
    public List<List<Integer>> subsets(int[] nums) {
     ArrayList<Integer> arr=new ArrayList<>();
     helper(0,nums,arr);

     return result;


        
    }
}