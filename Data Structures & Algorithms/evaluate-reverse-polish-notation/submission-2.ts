class Solution {
    /**
     * @param {string[]} tokens
     * @return {number}
     */
    evalRPN(tokens: string[]): number {
        const nums: number[] = [];

        for (const token of tokens) {
            if (
                token !== "+" &&
                token !== "-" &&
                token !== "*" &&
                token !== "/"
            ) {
                nums.push(Number(token));
                continue;
            }

            const right = nums.pop();
            const left = nums.pop();

            if (token === "+") {
                nums.push(left + right);
            } else if (token === "-") {
                nums.push(left - right);
            } else if (token === "*") {
                nums.push(left * right);
            } else {
                nums.push(Math.trunc(left / right));
            }

        }

        return nums.pop();
    }
}
