class Solution {
    /**
     * @param {number[]} temperatures
     * @return {number[]}
     */
    dailyTemperatures(temperatures: number[]): number[] {
        const result = new Array<number>(temperatures.length).fill(0);
        const stack: number[] = [];

        for (let i=0; i<temperatures.length; i++) {
            while (
                stack.length > 0 
                && temperatures[i] > temperatures[stack[stack.length-1]])
                {
                    const prevDay = stack.pop()!;
                    result[prevDay] = i - prevDay;
                }

                stack.push(i);
        }

        return result;
     }
}
