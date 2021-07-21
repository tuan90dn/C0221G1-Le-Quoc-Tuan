let fibonacci = [0, 1];
function listFibonacci(num) {
    for (let i = 2; i < num; i++) {
        fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
    }
    return fibonacci;
}
console.log(listFibonacci(20));
let sum = 0;
for (let num of listFibonacci(20)) {
    sum += num;
}
console.log("Tổng các số fibonacci là " + sum);
//# sourceMappingURL=main.js.map