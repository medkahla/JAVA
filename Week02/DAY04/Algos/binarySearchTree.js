const { isNull } = require("util");

class BSTNode {
	constructor(val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

class BST {
	constructor() {
		this.root = null;
	}

	isEmpty() {
		return this.root === null;
	}

	getLargestFromSubtree(current) {
        if (current == undefined) {
            current = this.root;
        }
        
        if (current.right) {
            return this.getLargestFromSubtree(current.right);
        }else{
            return current.val;
        }
    }

	getSmallestFromSubtree() {
        let runner = this.root;
        if (!runner) {
         return null;
        }
        while (runner.left) {
            runner = runner.left;
        }
        return runner.val;
    }

    find(value, current){

        if (current === undefined){
            current = this.root;
        }
        if (current === null) {
            return false;
        }
        if (current.val == value) {
            console.log("found ", value," in ",current);
            return true;
        }else if (current.val>value) {
            return this.find(value, current.left);
        }else{
            return this.find(value,current.right);
        }
    }


	insert(node, current = this.root) {
		
        if (current === undefined) {
		    current = this.root;
		}
        if (this.root == null) {
            this.root=node;
        }else{

            if(node.val < current.val){
                if (current.left == null) {
                    current.left = node;
                    return;   
                }else{
                    return this.insert(node,current.left);
                }
            }
            if(node.val > current.val){
                if (current.right == null) {
                    current.right = node;
                    return;   
                }else{
                    return this.insert(node,current.right);
                }
            }
        }

	}
}

// myBst.insert(new Node(100))

// Recursion is:
// - function that calls itself
// - and modifies the inputs
// - so that the inputs lead to a 'base case' and end the recursive call

// https://www.cs.usfca.edu/~galles/visualization/BST.html
// http://btv.melezinek.cz/binary-search-tree.html

var myBST = new BST();
console.log(myBST);
myBST.insert(new BSTNode(10));
myBST.insert(new BSTNode(15));
myBST.insert(new BSTNode(5));
myBST.insert(new BSTNode(20));
myBST.insert(new BSTNode(12));
console.log(myBST);

console.log(myBST.getLargestFromSubtree());
console.log(myBST.getSmallestFromSubtree());
console.log(myBST.find(5));


/*           BST
          this.root
              |
             (10)
  node.left /   \ node.right
          (5)    (15)
         / \     /   \
              (12)   (20)
              /  \   /  \
*/

// ------------------

// function hi() {
//     console.log("hi there!");
//     hi();
// }

// hi();
//                      2 -> 3 -> .. -> 10
// function incrementTo10(num) {
// 	// 1. create defaults
// 	if (num === undefined) {
// 		num = 1;
// 	}

// 	// 2.  AS SOON AS POSSIBLE
// 	// CREATE A BREAK-POINT / BASE CASE
// 	if (num >= 10) {
// 		return;
// 	}

// 	// 3. logic
// 	num++; // 2 -> 3 -> 4 .. 10

// 	// 4. recall the function again!
// 	incrementTo10(num); //2 -> 3 4..  10
// }

// incrementTo10(3);

// 3!
// 3*2*1

// 5!
// 5*4*3*2*1

// 4!
// 4*3*2*1

// 155!
// 155*154*153..
//                  4
// function factorial(num) {
// 	// make defaults (if it applies)
// 	if (num === undefined) {
// 		num = 4;
// 	}

// 	// BASE CASE - BREAK POINT!
// 	if (num === 1) {
// 		return 1;
// 	}

// 	// LOGIC
// 	// var decrementNum = num -1;

// 	// recurse
// 	//      4   *  __________ (4 - 1)
// 	return num * factorial(num - 1);
// }
