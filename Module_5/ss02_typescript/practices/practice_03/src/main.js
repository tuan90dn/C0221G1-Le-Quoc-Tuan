// function isPrime(number: number): boolean {
//     let isPrime = true;
//     if (number < 2) {
//         isPrime = false;
//     } else if (number > 2) {
//         for (let i = 2; i <= Math.sqrt(number); i++) {
//             if (number % i == 0) {
//                 isPrime = false;
//                 break;
//             }
//         }
//     }
//     return isPrime;
// }
// let array = [1, 5, 9, 2, 6, 15, 19, 35, 51, 53];
// let sum = 0;
// for (let number of array) {
//     if (isPrime(number)) {
//         sum += number;
//     }
// }
// console.log("Tổng các số nguyên tố trong mảng trên là: " + sum);
var fibonacci = [0, 1];
// console.log(fibonacci);
function listFibonacci(num) {
    for (var i = 2; i < num; i++) {
        fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
    }
    return fibonacci;
}
console.log(listFibonacci(10));
