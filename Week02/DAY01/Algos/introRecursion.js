function repeatHelloRecursive(n){
    if (n===1){
        return "Hello \n";
    }
    return "Hello \n"+ repeatHelloRecursive(n-1);
}

console.log(repeatHelloRecursive(5));


