class Node {
	constructor(data) {
		this.data = data;
		this.next = null;
	}
}

class SLL {
	constructor() {
		this.head = null;
	}
	// return true or false if this.head is null
	isEmpty() {
		return this.head == null;
	}
	// when a pointer is to the LEFT of an equal sign, we are CHANGING it
	// when a pointer is to the RIGHT of an equal sign, we are READING it

	// create a new node with given data, add it to the head. return void
	addDataToFront(data) {
		var newNode = new Node(data); // create a new node with the data
		newNode.next = this.head; // set the new node's next to the head
		this.head = newNode; // move the head to the new node
		return this; // return back the instance so we can chain methods
	}

	// ---------------------------------
	// console log (print) the value of every node in the current list
	// traversal

	// mycoolList.read()
	read() {
		var runner = this.head;
		while (runner) {
			console.log(runner.data);
			runner = runner.next;
		}
	}

	// find: return true / false if current list contains a data equal to value
	contains(value) {
		var current = this.head;
		var find = false;
		while (current) {
			if(current.data == value){
				find = true;
			}
			current = current.next;
		}
		return find;
	}

	// Remove from front: remove and return the first node in the SLL
	removeFromFront() {
		if(this.isEmpty()) return null;
		var removed = this.head;
		this.head = this.head.next;
		removed.next = null;
		return removed;
	}

    delete(data){
        if( this.isEmpty() ){
            console.log("SLL is empty");
            return;
        }

        if ( !this.contains(data) ) {
            console.log("SLL doesn't contain this value: "+data);
            return;
        }

        if (this.head.data == data) {
            this.removeFromFront();
            console.log("Deleted");
            return;
        }

        var prev = this.head;
        var current = this.head.next;
		while (current) {
			if(current.data == data){
                var removed = current;
                removed.next = null;
				prev.next = current.next;
                console.log(removed.data+" is removed");
                return;
			}
            prev = current;
			current = current.next;
		}
    }


    size(){
        var runner = this.head;
        var sllLength = 0;
		while (runner) {
            sllLength +=1;
			runner = runner.next;
		}
        return sllLength;
    }

    printSecondToLastValue(){
        if (this.size == 1) {
            console.log("SLL has a single element: "+this.head);
            return;
        }
        if (this.size == 2) {
            console.log(this.head);
            return;
        }
        var current = this.head.next;
        while (current.next) {
            if(!current.next.next){
                console.log(current.data);
                return;
            }
            current = current.next;
        }
        return;
    }

    printNthToLast(n){
        if (this.size()<n) {
            console.log("Out of SLL");
            return;
        }
        var fast = this.head
        for (let i = 0; i <= n; i++) {
            fast = fast.next
        }
        var slow = this.head
        while(fast){
            if (!fast.next) {
                console.log(slow);
                return;
            }
            fast=fast.next;
            slow=slow.next;
        }
        return;
    }

    reverse(){
        var prev = null;
        var next = null;
        var current = this.head;
        
        while (current) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next; 
        }
        this.head = prev;
    }
}

// ⚠ 1. don't forget to instantiate the Singly Linked List
var myCoolList = new SLL();
myCoolList.addDataToFront(33);
myCoolList.addDataToFront(43);
myCoolList.addDataToFront(88);
myCoolList.addDataToFront(11);
myCoolList.addDataToFront(100);
myCoolList.addDataToFront(123);
myCoolList.addDataToFront(18);
// console.log(myCoolList);
myCoolList.read();
// console.log(myCoolList.contains(11));
// console.log(myCoolList.contains(22));
// myCoolList.removeFromFront();
// myCoolList.read();
// console.log("list length: "+myCoolList.size());
// myCoolList.delete(100);
// myCoolList.read();
// myCoolList.printSecondToLastValue();
myCoolList.printNthToLast(2);
