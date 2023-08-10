const nums1 = [1, 3, 5, 6];
const search1 = 4;

const nums2 = [4, 5, 6, 8, 12];
const search2 = 5;


//Itiratif
function binarySearch(arrNums, searchNum){
   var leftIdx = 0;
   var rightIdx = arrNums.length -1;
   while (leftIdx <= rightIdx) {
    var mid = Math.floor((rightIdx+leftIdx) / 2);
    if (arrNums[mid]===searchNum) {
        return true;
    }
    if (searchNum < arrNums[mid]) {
        rightIdx = mid-1;
    } else {
        leftIdx = mid +1;
    }
   }
   return false;
}


//Recursif
function binarySearchRec(arrNums, searchNum, left=0, right=arrNums.length-1) {
    const mid = Math.floor((right + left) /2);
    if (left>right) {
        return false;        
    } else if (arrNums[mid]>searchNum) {
        return binarySearchRec(arrNums, searchNum, left, right = mid-1);   
    }else{
        return binarySearchRec(arrNums, searchNum, left = mid+1, right);
    }
}

console.log(binarySearch(nums1,search1));
console.log(binarySearch(nums2,search2));
console.log(binarySearchRec(nums1,search1));
console.log(binarySearchRec(nums2,search2));