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
}

// ⚠ 1. don't forget to instantiate the Singly Linked List
var myCoolList = new SLL();
myCoolList.addDataToFront(33);
myCoolList.addDataToFront(11);
myCoolList.addDataToFront(100);
console.log(myCoolList);
myCoolList.read();
console.log(myCoolList.contains(11));
console.log(myCoolList.contains(22));
myCoolList.removeFromFront();
myCoolList.read();