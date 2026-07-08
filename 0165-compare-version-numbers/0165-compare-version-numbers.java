class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int[] ver1=new int[arr1.length];
        int[] ver2=new int[arr2.length];
        for(int i=0;i<arr1.length;i++){
            ver1[i]=Integer.parseInt(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            ver2[i]=Integer.parseInt(arr2[i]);
        }
        int length=arr2.length-arr1.length;
        for(int i=0;i<Math.min(arr1.length,arr2.length);i++){
            if(ver1[i]>ver2[i]){
                return 1;
            }else if(ver1[i]<ver2[i]){
                return -1;
            }
        }
        if(length>0){
            for(int i=arr1.length;i<arr2.length;i++){
                if(ver2[i]>0){
                    return -1;
                }
            }
        }else if(length<0){
           for(int i=arr2.length;i<arr1.length;i++){
                if(ver1[i]>0){
                    return 1;
                }
            } 
        }

    return 0;
    }
}