const num1 = 8;

function recusiveSigma(n){
    if(isNaN(n)){
        return null;
    }
    const int = parseInt(n);
    if (int < 1){
        return 0;
    }
    return int + recusiveSigma(int-1);
}


console.log(recusiveSigma(num1));
console.log(recusiveSigma(5.5));